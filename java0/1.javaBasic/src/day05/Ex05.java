package day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex05 {
	public static void main(String[] args) {
		//Java에서 날짜(시간)을 담당하는 클래스는
		//java.util.DateTime, java.sql.Datetime, java.util.Calendar
		//근데 java.sql.DateTime 은 이름만 봐도 sql의 데이터 타입입니다.
		//우리는 일상적으로 쓰는 시간은 DateTime과 Calendar가 있다.
		//하지만 자바가 더이상 DateTime을 지원하지 않아 
		//Calendar를 써야한다.
		
		// Calendar calendar = new Calendar(); -> 캘린더 객체는 new로 초기화하지 않는다.
		// 캘린더 객체는 캘린더의 스태틱 메소드인 getInstance로 현재 시간으로 초기화한다.
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		
		//Calendar 객체의 필드들을 출력해봅시다
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 무슨요일인지를  int로
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); // 1년중 며칠쨰
		System.out.println(calendar.get(Calendar.HOUR));	//오전/오후 몇시인지
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY)); //24시중 몇시
		System.out.println(calendar.get(Calendar.MILLISECOND)); // 지금 시간 기준 몇 밀리초인지
		System.out.println(calendar.get(Calendar.MONTH)); //1년 중 몇월. 0월부터 시작..
		System.out.println(calendar.get(Calendar.WEEK_OF_MONTH)); // 해당 월의 몇번쨰 주
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR)); //해당 년의 몇번쨰 주
		System.out.println(calendar.get(Calendar.YEAR)); //몇년
		System.out.println(calendar.get(Calendar.SECOND));// 몇초
		System.out.println(calendar.get(Calendar.MINUTE));// 몇분
		//그럼 지금 시간은 몇년.월.일.시.분.초?
		String timeString = calendar.get(Calendar.DAY_OF_YEAR)+"년"+
							calendar.get(Calendar.MONTH)+"월"+
							calendar.get(Calendar.DATE)+"일";
		System.out.println(timeString);
		
		SimpleDateFormat sdf = new SimpleDateFormat("G yyyy년 MM월 dd일 hh시 mm분 ss초(z)");
		System.out.println(sdf.format(calendar.getTime()));
		sdf = new SimpleDateFormat("hh시 mm분 ss초");
		
		try {
			calendar.setTimeInMillis(sdf.parse("3시 5분 25초").getTime()); //오류부분 마우스 -> surround error catch
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(calendar.get(Calendar.HOUR));
	}
}
