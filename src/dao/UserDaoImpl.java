package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.Database;
import data.Session;
import vo.UserVo;

public class UserDaoImpl implements UserDao {
	Database database = Database.getInstance();

	public void insertUser(UserVo user) {
		
		database.tb_user.add(user);
		
	}

	@Override
	public UserVo selectUser(String key, String value) {
		for(int i = 0 ; i<database.tb_user.size(); i++){
			UserVo user = database.tb_user.get(i); //검사할 지역변수생성
			
			if(key.equals("ID")){ 
				if(user.getId().equals(value)){ // 입력한 이름이 데이터베이스의 이름과 일치하면 일치하는 이름 출력 
					return user;
				}
			}else if(key.equals("NAME")){
				if(user.getName().equals(value)){
					return user;
				}
			}else if(key.equals("EMAIL")){
				if(user.getEmail().equals(value)){
					return user;
				}
			}else if(key.equals("PASSWORD")){
				if(user.getPassword().equals(value)){
					return user;
				}
			}
		}
	
		return null;
	}
	
	@Override
	public UserVo loginselectUser(String key, String id,String password){
		boolean flag = false;
		for(int i = 0 ; i< database.tb_user.size(); i++){
			UserVo user = database.tb_user.get(i); //검사할 지역변수생성
			
			if (key.equals("ID")) {
				if (user.getId().equals(id)) {
						flag = true;
					if (user.getPassword().equals(password)) {
						Session.loginUser = database.tb_user.get(i);
						System.out.println(user.getId()+"님이 접속하셨습니다");
						return null;
					}else {
							System.out.println("비밀번호가 틀립니다.");
							return null;
					}
				}
			}
		}
		if(flag == false){
		System.out.println("아이디가 존재하지 않습니다.");
		return null;
		}
		return null; 
	}

	@Override
	public ArrayList<UserVo> selectUserList() { // 데이터베이스의 모든 내용을 반환 
		
		return database.tb_user;
	}
	
	
	//다수조건 검색(and)
	public ArrayList<UserVo> selectUser(HashMap<String, String> param) {
		ArrayList<UserVo> rtnList = new ArrayList<UserVo>();
		for (int i = 0; i < database.tb_user.size(); i++) {
			UserVo user = database.tb_user.get(i);
			boolean flag = true;
			Iterator<String> itr = param.keySet().iterator();
			while (itr.hasNext()) {
				String key = itr.next();
				String value = param.get(key);
				if (key.equals("ID")) {
					if (!user.getId().equals(value)) {
						flag = false;
					}

				}
			}
			if(flag){
				rtnList.add(user);
			}
		}
		return rtnList;
	}




}
