package vo;

public class SeatReserVo { //예매좌석
	//private String reSeat; //예매번호 + 좌석번호
	private String age;  //성인 or 학생
	private String row;   //열
	private String col1;    //좌석번호 
	
	
	
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}

	
/*	public String getReSeat() {
		return reSeat;
	}
	public void setReSeat(String reSeat) {
		this.reSeat = reSeat;
	}*/
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}


	
	
}
