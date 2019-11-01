package dao;

import java.util.ArrayList;

import service.BusLineService;
import service.BusLineServiceImpl;
import vo.TerminalVo;
import vo.TimetableVo;
import data.Database;

public class BusLineDaoImpl implements BusLineDao {
	
	private static BusLineDaoImpl instance;
	
	private BusLineDaoImpl(){}
	
	public static BusLineDaoImpl getInstance(){
		if(instance == null){
			instance = new BusLineDaoImpl();
		}
		return instance;
	}	
	
	Database database = Database.getInstance();

	@Override
	public void insertTime(TimetableVo ttv) { //시간표 삽입
		database.tb_timetable.add(ttv);
	}

	@Override
	public void deleteTime(int ttnum) { //시간표 삭제
		if(ttnum < 0){
			System.out.println("존재하지 않는 번호입니다.");
		}else{
			database.tb_timetable.remove(ttnum);
		}
	}

	@Override
	public void modifyTime(TimetableVo ttv) { //시간표 수정
		for(int i=0; i<database.tb_timetable.size(); i++){
			if(database.tb_timetable.get(i).getTtNum() == ttv.getTtNum()){
				database.tb_timetable.remove(i);
			}
		}
		database.tb_timetable.add(ttv);
	}

	@Override
	public ArrayList<TimetableVo> selectTimetableList() { //시간표 목록 출력
		return database.tb_timetable;
	}

	@Override
	public void insertTerminal(TerminalVo tv) { //터미널 추가
		database.tb_terminal.add(tv);
	}

	@Override
	public void deleteTerminal(int tnum) { //터미널 삭제	
		database.tb_terminal.remove(tnum);
//		database.tb_terminal.remove(tv);
	}

	@Override
	public void modifyTerminal(TerminalVo tv) { //터미널 수정
		for(int i=0; i<database.tb_terminal.size(); i++){
			if(database.tb_terminal.get(i).getTnum() == tv.getTnum()){
				database.tb_terminal.remove(i);
			}
		}
		database.tb_terminal.add(tv);
	}

	@Override
	public ArrayList<TerminalVo> selectTerminalList() { //터미널 목록 출력
		return database.tb_terminal;
	}

}
