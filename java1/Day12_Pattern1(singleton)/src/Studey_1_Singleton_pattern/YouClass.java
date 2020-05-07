package Studey_1_Singleton_pattern;

public class YouClass {
	private int youNum;
	private String youName;
/*
	public void setYouNum(int youNum) {
		this.youNum = youNum;
	}
*/
	public void method() {
		Singleton single = Singleton.getInstance();
		youNum = single.num;	// singleton에서 넘어온 변수
		youName = single.name;	//singleton에서 넘어온 변수
		System.out.println("youNum = " + youNum +" / youName =" + youName);
	}
}