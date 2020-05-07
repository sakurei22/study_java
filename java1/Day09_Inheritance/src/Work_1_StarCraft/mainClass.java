package Work_1_StarCraft;

import Work_1_StarCraft_Child.Marin;
import Work_1_StarCraft_Child.Race;
import Work_1_StarCraft_Child.Tank;
import Work_1_StarCraft_Parent.StarCraft;

public class mainClass {

	public static void main(String[] args) {
		
		Marin m[] = new Marin[10];
		Race r[] = new Race[10];
		Tank t[] = new Tank[10];
		
		StarCraft starArr[] = new StarCraft[5];
		
		starArr[0] = new Marin();
		starArr[1] = new Race();
		starArr[2] = new Marin();
		starArr[3] = new Tank();
		starArr[4] = new Tank();
		
		// Over Ride
		for (int i = 0; i < starArr.length; i++) {
			starArr[i].life();
		}
		
		//instanceof	: 인스턴스분별. 객체 판별 예약어
		for (int i = 0; i < starArr.length; i++) {
			StarCraft sc = starArr[i];
			if(sc instanceof Marin) {
				Marin ma = (Marin)sc;
				ma.run();
				
				// ((Marin)sc).run();
				
			}else if(sc instanceof Race) {
				Race ra = (Race)sc;
				ra.fly();
				
			}else if(sc instanceof Tank) {
				Tank ta = (Tank)sc;
				ta.canon();
			}
		}
		
	}

}
