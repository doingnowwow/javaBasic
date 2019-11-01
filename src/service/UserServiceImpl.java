package service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.UserVo;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Database;
import data.Session;



public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	private static UserServiceImpl instance;

	   private UserServiceImpl() {
	   }

	   public static UserServiceImpl getInstance() {
	      if (instance == null) {

	         instance = new UserServiceImpl();
	      }
	      return instance;

	   }
	   
	   Database database = Database.getInstance();
	@Override
	public void join(){ 
		
		String id;
		String password;
		String email;
		String name;
//		String grade;
		
		//아이디
		while (true) {
		Scanner s = new Scanner(System.in);
		System.out.println("*****&& 회 원 가 입 &&*****");
		System.out.println("ID : ");
		
		boolean no = false;
		id = s.nextLine();
		no = ok(id);
		
		if(no){ 
			break;
		} else {
			System.out.println("오류 : 영문(대소문자),숫자만 입력 가능 3~11자리까지 입력하세요");
			continue;
		}
		}
		//비밀번호
		while (true) {
		Scanner s = new Scanner(System.in);
		System.out.println("PASSWORD : ");
		password = s.nextLine();
		boolean no = false;
		no = nk(password);
		
		if(no){ 
			break;
		} else {
			System.out.println("오류 : 영문(소문자) ,숫자 6자리 이상 11자리 이하로 만드시오");
			continue;
		}
		
		}
		//이메일
		while (true) {
			Scanner s = new Scanner(System.in);
			System.out.println("E-mail : ");
			email = s.nextLine();
			boolean no = false;
			no = hk(email);
			
			if(no){ 
				break;
			} else {
				System.out.println("오류 : 영문(대,소문자) 6자리이상 @naver.com 이와같은 형식으로 써주세요");
				continue;
			}
			
			}
		//이름
		while (true) {
		Scanner s = new Scanner(System.in);
		System.out.println("이름: ");
		name = s.nextLine();
		boolean no = false;
		no = mk(name);
		
		if(no){ 
			break;
		} else {
			System.out.println("ERROR(한글 2 ~ 10 자리까지 입력가능합니다.)");
			continue;
		}
		}
		
		UserVo user = new UserVo();
		
		user.setId(id);
		user.setPassword(password);
		user.setEmail(email);
		user.setName(name);
//		user.setGrade(0);
		
		UserVo userIdCheck = userDao.selectUser("ID",user.getId()); //WHERE ID = 'user_id'
		
		//UserVO userEmailCheck = userDao.selectUser("EMAIL",user.getEmail()); 
		if(userIdCheck == null ){
			userIdCheck = userDao.selectUser("EMAIL",user.getEmail());
			if(userIdCheck == null ){
			userDao.insertUser(user);	
			}else{
				System.out.println("이메일중복");
			}
		}else{
			System.out.println("아이디중복");
		}
	}
	private boolean hk(String email) {
		
		Pattern p = Pattern
				.compile("\\w{6,20}@[a-zA-Z]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))$");
		Matcher m = p.matcher(email);
		
		if (m.find()) {
			return true;
		} else {
		return false;
		}
	}
	//아이디 유효성검사
	private boolean ok(String id) {
		
		
		Pattern p = Pattern
				.compile("[a-zA-Z0-9]{4,12}");

		Matcher m = p.matcher(id);

		if (m.find()) {
			return true;
		} else {
		return false;
		}
	}
	//비밀번호 유효성검사
	private boolean nk(String password) {
		
		
		Pattern p = Pattern
				.compile("[a-zA-Z0-9]{6,11}");

		Matcher m = p.matcher(password);

		if (m.find()) {
			return true;
		} else {
		return false;
		}
	}
	//이름 유효성검사
	private boolean mk(String name) {
		
		
		Pattern p = Pattern
				.compile("^[가-힣]{2,10}$");

		Matcher m = p.matcher(name);

		if (m.find()) {
			return true;
		} else {
		return false;
		}
	}
	


	@Override
	public void login() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("****** && 로 그 인 && ******");
		System.out.print("ID : ");
		String id = s.nextLine();
		System.out.print("PASSWORD : ");
		String password = s.nextLine();
		System.out.println("######################");
		/*
		UserVO user = new UserVO();
		
		user.setId(id);
		user.setPassword(password);*/
		
		userDao.loginselectUser("ID", id, password); //WHERE ID = 'user_id'
		
//		UserVo userCheck = 
	}

	@Override
	public void logout() {
		Session.loginUser = null;
		System.out.println("로그아웃되셨습니다.");
	}
	
	

	@Override
	public void passwordfind() { //비밀번호 찾기
		String findid = "";
		String findemail="";
		String password="";
		
		
		boolean no = false;
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("###### § 비 밀 번 호 찾 기 § #####");
		System.out.println("비밀번호를 찾으실 아이디를 입력하세요: ");
		findid = s.nextLine();
		System.out.println("이메일을 입력하세요: ");
		findemail = s.nextLine();
		boolean flagid = false;
		boolean flagem = false;
		
		for(int i = 0; i < database.tb_user.size(); i++){
			
			if (database.tb_user.get(i).getId().equals(findid)) {
				flagid = true;
				if (database.tb_user.get(i).getEmail().equals(findemail)) {
					flagem = true;
					System.out.println(database.tb_user.get(i).getId()  +"님 변경하실 비밀번호를 입력해주세요");
					password = s.nextLine();
					no = nk(password);
					if(no){
						database.tb_user.get(i).setPassword(password);
						System.out.println("비밀번호 변경이 완료 되었습니다.");

					}else {
						System.out.println("ERROR : 영문(소문자) ,숫자 6자리 이상 11자리 이하로 만드시오");
						
					}
					
				}

			}

		}
		if (flagid == false) {
			// if(flagid == false){
			System.out.println("일치하는 아이디가 없습니다");
		}

		else if (flagem == false) {
			// if(flagid == true){
			System.out.println("아이디와 이메일이 일치하지 않습니다.");

		}

	}




	}

	

								
							
	