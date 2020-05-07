package day05;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;

// 시간 차이 계산하기
public class Ex06 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.set(Calendar.HOUR, 2);
		// 가장 무식한 방법
		System.out.println(cal2.getTimeInMillis() - cal.getTimeInMillis());
		// 위의 코드는 1/1000초 단위이기때문에
		// 우리가 분으로 표시하려면
		// 나누기 1000 나누기 60
		// 시간으로 표시하려면 나누기1000 나누기60 나누기60

		System.out.println((cal2.getTimeInMillis() - cal.getTimeInMillis()) / 1000 / 60 / 60);
		
		// Duration 과 Period (Java 1.8이후 추가)
		// Duration: 시분초 단위 차이
		// Period: 연월일 단위 차이
		// 얘네들은 calendar도 아닌 LocalDateTime이라는걸 사용한다.
		
		LocalDateTime ldt1 = LocalDateTime.of(2019, 11, 8, 16, 31, 0);
		LocalDateTime ldt2 = LocalDateTime.now();
		ldt2 = ldt2.plusHours(2);
		
		Duration d = Duration.between(ldt1, ldt2);
		System.out.println(d.toMinutes());
	
	}
}
