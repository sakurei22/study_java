package Study_3_Pattern_factoryGame;

public class Person {
	public W_Weapon m_Weapon;	//멤버변수
	public B_Bomb m_Bomb;
	
	public void create(Ab_AbstractItem aw) {
		m_Weapon = aw.creatWeapon();	// 멤버변수 설정
		m_Bomb = aw.creatBomb();
	}
}
