package controller;

import java.util.Scanner;

import service.AdminService;
import service.AdminServiceImpl;
import service.BusLineService;
import service.BusLineServiceImpl;
import service.BusService;
import service.BusServiceImpl;
import service.NoticeService;
import service.NoticeServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class AdminController {
	private static AdminController instance;
	
	private AdminController(){}
	
	public static AdminController getInstance(){
		if(instance == null){
			instance = new AdminController();
		}
		return instance;
	}	
	
	BusService bs = BusServiceImpl.getInstance();
	BusLineService busService = BusLineServiceImpl.getInstance();
	NoticeService ns = NoticeServiceImpl.getInstance();
	AdminService a = AdminServiceImpl.getInstance();
	UserService us = UserServiceImpl.getInstance();
	
	void adminMenu(){
		Scanner s = new Scanner(System.in);
		
		try{
			int adminMenu;
			
			while(true){
				System.out.println("---------------관리자 메뉴----------------");
				System.out.println("1.공지사항 관리");
				System.out.println("2.터미널 관리");
				System.out.println("3.시간표 관리");
				System.out.println("4.회원 관리");
				System.out.println("5.버스 관리");
				System.out.println("0.종료");
				System.out.println("--------------------------------------");
				System.out.print("메뉴에 해당하는 번호 입력>");
				
				adminMenu = Integer.parseInt(s.nextLine());
				
				switch(adminMenu){
					case 1: //공지사항 관리
						noticeManagement();
						break;
					case 2: //터미널관리
						terminalManagement();
						break;
					case 3: //시간표 관리
						timetableManegement();
						break;
					case 4: //회원관리
						userManegement();
						break;
					case 5: //버스관리
						busManegement();
						break;
					case 0: 
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
				}
				if(adminMenu > 5){
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			adminMenu();
		}
	}
	
	void noticeManagement(){ //공지사항 관련 메뉴
		Scanner s = new Scanner(System.in);
		
		try{
			int noticeMenu;
			
			while(true){
				System.out.println("--------------공지사항 메뉴---------------");
				System.out.println("1.공지사항 목록");
				System.out.println("2.공지사항 추가");
				System.out.println("3.공지사항 수정");
				System.out.println("4.공지사항 삭제");
				System.out.println("5.돌아가기");
				System.out.println("0.종료");
				System.out.println("--------------------------------------");
				System.out.print("메뉴에 해당하는 번호 입력>");
			
				noticeMenu = Integer.parseInt(s.nextLine());
				
				switch(noticeMenu){
				case 1: //공지사항 목록
					ns.noticeList();
					break;
				case 2: //공지사항 추가
					ns.noticeAdd();
					break;
				case 3: //공지사항 수정
					ns.noticeModify();
					break;
				case 4: //공지사항 삭제
					ns.noticeDelete();
					break;
				case 5: //이전 메뉴로 돌아가기
					adminMenu();
					break;
				case 0: 
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
				
				if(noticeMenu > 5){
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			noticeManagement();
		}
	}

	void terminalManagement(){ //터미널 관련 메뉴
		Scanner s = new Scanner(System.in);
		
		try{
			int terminalMenu;
			
			while(true){
				System.out.println("---------------터미널 메뉴----------------");
				System.out.println("1.터미널 목록");
				System.out.println("2.터미널 추가");
				System.out.println("3.터미널 수정");
				System.out.println("4.터미널 삭제");
				System.out.println("5.돌아가기");
				System.out.println("0.종료");
				System.out.println("--------------------------------------");
				System.out.print("메뉴에 해당하는 번호 입력>");
			
				terminalMenu = Integer.parseInt(s.nextLine());
				
				switch(terminalMenu){
				case 1: //터미널 목록
					busService.terminalList();
					break;
				case 2: //터미널 추가
					busService.terminalAdd();
					break;
				case 3: //터미널 수정
					busService.terminalModify();
					break;
				case 4: //터미널 삭제
					busService.terminalDelete();
					break;
				case 5: //이전 메뉴로 돌아가기
					adminMenu();
					break;
				case 0: 
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
				
				if(terminalMenu > 5){
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			terminalManagement();
		}
	}
	
	void timetableManegement(){ //시간표 관련 메뉴
		Scanner s = new Scanner(System.in);
		
		try{
			int timtableMenu;
			
			while(true){
				System.out.println("---------------시간표 메뉴----------------");
				System.out.println("1.시간표 목록");
				System.out.println("2.시간표 추가");
				System.out.println("3.시간표 수정");
				System.out.println("4.시간표 삭제");
				System.out.println("5.돌아가기");
				System.out.println("0.종료");
				System.out.println("--------------------------------------");
				System.out.print("메뉴에 해당하는 번호 입력>");
			
				timtableMenu = Integer.parseInt(s.nextLine());
				
				switch(timtableMenu){
				case 1: //시간표 목록
					busService.timeList();
					break;
				case 2: //시간표 추가
					busService.timeAdd();
					break;
				case 3: //시간표 수정
					busService.timeModify();
					break;
				case 4: //시간표 삭제
					busService.timeDelete();
					break;
				case 5: //이전 메뉴로 돌아가기
					adminMenu();
					break;
				case 0: 
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
				
				if(timtableMenu > 5){
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			timetableManegement();
		}
	}
	
	void userManegement(){ //회원 관련 메뉴
		Scanner s = new Scanner(System.in);
		
		try{
			int userMenu;
			
			while(true){
				System.out.println("---------------회원  메뉴----------------");
				System.out.println("1.회원 목록");
				System.out.println("5.돌아가기");
				System.out.println("0.종료");
				System.out.println("--------------------------------------");
				System.out.print("메뉴에 해당하는 번호 입력>");
			
				userMenu = Integer.parseInt(s.nextLine());
				
				switch(userMenu){
				case 1: //회원 목록
					a.userList();
					break;
				case 5: //이전 메뉴로 돌아가기
					adminMenu();
					break;
				case 0: 
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
				
				if(userMenu > 5){
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}
		catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			userManegement();
		}
	}
	
	void busManegement(){ //버스 관련 메뉴
		Scanner s = new Scanner(System.in);
		
		try{
			int busMenu;
			
			while(true){
				System.out.println("---------------버스  메뉴----------------");
				System.out.println("1.버스 목록");
				System.out.println("2.버스 추가");
				System.out.println("3.버스 수정");
				System.out.println("4.버스 삭제");
				System.out.println("5.돌아가기");
				System.out.println("0.종료");
				System.out.println("--------------------------------------");
				System.out.print("메뉴에 해당하는 번호 입력>");
			
				busMenu = Integer.parseInt(s.nextLine());
				
				switch(busMenu){
				case 1: //버스 목록
					bs.busList();
					break;
				case 2: //버스 추가
					bs.busAdd();
					break;
				case 3: //버스 수정
					bs.busModify();
					break;
				case 4: //버스 삭제
					bs.busDelete();
					break;
				case 5: //이전 메뉴로 돌아가기
					adminMenu();
					break;
				case 0: 
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
				
				if(busMenu > 5){
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			busManegement();
		}
	}
}
