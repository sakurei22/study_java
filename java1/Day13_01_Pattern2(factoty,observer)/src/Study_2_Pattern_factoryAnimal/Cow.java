package Study_2_Pattern_factoryAnimal;

public class Cow implements Animal {

	@Override
	public void printDescript() {
		System.out.println("황소 입니다.");
	}
	
	public void cowMethod() {
		System.out.println("음메~");
	}
}
