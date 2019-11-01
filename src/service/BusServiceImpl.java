package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.BusDao;
import dao.BusDaoImpl;
import data.Database;
import data.Session;
import vo.BusVo;




public class BusServiceImpl implements BusService {

	private static BusServiceImpl instance;

	private BusServiceImpl() {

	}

	public static BusServiceImpl getInstance() {
		if (instance == null) {
			instance = new BusServiceImpl();
		}
		return instance;
	}
	BusDao busDao = BusDaoImpl.getInstance();
	
	@Override
	public void busList() { //전체 버스리스트 출력

		ArrayList<BusVo> busList = busDao.selectBusList();

		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("번호\t버스종류\t버스가격\t번호판정보");
		System.out.println("만9세 이하는 요금이 50% 할인");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		
		for (int i = 0; i < busList.size(); i++) {
			BusVo bo = busList.get(i);
			System.out.println(i+1+"\t"+bo.getType()+"\t"+bo.getPrice()+"원"+"\t"+bo.getLicense());
		}
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

	}

	@Override
	public void busLicense() { //버스 선택  라이센스 확인
		// TODO Auto-generated method stub

	}

	@Override
	public void busAdd() { //버스추가
		
		BusVo bv = new BusVo();
		Scanner s = new Scanner(System.in);
		
		try{
			System.out.println("＊＊＊＊＊＊＊버스추가＊＊＊＊＊＊＊");
			System.out.println();
			System.out.println("────────버스넘버 입력────────");
			System.out.println("숫자로만가능>>>");
			
			int busNum =  Integer.parseInt(s.nextLine());
			System.out.println();
			
			System.out.println();
			System.out.println("────────버스종류입력────────");
			System.out.println(">>>");
			String type = s.nextLine();
			System.out.println();
			System.out.println("────────버스가격입력────────");
			System.out.println(">>>");
			int price = Integer.parseInt(s.nextLine());
			
			System.out.println("────────버스번호판정보────────");
			System.out.println(">>>");
			String license = s.nextLine();
	
			ArrayList<BusVo> tb_bus = new ArrayList<BusVo>();
	
			if (Database.tb_bus.size() == 0) {
				bv.setBusNum(busNum);
				bv.setType(type);
				bv.setPrice(price);
				bv.setLicense(license);
				
				busDao.insertBus(bv);
	
				System.out.println("＊＊＊＊＊＊＊입력완료＊＊＊＊＊＊＊");
				System.out.println();
	
			} else {
				int size = Database.tb_bus.size() - 1;
				int num = Database.tb_bus.get(size).getBusNum();
				
				bv.setBusNum(busNum);
				bv.setType(type);
				bv.setPrice(price);
				bv.setLicense(license);
				
				busDao.insertBus(bv);
	
				
				System.out.println("＊＊＊＊＊＊＊작성완료＊＊＊＊＊＊＊");
				System.out.println();
	
			}
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			busAdd();
		}

	}

	@Override
	public void busDelete() {
		System.out.println("＊＊＊＊＊＊버스삭제하기＊＊＊＊＊＊＊");
		busList();
		System.out.println();
		Scanner s = new Scanner(System.in);
		System.out.println("삭제할 버스 번호를 입력>>>>>>>");
		System.out.println();
		int bv = Integer.parseInt(s.nextLine());

		busDao.deleteBus(bv-1);
		System.out.println("＊＊＊＊＊＊＊삭제완료＊＊＊＊＊＊＊");
		
		busList();
	}

	@Override
	public void busModify() {
		BusVo bv = new BusVo();
		
		System.out.println("＊＊＊＊＊＊＊수정하기＊＊＊＊＊＊＊");
		busList();
		System.out.println();
		
		try{
			Scanner s = new Scanner(System.in);
			System.out.println("────────수정할  버스*번호* 입력────────");
			System.out.println(">>>");
			
			int a = Integer.parseInt(s.nextLine());
			
			System.out.println("────────수정할 버스종류 입력─────────");
			System.out.println(">>>");		
			String type =s.nextLine();
			System.out.println("────────버스가격입력────────");
			System.out.println(">>>");
			int price = Integer.parseInt(s.nextLine());
			System.out.println("────────버스번호판정보────────");
			System.out.println(">>>");
			String license = s.nextLine();
			
	
			bv.setBusNum(a);
			bv.setType(type);
			bv.setPrice(price);
			bv.setLicense(license);
			
			busDao.modifyBus(bv);
	
	
			
	//
	//	for (int i = 0; i < Database.tb_bus.size(); i++) {
	//			if (Session.loginUser.getId().equals(
	//					Database.tb_user.get(i).getId())) {
	//				
	//				System.out.println("수정완료");
	//			}
	//		}
	//		
			System.out.println("수정완료");
			
			busList();
		}catch(NumberFormatException ne){
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			busModify();
		}
	}

}


