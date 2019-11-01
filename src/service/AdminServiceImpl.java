package service;


import java.util.ArrayList;
import java.util.Scanner;

import vo.UserVo;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Database;

public class AdminServiceImpl implements AdminService{
	
	private static AdminServiceImpl instance;

	   private AdminServiceImpl() {
	   }

	   public static AdminServiceImpl getInstance() {
	      if (instance == null) {

	         instance = new AdminServiceImpl();
	      }
	      return instance;

	   }
	   
	   UserDao userDao = new UserDaoImpl();
	
	   Database database = Database.getInstance();
	//관리자 로그인 정보
	@Override
	public void adminjoin() {
//		UserDao userDao = new UserDaoImpl();
//		
//		String id = "admin";
//		
//		String password ="admin123";
//		
//		String name ="관리자";
//		
//		UserVo user = new UserVo();
//		
//		user.setId(id);
//		user.setPassword(password);
//		user.setName(name);
//		user.setGrade(1);
//		
//		UserVo userCheck = userDao.selectUser("ID",user.getId()); //WHERE ID = 'user_id'
//		
//		if(userCheck == null){
//			userDao.insertUser(user);
//		}else{
//			System.out.println("아이디중복");	
//		}		
	}
	
	//관리자 로그인
	@Override
	public void adminlogin(){
		Scanner s = new Scanner(System.in);
		System.out.println("**** && 관리자 로그인 && ****");
		System.out.println("ID : ");
		String id = s.nextLine();
		System.out.println("PASSWORD : ");
		String password = s.nextLine();
		System.out.println("######################");
		/*
		UserVO user = new UserVO();
		
		user.setId(id);
		user.setPassword(password);*/
		
		userDao.loginselectUser("ID", id, password); //WHERE ID = 'user_id'
		
//		UserVo userCheck = 
	}
	
	
		//회원목록 리스트
		
	@Override
		public void userList(){
			ArrayList<UserVo> userList = userDao.selectUserList();
			System.out.println("***** && 회 원 목 록 && *****");
//			System.out.println("-----------------------------------------");
			System.out.println("ID\tNAME\tGRADE\t");
			for(UserVo user : userList){
				
				System.out.println(user.getId() + " \t" + user.getName() + "\t" + user.getGrade());
				
			}
		
	}
}
