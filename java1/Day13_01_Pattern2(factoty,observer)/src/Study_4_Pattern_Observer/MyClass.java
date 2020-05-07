package Study_4_Pattern_Observer;

import java.util.Observable;

public class MyClass extends Observable {	//감시 대상 클래스
	
	private String preArg = null;

	// 일반메소드
	
	@Override
	public void notifyObservers(Object arg) {
		String str = (String)arg;
		
		// preArg의 변화가 없을 때
		if(str.equals(preArg)) return;	
		
		// 변화가 있을 때
		preArg = str;
		setChanged();	// reset
		
		super.notifyObservers(arg);
		clearChanged();
		
	}
	
}
