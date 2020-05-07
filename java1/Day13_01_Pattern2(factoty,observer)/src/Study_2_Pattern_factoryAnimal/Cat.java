package Study_2_Pattern_factoryAnimal;

public class Cat implements Animal {

	@Override
	public void printDescript() {
		System.out.println("야옹이입니다.");
	}
	
	public void catMethod() {
		System.out.println("야옹 야옹");
	}
}
