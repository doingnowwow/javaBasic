package service;

public interface BusLineService { //노선관리(관리자만 사용)
	void timeAdd(); //시간표 추가
	
	void timeDelete(); //시간표 삭제
	
	void timeModify(); //시간표 수정
	
	void timeList(); //시간표 출력
	
	void terminalAdd(); //터미널 추가
	
	void terminalDelete(); //터미널 삭제
	
	void terminalModify(); //터미널 수정
	
	void terminalList();
}
