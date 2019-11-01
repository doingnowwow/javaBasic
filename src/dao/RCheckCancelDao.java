package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.ReserveVo;

public interface RCheckCancelDao { //예매확인/취소 관련
	
	ArrayList<ReserveVo> selectReserve(HashMap<String, String> param); //예매내역 출력
		
	void deleteReserve(ReserveVo rv); //예매취소
}
