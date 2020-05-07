package day02;
//필드: 차량번호, 차량 종류, 차량 색깔, 최고속도, 연비
//메소드 : 생성자,  getter/setter, 출발, 정지, toString()
public class Car {
	private String number;
	private String type;
	private String color;
	private int max;
	private int year;
	
		public String getNumber() {
		return number;
	}

		public void setNumber(String number) {
		this.number = number;
	}

		public String getType() {
		return type;
	}

		public void setType(String type) {
		this.type = type;
	}

		public String getColor() {
		return color;
	}

		public void setColor(String color) {
		this.color = color;
	}

		public int getMax() {
		return max;
	}

		public void setMax(int max) {
		this.max = max;
	}

		public int getYear() {
		return year;
	}

		public void setYear(int year) {
		this.year = year;
	}

	public Car() {
		number = "";
		type = "";
		color = "";
		max = 0;
		year = 0;
	}
	public void start() {
		System.out.println("출발");
	}
	public void stop() {
		System.out.println("정지");
	}

	@Override
	public String toString() {
		return "Car [number=" + number + ", type=" + type + ", color=" + color + ", max=" + max + ", year=" + year
		        + "]";
	}
	
	
}
