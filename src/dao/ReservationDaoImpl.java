package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.BusVo;
import vo.ReserveVo;
import vo.SeatReserVo;
import vo.SeatVo;
import vo.TerminalVo;
import vo.TimetableVo;
import data.Database;

public class ReservationDaoImpl implements ReservationDao {
	
	private static ReservationDaoImpl   instance;

	private ReservationDaoImpl () {
	}

	public static ReservationDaoImpl getInstance() {
		if (instance == null) {
			instance = new ReservationDaoImpl ();
		}
		return instance;

	}

	Database database = Database.getInstance();
	
	

	@Override
	public ArrayList<TerminalVo> selectTerminal() {
		
		
		return null;
	}

	@Override
	public TimetableVo selectUser(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TimetableVo> selectTimetable(HashMap<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SeatVo> selectSeat() {
		// TODO Auto-generated method stub
		return database.tb_seat;
	}
	
	public void insertSeat(SeatVo seatvo) {
		database.tb_seat.add(seatvo);
	}
	
	public void insertSeat(SeatReserVo seatreserve) {
		database.tb_seatreser.add(seatreserve);
	}
	
	@Override
	public void insertReserve(ReserveVo reseve) {

		database.tb_reserve.add(reseve);
	}

	@Override
	public ArrayList<ReserveVo> selectReserveList() {
		// TODO Auto-generated method stub
		return database.tb_reserve;
	}
	
	@Override
	public ArrayList<SeatReserVo> selectSeatList() {
		// TODO Auto-generated method stub
		return database.tb_seatreser;
	}
	
	
	

	@Override
	public ArrayList<SeatVo> selectSeat(String[][] seat) {
		// TODO Auto-generated method stub
		return null;
	}

}
