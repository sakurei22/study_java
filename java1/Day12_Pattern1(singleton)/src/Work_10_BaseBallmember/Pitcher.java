package Work_10_BaseBallmember;

public class Pitcher extends HumanDTO {

	private int win;
	private int lose;
	private double defence;
	
	public Pitcher() {
	}

	public Pitcher(int number, String name, int age, double height, int win, int lose, double defence) {
		super(number, name, age, height);
		this.win = win;
		this.lose = lose;
		this.defence = defence;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getDefence() {
		return defence;
	}

	public void setDefence(double defence) {
		this.defence = defence;
	}

	@Override
	public void infomation() {
		super.infomation();		// human투스트링 + 피처 정보
		System.out.println("방어율: "+ defence);
	}

	@Override
	public String toString() {	// fileRead를 위해 토큰으로 toString 정리
		return super.toString() + "-" + win + "-" + lose + "-" + defence;
	}
}
