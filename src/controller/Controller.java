package controller;

import java.util.Scanner;

import data.Session;
import service.AdminService;
import service.AdminServiceImpl;
import service.BusLineService;
import service.BusLineServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class Controller {
	BusLineService buslinService = BusLineServiceImpl.getInstance();

	public static void main(String args[]){
		new Controller().begin();
	}

	void begin(){
		UserController uc = new UserController();
		AdminController ac = AdminController.getInstance();
		UserService us = UserServiceImpl.getInstance();
		AdminService as = AdminServiceImpl.getInstance();
		
		Scanner s = new Scanner(System.in);
		
		try{
			int menu;
				
			do{
				System.out.println("-----------------메뉴------------------");
				System.out.println("1.로그인");
				System.out.println("2.회원가입");
				System.out.println("3.비밀번호 찾기");
				System.out.println("0.종료");
				System.out.println("--------------------------------------");
				System.out.print("메뉴에 해당하는 번호 입력>");
					
				menu = Integer.parseInt(s.nextLine());
					
				switch(menu){
					case 1: //유저로그인
						us.login();
						if(Session.loginUser != null && Session.loginUser.getGrade() == 0){
							uc.userMenu();
						}else if(Session.loginUser != null && Session.loginUser.getGrade() == 1){
							ac.adminMenu();
						}else{
							break;
							}
					case 2: //회원가입
							us.join();
						break;
					case 3: //비밀번호 찾기
						us.passwordfind();
						break;
					case 0 : //프로그램 종료
						System.out.println("프로그램을 종료합니다.");
	//					System.exit(0); //프로그램 종료 메서드
						break;
				}
				if(menu > 3){
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				}
			}while(menu != 0);
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			begin();
		}
	}

}

