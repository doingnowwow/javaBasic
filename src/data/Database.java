package data;

import java.util.ArrayList;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.*;

public class Database {

	private static Database instance;

	private Database() {
	}

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	public ArrayList<UserVo> tb_user = new ArrayList<UserVo>(); // 회원
	{	
		UserVo user = new UserVo();
		user.setId("admin");
		user.setPassword("admin123");
		user.setName("관리자");
		user.setGrade(1);
		tb_user.add(user);
		
		UserVo user2 = new UserVo();
		user2.setId("user");
		user2.setPassword("user123");
		user2.setName("홍길동");
		user2.setGrade(0);
		tb_user.add(user2);
	}

	public static ArrayList<BusVo> tb_bus = new ArrayList<BusVo>(); // 버스
	{
		BusVo bus = new BusVo();
		
		bus.setBusNum(1);
		bus.setType("우등");
		bus.setPrice(35000);
		bus.setLicense("12육4567");
		tb_bus.add(bus);
		
		bus = new BusVo();
		bus.setBusNum(2);
		bus.setType("일반");
		bus.setPrice(20000);
		bus.setLicense("12해4567");
		tb_bus.add(bus);
		
		bus = new BusVo();
		bus.setBusNum(3);
		bus.setType("일반");
		bus.setPrice(20000);
		bus.setLicense("23공1245");
		tb_bus.add(bus);
		
		bus = new BusVo();
		bus.setBusNum(4);
		bus.setType("우등");
		bus.setPrice(35000);
		bus.setLicense("14육3214");
		tb_bus.add(bus);
		
		bus = new BusVo();
		bus.setBusNum(5);
		bus.setType("일반");
		bus.setPrice(20000);
		bus.setLicense("12육2134");
		tb_bus.add(bus);
		
	}
	public static  ArrayList<NoticeVo> tb_notice = new ArrayList<NoticeVo>(); // 공지사항
	{
		NoticeVo nv = new NoticeVo();
		
		nv.setNoticeNum(1);
		nv.setTitle("필독 공지사항");
		nv.setContent("★우리 고속터미널예매 서비스를 이용해주셔서 감사합니다\r★본 예매 서비스 사이트는 1개월간 로그인하지 않으면 자동탈퇴됩니다. \r★★★저희 서비스는 환불 불가능 합니다★★★★\r\r 예매시 해당 터미널과 예매 날짜 등 확인 잘 부탁드립니다.\r감사합니다. 좋은 하루 되십시오 ^^♥.");
		nv.setId("admin");
		nv.setsDate("2019-08-06");
		
		tb_notice.add(nv);
	}

	public ArrayList<ReserveVo> tb_reserve = new ArrayList<ReserveVo>(); // 예매

	public ArrayList<SeatReserVo> tb_seatreser = new ArrayList<SeatReserVo>(); // 예매좌석

	public ArrayList<SeatVo> tb_seat = new ArrayList<SeatVo>(); // 좌석

	public ArrayList<TerminalVo> tb_terminal = new ArrayList<TerminalVo>(); // 터미널
	{
		TerminalVo tv1 = new TerminalVo();
		tv1.setTnum(1);
		tv1.setTname("서울고속버스터미널");
		tb_terminal.add(tv1);
		
		TerminalVo tv2 = new TerminalVo();
		tv2.setTnum(2);
		tv2.setTname("대전복합터미널");
		tb_terminal.add(tv2);
		
		TerminalVo tv3 = new TerminalVo();
		tv3.setTnum(3);
		tv3.setTname("부산종합버스터미널");
		tb_terminal.add(tv3);
		
		TerminalVo tv4 = new TerminalVo();
		tv4.setTnum(4);
		tv4.setTname("인천종합버스터미널");
		tb_terminal.add(tv4);
	}
	public ArrayList<TimetableVo> tb_timetable = new ArrayList<TimetableVo>(); // 시간표
	{
		TimetableVo ttv1 = new TimetableVo();
		ttv1.setTtNum(1);
		ttv1.setStartTerminal("대전복합터미널");
		ttv1.setArriveTerminal("서울고속버스터미널");
		ttv1.setStartTime("07:00");
		ttv1.setArriveTime("09:00");
		ttv1.setbNum(1);
		ttv1.setType("우등");
		
		TimetableVo ttv4 = new TimetableVo();
		ttv4.setTtNum(2);
		ttv4.setStartTerminal("대전복합터미널");
		ttv4.setArriveTerminal("서울고속버스터미널");
		ttv4.setStartTime("08:30");
		ttv4.setArriveTime("10:30");
		ttv4.setbNum(1);
		ttv4.setType("일반");
		
		tb_timetable.add(ttv4);
		
		TimetableVo ttv5 = new TimetableVo();
		ttv5.setTtNum(3);
		ttv5.setStartTerminal("대전복합터미널");
		ttv5.setArriveTerminal("서울고속버스터미널");
		ttv5.setStartTime("13:10");
		ttv5.setArriveTime("15:10");
		ttv5.setbNum(1);
		ttv5.setType("일반");
		
		tb_timetable.add(ttv5);
		
		TimetableVo ttv6 = new TimetableVo();
		ttv6.setTtNum(4);
		ttv6.setStartTerminal("대전복합터미널");
		ttv6.setArriveTerminal("서울고속버스터미널");
		ttv6.setStartTime("15:40");
		ttv6.setArriveTime("17:40");
		ttv6.setbNum(1);
		ttv6.setType("우등");
		
		tb_timetable.add(ttv4);
		
		tb_timetable.add(ttv1);
		
		TimetableVo ttv2 = new TimetableVo();
		ttv2.setTtNum(5);
		ttv2.setStartTerminal("대전복합터미널");
		ttv2.setArriveTerminal("부산종합버스터미널");
		ttv2.setStartTime("13:10");
		ttv2.setArriveTime("16:10");
		ttv2.setbNum(1);
		ttv2.setType("일반");
		
		tb_timetable.add(ttv2);
		
		TimetableVo ttv3 = new TimetableVo();
		ttv3.setTtNum(6);
		ttv3.setStartTerminal("대전복합터미널");
		ttv3.setArriveTerminal("인천종합버스터미널");
		ttv3.setStartTime("13:10");
		ttv3.setArriveTime("16:10");
		ttv3.setbNum(1);
		ttv3.setType("우등");
		
		tb_timetable.add(ttv3);
		
		
	}

}
