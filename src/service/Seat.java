package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.BusVo;
import vo.ReserveVo;
import vo.SeatReserVo;
import vo.SeatVo;
import dao.ReservationDao;
import dao.ReservationDaoImpl;
import data.Database;

public class Seat {

	SeatReserVo seatreserve = new SeatReserVo();
	ReserveVo reseve = new ReserveVo();
	SeatVo seatevo = new SeatVo();
	BusVo bs = new BusVo();
	
	ReservationDao reservationDao = ReservationDaoImpl.getInstance();
	ReservationServiceImpl reservationservice = new ReservationServiceImpl();
	
	int price; //좌석 가격
	int temp2; //좌석 가격합


	// 보여지는 좌석

	ArrayList<String> temp1 = new ArrayList<String>();

	String[][] seat = new String[8][4];

	char rn;
	static int seatrepl;
	int row_int, col, system;  //add: 좌석 개수
	boolean confirm;
	String con_char, name, c_name, row, q, age, col1;
	String pw = "password";
	static int a = 0;
	Scanner s = new Scanner(System.in);

	public void Initialize() {// 초기화
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				seat[i][j] = "____";
			}
		}
	}

	
	public void Reference() {// 조회
		
		System.out.println(" A열  B열  C열  D열");
		for (int i = 0; i < 8; i++) {
			rn = 'A';
			col = 1;
			for (int j = 0; j < 2; j++) {
			
				q = seat[i][j].equals("____") ? " □ " : " ■ ";
				System.out.print((i + 1) + q);
			}
			System.out.print("  ");
			for (int j = 2; j < 4; j++) {
				q = seat[i][j].equals("____") ? " □ " : " ■ ";
				System.out.print((i + 1) + q);
			}
			System.out.println();
		}
		 
	}

	public void Reservation() {
		Reference();
		do {
			confirm = true;
			System.out.println("좌석(열)을 선택해주세요 (A~D) >>");

			try {

				Scanner s = new Scanner(System.in);
				row = s.nextLine();
			} catch (Exception e) {
				System.out.println("A~D만 입력하세요");
			}

			if (row.equals("A") || row.equals("a")) {
				row_int = 0;
				confirm = false;
			} else if (row.equals("B") || row.equals("b")) {
				row_int = 1;
				confirm = false;
			} else if (row.equals("C") || row.equals("c")) {
				row_int = 2;
				confirm = false;
			} else if (row.equals("D") || row.equals("d")) {
				row_int = 3;
				confirm = false;
			} else {
				System.out.println("A~D만 입력하세요");
			}
		} while (confirm);

		do {
			confirm = true;
			try {
				System.out.print("좌석 번호를 선택해주세요. 1~8 : ");
				col = s.nextInt();
				if (col >= 1 && col <= 8) {
					if (seat[col - 1][row_int].equals("____")) {
						seat[col - 1][row_int] = "dd";
						col1 = Integer.toString(col);
						confirm = false;
					} else {
						System.out.println("이미 예약된 자리입니다.");
					}
				} else {
					System.out.println("좌석은 1~8번까지 입니다.");
				}
			} catch (Exception e) {
				System.out.println("좌석은 1~8번까지 입니다.");
			}
		} while (confirm);

		do {
			confirm = true;
			System.out.println("1.일반\t2.어린이(만9세 이하) (1,2)");
			Scanner ss = new Scanner(System.in);
			age = ss.nextLine();

			if (age.equals("1")) {
				age = "일반";
				for(int i=0; i<Database.tb_bus.size(); i++){
					if(Database.tb_bus.get(i).getType().endsWith("일반"))
					price = reservationservice.price;
					System.out.println(price);
				}
				confirm = false;
			} else if (age.equals("2")) {
				age = "어린이(만9세 이하)";
				price = bs.getPrice() / 2;
				confirm = false;
			} else {
				System.out.println("다시 입력하세요");
			}
		} while (confirm);

		Reference();
		System.out.println(age + " 으로 " + row + "열" + col + " 번으로 선택하셨습니다.");
		
		
		do {
			confirm = true;
			System.out.println("1.확인\t2.다시선택하기 (1,2)");

			Scanner ss = new Scanner(System.in);
			seatrepl = Integer.parseInt(ss.nextLine());
			if (seatrepl == 1) {
				temp1.add(age);
				temp1.add(row);
				temp1.add(col1);
				temp2 += price;
				
				System.out.println(temp2);
						
				seatevo.setSeat(seat);
				reservationDao.insertSeat(seatevo);
		
				
				/*// 확인
				for (int i = 0; i < seat.length; i++) {
					for (int j = 0; j < seat[i].length; j++) {
					}
					System.out.println(Arrays.toString(seat[i]));
				}
*/
				confirm = false;
				break;
				
				

			} else if (seatrepl == 2) {
				for (int i = 0; i < 8; i++) {

					for (int j = 0; j < 4; j++) {

						if (seat[i][j].equals("dd")) { // dd를 사용자 이름으로 바꾸기

							seat[i][j] = "____";

							Reservation();
							confirm = false;
						}

					}

				}

			} else {
				System.out.println("다시 입력하세요.");
			}

		} while (confirm);
		
		do {
			confirm =true;
			System.out.println("추가구매 하시겠습니까?");
			System.out.println("1.예 2.아니오");

			Scanner ss = new Scanner(System.in);
			int aaaaaaaaaaaaa = Integer.parseInt(ss.nextLine());

			if(aaaaaaaaaaaaa==1) {
				Reservation();
				  a +=1;
				  confirm =false;
			}else {
				confirm =false;
				break;
		
			}
		}while(confirm);
	
	}
/*
public void reply() {
	 for (int i = 0; i < 8; i++) 
	 { 
		 for (int j = 0; j <seat[i].length; j++) {
			 System.out.println(Arrays.toString(seat[i])); 
		 }
	}
}*/
	// 취소

	public void Cancel() {
		/*
		 * System.out.println("이름을 입력하세요");
		 * 
		 * Scanner s = new Scanner(System.in);
		 * 
		 * c_name = s.nextLine();
		 */

		System.out.println("취소하시겠습니까? (y:1, n:0)");

		String yn = s.nextLine();
		if (yn.equals("y")) {
			System.out.println("Ffffff");
			for (int i = 0; i < 8; i++) {

				for (int j = 0; j < 4; j++) {

					if (seat[i][j].equals("dd")) { // dd를 사용자 이름으로 바꾸기

						seat[i][j] = "____";

						System.out.println("취소가 완료되었습니다.");

						Reference();

					}

				}

			}
		} else if (yn.equals("n")) {
			System.out.println("돌아가기");
		} else {
			System.out.println("y or n");
		}

	}

	public static void main(String[] args) {

	}

}
