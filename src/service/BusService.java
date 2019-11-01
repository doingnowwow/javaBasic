package service;

public interface BusService {
	
	
	void busList(); //전체버스 목록 출력	
	
	void busLicense(); //버스 선택 후 라이센스 확인
		
	void busAdd(); //버스 추가(관리자만)
	
	void busDelete(); //버스 삭제(관리자만)
	
	void busModify(); //버스수정(관리자만)

}
