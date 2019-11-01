package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.ReserveVo;
import vo.SeatReserVo;
import vo.SeatVo;
import vo.TerminalVo;
import vo.TimetableVo;
import vo.UserVo;

public interface ReservationDao { //예매하기 관련
	
	ArrayList<TerminalVo> selectTerminal(); //터미널을 선택하기 위해 목록 조회
	
	TimetableVo selectUser(String key, String value);
	
	ArrayList<TimetableVo> selectTimetable(HashMap<String, String> param);   //시간표 선택하기 위해 목록 출력 

	
	
	ArrayList<SeatVo> selectSeat(); //좌석 선택하기 위해 목록 출력
	
	
	//예약삽입
	void insertReserve(ReserveVo reseve);
	
	//예약내역 조회
	ArrayList<ReserveVo> selectReserveList();

	void insertSeat(SeatReserVo seatreserve);  //a1 
	
	
	void insertSeat(SeatVo seatvo);   //보여지는 좌석 

	ArrayList<SeatVo> selectSeat(String[][] seat);


	ArrayList<SeatReserVo> selectSeatList();


	
}
