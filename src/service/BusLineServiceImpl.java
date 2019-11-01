package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.TerminalVo;
import vo.TimetableVo;
import dao.BusLineDao;
import dao.BusLineDaoImpl;
import data.Database;

public class BusLineServiceImpl implements BusLineService {
	
	private static BusLineServiceImpl instance;
	
	private BusLineServiceImpl(){}
	
	public static BusLineServiceImpl getInstance(){
		if(instance == null){
			instance = new BusLineServiceImpl();
		}
		return instance;
	}	
	
	BusLineDao busDao = BusLineDaoImpl.getInstance();
	Database database = Database.getInstance();
	
	@Override
	public void timeAdd() { //시간표 추가
		Scanner s = new Scanner(System.in);
		
		try{
			System.out.print("시간표 번호: ");
			String ttNum1 = s.nextLine();
			int ttNum2 = Integer.parseInt(ttNum1);
			System.out.print("출발지: ");
			String startTerminal = s.nextLine();
			System.out.print("도착지: ");
			String arriveTerminal = s.nextLine();
			System.out.print("출발시간: ");
			String startTime = s.nextLine();
			System.out.print("도착시간: ");
			String arriveTime = s.nextLine();
			System.out.print("버스 번호: ");
			String bNum1 = s.nextLine();
			int bNum2 = Integer.parseInt(bNum1);
			System.out.println("버스 등급: ");
			String type = s.nextLine();
			
			TimetableVo ttv = new TimetableVo();
			
			ttv.setTtNum(ttNum2);
			ttv.setStartTerminal(startTerminal);
			ttv.setArriveTerminal(arriveTerminal);
			ttv.setStartTime(startTime);
			ttv.setArriveTime(arriveTime);
			ttv.setbNum(bNum2);
			ttv.setType(type);
			
			busDao.insertTime(ttv);
			
			System.out.println("----------------추가된 시간표-------------------");
			timeList();
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			timeAdd();
		}
	}

	@Override
	public void timeDelete() { //시간표 삭제
		Scanner s = new Scanner(System.in);
	
		timeList();
		
		System.out.print("삭제할 번호를 입력해주세요>");
		String ttNum = s.nextLine();
		int ttNum2 = Integer.parseInt(ttNum);
		
		
		busDao.deleteTime(ttNum2);
		
		System.out.println("              삭제후 시간표                ");
		timeList();
	}

	@Override
	public void timeModify() { //시간표 수정
		Scanner s = new Scanner(System.in);
		TimetableVo ttv = new TimetableVo();
		
		timeList();
		
		try{
			System.out.println("변경하고 싶은 번호를 입력해주세요>");
			int ttNum = Integer.parseInt(s.nextLine());
					
			System.out.print("수정할 출발지를 입력하세요> ");
			String startTerminal = s.nextLine();
			System.out.print("수정할 도착지를 입력하세요> ");
			String arriveTerminal = s.nextLine();
			System.out.print("수정할 출발시간을 입력하세요> ");
			String startTime = s.nextLine();
			System.out.print("수정할 도착시간을 입력하세요> ");
			String arriveTime = s.nextLine();
			System.out.print("수정할 버스번호를 입력하세요> ");
			int bNum = Integer.parseInt(s.nextLine());
			System.out.print("수정할 버스등급을 입력하세요> ");
			String type = s.nextLine();
			
			ttv.setTtNum(ttNum);
			ttv.setStartTerminal(startTerminal);
			ttv.setArriveTerminal(arriveTerminal);
			ttv.setStartTime(startTime);
			ttv.setArriveTime(arriveTime);
			ttv.setbNum(bNum);
			ttv.setType(type);
			
			busDao.modifyTime(ttv);
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			timeModify();
		}
	}

	@Override
	public void timeList() { //시간표 목록 출력
		ArrayList<TimetableVo> ttList  = busDao.selectTimetableList();
		
		System.out.println("------------------------------------------");
		System.out.println("번호\t출발지\t도착지\t출발시간\t도착시간\t버스등급");
		System.out.println("------------------------------------------");
		for(int i=0; i<ttList.size(); i++){
			TimetableVo ttv = ttList.get(i);
			System.out.println(i+1 + "\t" + ttv.getStartTerminal() + "\t" + ttv.getArriveTerminal() + "\t" + ttv.getStartTime() + "\t" + ttv.getArriveTime() + "\t" + ttv.getType());
		}
		System.out.println("------------------------------------------");
	}

	@Override
	public void terminalAdd() { //터미널 추가
		Scanner s = new Scanner(System.in);
		
		try{
			System.out.print("번호: ");
			String tnum = s.nextLine();
			int a = Integer.parseInt(tnum);
			System.out.print("터미널 이름: ");
			String tname = s.nextLine();
			
			TerminalVo tv = new TerminalVo();
			
			tv.setTnum(a);
			tv.setTname(tname);
			
			busDao.insertTerminal(tv);
			
			System.out.println();
			System.out.println("        추가된 터미널 목록            ");
			terminalList();
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			terminalAdd();
		}
	}

	@Override
	public void terminalDelete() { //터미널 삭제
		Scanner s = new Scanner(System.in);
		
		terminalList();
		
		System.out.print("삭제할 인덱스번호를 입력하세요>");
		int tnum = Integer.parseInt(s.nextLine());
		
		busDao.deleteTerminal(tnum - 1);
		
		
		System.out.println();
		System.out.println("        삭제후 터미널 목록            ");
		terminalList();
	}

	@Override
	public void terminalModify() { //터미널 수정
		Scanner s = new Scanner(System.in);
		TerminalVo tv = new TerminalVo();
		
		terminalList();
		
		try{
			System.out.print("수정할 터미널 번호를 입력하세요>");
			int a = Integer.parseInt(s.nextLine());
			
			System.out.println("수정할 이름을 입력하세요.");
			String rtName = s.nextLine();
			
			tv.setTnum(a);
			tv.setTname(rtName);
			
			busDao.modifyTerminal(tv);
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			terminalModify();
		}
	}

	@Override
	public void terminalList() { //터미널 목록 출력
		ArrayList<TerminalVo> tmList  = busDao.selectTerminalList();
		
		System.out.println("---------------------------");
		System.out.println("번호\t터미널 목록");
		System.out.println("---------------------------");
		for(int i=0; i<tmList.size(); i++){
			TerminalVo tv = tmList.get(i);
			System.out.println(i+1 + "\t" + tv.getTname());
		}
		System.out.println("---------------------------");
	}
	

}
