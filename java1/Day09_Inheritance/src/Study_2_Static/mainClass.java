package Study_2_Static;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class mainClass {
	public static void main(String[] args) {
		
		System.out.println("sn = "+StaticClass.staticNumber);
		
		StaticClass.staticNumber = 1;	// 객체생성 안했지만 접근. 어디서나 호출가능
		
		System.out.println("sn = "+StaticClass.staticNumber);
		
		StaticClass sc = new StaticClass();
		System.out.println("sc sn = " + sc.staticNumber);
		sc.method();
		
		StaticClass sc1= new StaticClass();
		System.out.println("sc1 sn= " + sc1.staticNumber);
		
		StaticClass1 s = StaticClass1.getIndstance();
		
		//Calendqr cal = new GregorianCalendar();
		//Calendar cal1 = Calendar.getInstance();
		
		
		//StaticClass1.staticMethod();
	}
}
