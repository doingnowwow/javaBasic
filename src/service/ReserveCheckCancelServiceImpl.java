package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import vo.ReserveVo;
import vo.SeatReserVo;
import vo.SeatVo;
import dao.ReservationDao;
import dao.ReservationDaoImpl;

public class ReserveCheckCancelServiceImpl implements ReserveCheckCancelService {

	private static ReserveCheckCancelServiceImpl instance;

	private ReserveCheckCancelServiceImpl() {

	}

	public static ReserveCheckCancelServiceImpl getInstance() {
		if (instance == null) {

			instance = new ReserveCheckCancelServiceImpl();
		}
		return instance;
	}

	ReservationDao reservationDao = ReservationDaoImpl.getInstance();
	
	Seat seatclass = new Seat();

	@Override
	public void reservationList() {
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy년 MM월 dd일 (E) hh:mm", Locale.KOREA);
		Date time = new Date();
		String paytime = formatter1.format(time);

		ArrayList<ReserveVo> reservelist = reservationDao.selectReserveList();
		ArrayList<SeatReserVo> seatreservelist = reservationDao.selectSeatList();

		System.out.println();
		System.out.println("**********************예약확인************************");
		
		
		if(reservelist.size() !=0){
		for (int i = 0; i < reservelist.size(); i++) {
			ReserveVo reseve = reservelist.get(i);
			SeatReserVo seatreservo = seatreservelist.get(i);

			System.out.println("\t\t\t예매 번호\t" + (i + 1) + " / 예약 날짜 : " + reseve.getReDate());
			System.out.println("________________________________________________");
			System.out.println("\t출발\t\t>>>\t\t도착  ");
			System.out.println("________________________________________________");
			System.out.println("\t" + reseve.getSelstartTerminal() + "\t" + reseve.getSelarriveTerminal());
			System.out.println("\t" + reseve.getStartTime() + "\t\t" + reseve.getArriveTime());
			System.out.println();
			System.out.println("등급 : "); // 우등 or일반
			System.out.println("좌석번호 : " + seatreservo.getRow() + seatreservo.getCol1() + "\t|" + seatreservo.getAge()); // A1|성인
			System.out.println("총 결제 금액: " + seatclass.temp2);
			System.out.println("결제 일시: " + paytime);
			
			System.out.println("**************************************************");

		}
		}else{
			System.out.println("예매내역이 존재하지 않습니다.");
		}
	}

	public void arrayseat() {
		ArrayList<SeatVo> arrayseat = reservationDao.selectSeat();
		for (int i = 0; i < arrayseat.size(); i++) {
			SeatVo seat = arrayseat.get(i);
			System.out.println(seat.getSeat()[i]);
		}
	}

	@Override
	public void cancel() {
		ArrayList<ReserveVo> reservelist = reservationDao.selectReserveList();
		ArrayList<SeatReserVo> seatreservelist = reservationDao.selectSeatList();
		
		
		for(int i=0; i<reservelist.size();i++) {
		SeatReserVo seatreservo = seatreservelist.get(i);
		reservelist.remove(i);
		seatreservelist.remove(i);
		
		}		
		
		System.out.println("취소하였습니다.");
		
		reservationList();
	
		
		

	}

}
