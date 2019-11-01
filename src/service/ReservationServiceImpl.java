package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import vo.BusVo;
import vo.ReserveVo;
import vo.SeatReserVo;
import vo.TerminalVo;
import vo.TimetableVo;
import dao.BusLineDao;
import dao.BusLineDaoImpl;
import dao.ReservationDao;
import dao.ReservationDaoImpl;
import data.Database;

public class ReservationServiceImpl implements ReservationService {

	private static ReservationServiceImpl instance;

	public ReservationServiceImpl() {

	}

	public static ReservationServiceImpl getInstance() {
		if (instance == null) {

			instance = new ReservationServiceImpl();
		}
		return instance;
	}

	Database database = Database.getInstance();
	BusLineDao buslineDao = BusLineDaoImpl.getInstance();
	ReservationDao reservationDao = ReservationDaoImpl.getInstance();
	BusLineService busService = BusLineServiceImpl.getInstance();
	
	int ticketsu;
	int  price;
	Scanner s = new Scanner(System.in);

	ArrayList<TimetableVo> timetable = database.tb_timetable;
	ArrayList<TerminalVo> terminal = database.tb_terminal;
	ArrayList<BusVo> bustable = database.tb_bus;
	ArrayList<ReserveVo> reservelist = reservationDao.selectReserveList();

	// 사용자가 예매과정에서 선택하는 옵션들을 임시 저장하는 리스트
	ArrayList<String> temp = new ArrayList<String>();
	ArrayList<String> selectTimetable = new ArrayList<String>();

	ReserveVo reseve = new ReserveVo();
	SeatReserVo seatreserve = new SeatReserVo();
	BusVo bs = new BusVo(); 

	ArrayList<BusVo> tb_bus = new ArrayList<BusVo>();
	
	Seat seatclass = new Seat();
	
	int money = 50000;
	
	public int changeMoney = money - seatclass.temp2;
	

	// 현재 날짜 불러오기
	Date time = new Date();
	String timenow = "";
	String date = "";

	// 터미널 선택(출발, 도착 터미널 목록 출력되고 선택)
	@Override
	public void selectTerminal() {

		int a;
		int startT = 0;
		int arriveT = 0;
		boolean confirm;

		while (true) {

			do {
				confirm = true;

				// 전체 터미널 목록 출력
				busService.terminalList();

				// 출발지 선택 후 임시저장

				try {
					System.out.println("****출발지를 선택해주세요>>");
					startT = Integer.parseInt(s.nextLine().trim());

					// temp에 starT에 선택한 값 담기
					switch (startT) {
					case 1:
						temp.add(terminal.get(0).getTname());
						confirm = false;
						break;
					case 2:
						temp.add(terminal.get(1).getTname());
						confirm = false;
						break;
					case 3:
						temp.add(terminal.get(2).getTname());
						confirm = false;
						break;
					case 4:
						temp.add(terminal.get(3).getTname());
						confirm = false;
						break;
					default:
						System.out.println("없는 번호 입니다.");
						confirm = true;
						break;

					}
				} catch (Exception e) {
					System.out.println("번호로 입력해주세요.");
					confirm = true;

				}
			} while (confirm);

			do {

				// 전체 터미널 목록 출력
				busService.terminalList();

				try {

					// 도착지 선택후 임시저장
					System.out.println("****도착지를 선택해주세요>>");
					arriveT = Integer.parseInt(s.nextLine());

					// temp에 starT에 선택한 값 담기
					switch (arriveT) {
					case 1:
						temp.add(terminal.get(0).getTname());
						System.out.println(temp);
						confirm = true;
						break;
					case 2:
						temp.add(terminal.get(1).getTname());
						confirm = true;
						break;
					case 3:
						temp.add(terminal.get(2).getTname());
						confirm = true;
						break;
					case 4:
						temp.add(terminal.get(3).getTname());
						confirm = true;
						break;
					default:
						System.out.println("없는 번호 입니다.");
						confirm = false;
						break;
					}

				} catch (Exception e) {
					System.out.println("번호로 입력해 주세요.");
					confirm = true;
				}
				
			

				if ((startT == arriveT) && (startT <= 4) && (arriveT <= 4)) {
					System.out.println("****선택한 출발지 입니다. 도착지를 다시 선택해 주세요");
					temp.remove(1);   //temp에 저장된 도착지 지우기

				} else if (temp.size() == 2 || temp.size() == 7) {

					System.out.println("___________________________________________________________________");
					System.out.println(
							" 출발지 : "+temp.get(0).toString()+"\t>>\t도착지 : " + temp.get(1).toString() + "로 선택하셨습니다. ");
					System.out.println("___________________________________________________________________");

					System.out.println("변경하시겠습니까? (yes:1 / no:0)");
					a = Integer.parseInt(s.nextLine());

					if (a == 1) {
						System.out.println("다시 선택해주세요.");
						temp.clear();
						break;
					} else {
						return;
					}
				}

			} while (true);

		}

	}

	// 날짜 선택하기
	@Override
	public void selectDate() {
		// 날짜 형식
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);

		// 현재 날짜 불러오기
		timenow = formatter.format(time);
		date = "";

