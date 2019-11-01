package service;

public interface ReservationService { //예매하기
	

	void selectTerminal(); //터미널 선택(출발, 도착 터미널 목록 출력되고 선택)
	
	void selectDate(); //날짜 선택
	
	void selectLine(); //노선선택(시간표가 출력되고 선택하도록)
	
	void selectSeat(); //좌석, 인원수 선택(연령대 선택하고 좌석목록 나오고 선택)
	
	void pay(); //결제(선택한 연령, 인원수 만큼 결제 가능하도록)

	void tempDelete();

	void reservelist();
	
}
