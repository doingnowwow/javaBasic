package service;

public interface NoticeService { //공지사항
	
	void noticeList(); //공지사항 게시글 목록 출력
	
	void noticeContent(); //공지사항 선택 후 내용 확인
		
	void noticeAdd(); //공지사항 추가(관리자만)
	
	void noticeDelete(); //공지사항 삭제(관리자만)
	
	void noticeModify(); //공지사항 수정(관리자만)
}
