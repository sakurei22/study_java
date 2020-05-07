package Study_5_OverRide;

import Study_5_OverRide_Child.JaneClass;
import Study_5_OverRide_Child.TomClass;
import Study_5_OverRide_Parents.ParentClass;

public class mainClass {
	public static void main(String[] args) {
		
		TomClass tc = new TomClass();
		JaneClass jc = new JaneClass();
		tc.ParentMethod();
		jc.ParentMethod();
		
		// Over Ride 목적: 하나의 "instacne 형태"로 쉽게 관리하기 위함. 
		
		ParentClass p1 = new TomClass();
		p1.ParentMethod();
			// p1.func() 는 접근불가
		
		((TomClass)p1).func();
		
		TomClass t = (TomClass)p1;
		t.func();
		
		
		ParentClass p2 = new JaneClass();
		p2.ParentMethod();
	
		TomClass tomArr[] = new TomClass[5];
		JaneClass janeArr[] = new JaneClass[5];
		
		tomArr[0] = new TomClass();
		janeArr[0] = new JaneClass();
		janeArr[1] = new JaneClass();
				
		
		ParentClass parArr[] = new ParentClass[10];
		parArr[0] = new TomClass();
		parArr[1] = new JaneClass();
		parArr[2] = new JaneClass();
	}
}