		while (true) {
			// 날짜 입력
			System.out.println("예매하실 날짜(오늘 날짜: " + timenow + ") 를 입력하세요>>");
			date = s.nextLine();

			// 날짜 유효성 체크
			date = date.replaceAll("-", "");
			formatter.setLenient(false);

			try {
				Date formatDate = formatter.parse(date);
				Date formatDate1 = formatter.parse(timenow);

				// 지난 날짜인경우 다시입력
				int compare = formatDate.compareTo(formatDate1);
				if (compare == 1 || compare == 0) { // date >= timenow

					// 저장하는부분
					/*
					 * reseve.setReDate(date); reservationDao.insertReserve(reseve);
					 */

					temp.add(date);
					System.out.println();

					break;
				} else {
					System.out.println("지난 날짜 입니다. ");
				}

			} catch (java.text.ParseException e) {
				System.out.println("날짜를 다시 입력하세요 ");
			}

		}

	}

	// 노선선택(시간표가 출력되고 선택하도록)
	@Override
	public void selectLine() {

		System.out.println("______________________________________________________");
		System.out.println("번호\t출발지\t\t도착지\t\t출발시간\t도착시간\t");
		System.out.println("______________________________________________________");

		// 선택한 노선의 시간표만 출력
		for (int i = 0; i < database.tb_timetable.size(); i++) {
			if (temp.get(0).equals(timetable.get(i).getStartTerminal())
					&& temp.get(1).equals(timetable.get(i).getArriveTerminal())) {
				selectTimetable.add(timetable.get(i).getStartTime());
				selectTimetable.add(timetable.get(i).getArriveTime());

				System.out.println(
						i+1 + "\t" + timetable.get(i).getStartTerminal() + "\t" + timetable.get(i).getArriveTerminal() + "\t"
								+ timetable.get(i).getStartTime() + "\t" + timetable.get(i).getArriveTime());
			}
		}

		
		if (selectTimetable.size() != 0) {
			System.out.println("______________________________________________________");
			System.out.println();
			System.out.println("예매하실 시간에 맞는 번호를 선택해 주세요 >>");
			String selecttime = s.nextLine();

			switch (selecttime) {
			case "1":
				temp.add(selectTimetable.get(0));
				temp.add(selectTimetable.get(1));

				break;
			case "2":
				temp.add(selectTimetable.get(2));
				temp.add(selectTimetable.get(3));
				break;
			case "3":
				temp.add(selectTimetable.get(4));
				temp.add(selectTimetable.get(5));
				break;
			case "4":
				temp.add(selectTimetable.get(6));
				temp.add(selectTimetable.get(7));
				break;
			}
			
			System.out.println("1.우등\t2.일반");
			int grade = Integer.parseInt(s.nextLine()); 
			switch(grade){
			case 1: //우등선택
				price = Database.tb_bus.get(0).getPrice();
				System.out.println(price);
				break;
			case 2: //일반선택
				price = Database.tb_bus.get(1).getPrice();
				System.out.println(price);
				break;
			}
			
			

		} else {
			System.out.println("해당 시간표가 없습니다.");
		}
	}

	@Override
	public void selectSeat() { // 좌석, 인원수 선택(연령대 선택하고 좌석목록 나오고 선택)
		
		seatclass.Initialize();
		seatclass.Reservation();
	}

	@Override
	public void pay() { // 결제(선택한 연령, 인원수 만큼 결제 가능하도록)
	
		
		System.out.println("*******************예매 내역 확인*******************");
		System.out.println();
		System.out.println("\t\t출발지 : "+temp.get(0));     
		System.out.println("\t\t도착지 : "+temp.get(1));
		System.out.println("\t\t날짜 : "+temp.get(2));
		System.out.println("\t\t출발 시간 : "+temp.get(3));
		System.out.println("\t\t도착 시간  : "+temp.get(4));
		
		if(seatclass.a ==0) {
		
			System.out.println("\t\t좌석 번호:"+seatclass.temp1.get(1) + seatclass.temp1.get(2)+ "\t|" + seatclass.temp1.get(0));
		}else if(seatclass.a ==1) {
		
			System.out.println("\t\t좌석 번호 : "+seatclass.temp1.get(1) + seatclass.temp1.get(2)+ "\t|" + seatclass.temp1.get(0));
			System.out.println("\t\t\t : "+seatclass.temp1.get(4) + seatclass.temp1.get(5)+ "\t|" + seatclass.temp1.get(3));
		}
		System.out.println("\t\t총 결제 금액: " + seatclass.temp2);
		System.out.println();
		System.out.println("************************************************");


		
		
		System.out.println("결제하시겠습니까?");
		System.out.println("1.예 \t2. 돌아가기");
		String pay = s.next();
		
//		int money = 50000;
//		changeMoney = money - seatclass.temp2;
		
		
		if(changeMoney >= 0){
			switch (pay) {
			case "1":
				seatclass.a = 0;
				System.out.println();
				System.out.println("!!!!결제 완료!!!");
				System.out.println();
				// 선택한 정보 저장
				
				reseve.setSelstartTerminal(temp.get(0)); // 출발지
				reseve.setSelarriveTerminal(temp.get(1)); // 도착지
				reseve.setReDate(temp.get(2)); // 날짜
				reseve.setStartTime(temp.get(3)); // 출발시간
				reseve.setArriveTime(temp.get(4)); // 도착시간
				
			
				seatreserve.setAge(seatclass.temp1.get(0)); // 성인 or 초등생2
				seatreserve.setRow(seatclass.temp1.get(1)); // 열
				seatreserve.setCol1(seatclass.temp1.get(2)); // 행
				
	
				reservationDao.insertReserve(reseve);
				reservationDao.insertSeat(seatreserve);
				tempDelete();
	
			
				break;
				
			case "2":
				selectTerminal();
				break;
			}
		}else{
			System.out.println("금액이 부족합니다.");
		}
		

	}

	// 선택한 정보 저장
	public void reservelist() {

	}

	//임시저장공간에 저장된값 모두 지우기
	public void tempDelete() {
		temp.clear();
		selectTimetable.clear();
		seatclass.temp1.clear();

	}

}
