package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.UserVo;


public interface UserDao {
	
	//단일회원 조회
	UserVo selectUser(String key, String value);
	
	//회원삽입
	void insertUser(UserVo user);
	
	//전체회원 조회
	ArrayList<UserVo> selectUserList();

	//로그인1
	ArrayList<UserVo> selectUser(HashMap<String, String> param);
	
	//유저로그인
	UserVo loginselectUser(String key, String id , String password);
	
	//관리자로그인
//	UserVo adminloginselectUser(String key, String id , String password);
	
	
}
