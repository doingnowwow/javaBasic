package vo;

import java.util.Date;

public class ReserveVo { //예매
	private int rNum;
	private int rPrice;
	private String priceDate;
	private String reDate;
	private	String cancle;
	private int bNum; //버스번호키 외래키
	private int reSeat; //예매번호 + 좌석번호 외래키
	private int ttNum; //시간표 번호 외래키
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	private String age;
	
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getArriveTime() {
		return ArriveTime;
	}
	public void setArriveTime(String arriveTime) {
		ArriveTime = arriveTime;
	}
	private String StartTime;
	private String ArriveTime;
	
	private String selstartTerminal;   //선택한 출발지
	private String selarriveTerminal;//선택한 도착지 
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getrPrice() {
		return rPrice;
	}
	public void setrPrice(int rPrice) {
		this.rPrice = rPrice;
	}
	public String getPriceDate() {
		return priceDate;
	}
	public void setPriceDate(String priceDate) {
		this.priceDate = priceDate;
	}
	public String getReDate() {
		return reDate;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
	public String getCancle() {
		return cancle;
	}
	public void setCancle(String cancle) {
		this.cancle = cancle;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public int getReSeat() {
		return reSeat;
	}
	public void setReSeat(int reSeat) {
		this.reSeat = reSeat;
	}
	public int getTtNum() {
		return ttNum;
	}
	public void setTtNum(int ttNum) {
		this.ttNum = ttNum;
	}
	public String getSelstartTerminal() {
		return selstartTerminal;
	}
	public void setSelstartTerminal(String selstartTerminal) {
		this.selstartTerminal = selstartTerminal;
	}
	public String getSelarriveTerminal() {
		return selarriveTerminal;
	}
	public void setSelarriveTerminal(String selarriveTerminal) {
		this.selarriveTerminal = selarriveTerminal;
	}



	
	
}
