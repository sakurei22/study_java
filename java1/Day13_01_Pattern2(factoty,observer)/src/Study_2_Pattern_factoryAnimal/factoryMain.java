package Study_2_Pattern_factoryAnimal;

import java.util.ArrayList;
import java.util.List;

public class factoryMain {
	public static void main(String[] args) {
		/*
		 	Singleton Pattern
			 	중심이 되는 데이터관리 template(list, map)을 중심으로
			 	어디서나 접근하기 쉽게 만드는 패턴
		 		instance는 한개.
		 	
		 	Factory Pattern
		 		원하는 클래스의 형태를 생성하기 용이한 패턴. ex)게임
		 		
		 		interface, class 동물
		 		
		 		class : 고양이, 멍멍이, 황소
		 		
		 		Anmimal a = new Cat();  - 상속
		 */
		
		List<Animal> list = new ArrayList<Animal>();
		
		Animal ani1 = AnimalFactory.create("멍멍이");
		ani1.printDescript();
		list.add(ani1);
		
		ani1 = AnimalFactory.create("야옹이");
		ani1.printDescript();
		list.add(ani1);
		
		ani1 = AnimalFactory.create("황소");
		ani1.printDescript();
		list.add(ani1);
		
		for (int i = 0; i < list.size(); i++) {
			Animal a = list.get(i);
			a.printDescript();
			if(a instanceof Cat) {
				((Cat)a).catMethod();
			}else if(a instanceof Cow) {
				((Cow)a).cowMethod();
			}else if(a instanceof Dog) {
				((Dog)a).dogMethod();
			}
		}
	}
}