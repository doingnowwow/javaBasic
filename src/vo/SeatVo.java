package vo;

public class SeatVo { //좌석
	private String[][] seat;    //좌석
	private int bNum; //버스번호 외래키
	public String[][] getSeat() {
		return seat;
	}
	public void setSeat(String[][] seat2) {
		this.seat = seat2;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	

	
	
}
