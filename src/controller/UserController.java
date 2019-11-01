package controller;

import java.util.Scanner;

import service.NoticeService;
import service.NoticeServiceImpl;
import service.ReservationService;
import service.ReservationServiceImpl;
import service.ReserveCheckCancelService;
import service.ReserveCheckCancelServiceImpl;
import service.Seat;
import service.UserService;
import service.UserServiceImpl;

public class UserController {
	void userMenu(){
		Scanner s = new Scanner(System.in);
		NoticeService ns = NoticeServiceImpl.getInstance();
		UserService us = UserServiceImpl.getInstance();
		ReservationService rs = ReservationServiceImpl.getInstance();
		ReserveCheckCancelService rscc = ReserveCheckCancelServiceImpl.getInstance();
		Seat seatcalss = new Seat();
		ReservationServiceImpl reserve = new ReservationServiceImpl();
		
		
		try{
			int userMenu;
			
			while(true){
				System.out.println("----------------유저 메뉴-----------------");
				System.out.println("---------------------현재가진 금액: " + reserve.changeMoney + "--");
				System.out.println("1.예매하기");
				System.out.println("2.예매내역 확인");
				System.out.println("3.예매취소");
				System.out.println("4.공지사항 확인");
				System.out.println("0.종료");
				System.out.println("--------------------------------------");
				System.out.print("메뉴에 해당하는 번호 입력>");
				
				userMenu = Integer.parseInt(s.nextLine());
				
				switch(userMenu){
					case 1: //예매하기
						rs.selectTerminal();
						rs.selectDate();
						rs.selectLine();
						rs.selectSeat();
						rs.pay();
						rs.tempDelete();
						break;
					case 2: //예매내역 확인
						rscc.reservationList();
						break;
					case 3: //예매취소
						rscc.cancel();
						break;
					case 4: //공지사항 확인
						ns.noticeList();
						ns.noticeContent();
						break;
					case 0: 
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
				}
				if(userMenu > 3){
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				}
				
			}
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			userMenu();
		}
	}
}
