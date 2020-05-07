package Work_2_BaseBallMember;

public class Batter extends Human {
	private int bat;
	private int hit;
	private double batAvg;
	
	public Batter() {
		
	}
	public Batter(int number, String name, int age, double height, int bat, int hit, double batAvg) {
		super(number, name, age, height);
		this.bat = bat;
		this.hit = hit;
		this.batAvg = batAvg;
	}

	public int getBat() {
		return bat;
	}

	public void setBat(int bat) {
		this.bat = bat;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getBatAvg() {
		return batAvg;
	}

	public void setBatAvg(double batAvg) {
		this.batAvg = batAvg;
	}

	@Override
	public String toString() {
		return "Batter [bat=" + bat + ", hit=" + hit + ", batAvg=" + batAvg + ", number=" + number + ", name=" + name
				+ ", age=" + age + ", height=" + height + "]";
	}
	
	
	

}
