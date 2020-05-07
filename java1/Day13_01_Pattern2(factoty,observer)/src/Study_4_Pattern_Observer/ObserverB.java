package Study_4_Pattern_Observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverB implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		
		String str = (String)arg;
		System.out.println("감시자 B입니다. 통지를 받았음: "+str);
	}

}
