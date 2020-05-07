package Study_3_Pattern_factoryGame;

public class Ab_Btype implements Ab_AbstractItem {

	@Override
	public W_Weapon creatWeapon() {
	
		return new W_Sword();
	}

	@Override
	public B_Bomb creatBomb() {

		return new B_C4();
	}

}
