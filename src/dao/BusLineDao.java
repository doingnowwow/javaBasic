package dao;

import java.util.ArrayList;

import vo.TerminalVo;
import vo.TimetableVo;

public interface BusLineDao { //버스노선 관련

	void insertTime(TimetableVo ttv); //시간표 삽입
	
	void deleteTime(int ttnum); //시간표 삭제
	
	void modifyTime(TimetableVo ttv); //시간표 수정
	
	ArrayList<TimetableVo> selectTimetableList(); //시간표 목록(관리자)
	
	void insertTerminal(TerminalVo tv); //터미널 삽입
	
	void deleteTerminal(int tnum); //터미널 삭제
	
	void modifyTerminal(TerminalVo tv); //터미널 수정
	
	ArrayList<TerminalVo> selectTerminalList(); //터미널 목록(관리자)
}
