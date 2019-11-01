package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import service.NoticeService;
import vo.NoticeVo;


public interface NoticeDao { //공지사항 관련

	NoticeVo selecNotice(String key, int value) ; // 게시글 선택 후 조회
	
	ArrayList<NoticeVo> selectNoticeList(); //전체게시글 출력
	
	void insertNotice(NoticeVo nv); //공지사항 추가
	
	void deleteNotice(int nv); //공지사항 삭제
	
	void modifyNotice(NoticeVo nv); //공지사항 수정

//	NoticeVo selecNotice(String key, int value);

	


}
