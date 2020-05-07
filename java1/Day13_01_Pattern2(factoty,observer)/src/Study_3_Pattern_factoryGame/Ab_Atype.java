package Study_3_Pattern_factoryGame;

public class Ab_Atype implements Ab_AbstractItem {

	@Override
	public W_Weapon creatWeapon() {
		
		return new W_Gun();
	}

	@Override
	public B_Bomb creatBomb() {
		
		return new B_Dynamit();
	}

}
