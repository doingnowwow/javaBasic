package dao;

import java.util.ArrayList;

import vo.BusVo;
import vo.NoticeVo;

public interface BusDao {
	
	
  BusVo selectBus(String key, int value) ; // 버스라이센스확인
	
	ArrayList<BusVo> selectBusList(); //전체버스리스트 출력
	
	void insertBus(BusVo bv); //버스 추가
	
	void deleteBus(int bv); //버스 삭제
	
	void modifyBus(BusVo bv); //버스 수정

	

	
	

}
