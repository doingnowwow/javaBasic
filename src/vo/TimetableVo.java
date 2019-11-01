package vo;

public class TimetableVo { //시간표
	private int ttNum;
	private String startTerminal;
	private String arriveTerminal;
	private String startTime;
	private String arriveTime;
	private int bNum; //버스번호 외래키
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTtNum() {
		return ttNum;
	}
	public void setTtNum(int ttNum) {
		this.ttNum = ttNum;
	}
	public String getStartTerminal() {
		return startTerminal;
	}
	public void setStartTerminal(String startTerminal) {
		this.startTerminal = startTerminal;
	}
	public String getArriveTerminal() {
		return arriveTerminal;
	}
	public void setArriveTerminal(String arriveTerminal) {
		this.arriveTerminal = arriveTerminal;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
}
