package Study_3_Pattern_factoryGame;

import java.util.ArrayList;
import java.util.List;

public class mainClass {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<Person>();

		Person human1 = new Person();
		human1.create(new Ab_Atype());
		list.add(human1);

		human1 = new Person();
		human1.create(new Ab_Btype());
		list.add(human1);

		human1 = new Person();
		human1.create(new Ab_Atype());
		list.add(human1);

		human1 = new Person();
		human1.create(new Ab_Btype());
		list.add(human1);

		human1 = new Person();
		human1.create(new Ab_Atype());
		list.add(human1);

		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);
			System.out.println("human"+(i+1)+"의 장비");
			list.get(i).m_Weapon.drawWeapon();
			list.get(i).m_Bomb.drawBomb();

		}
	}
}