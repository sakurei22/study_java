package main;

import db.DBConnection;
import singleton.Singleton;

public class main {
	/*
	   1. controller 생성 -> ServiceImpl 생성 -> DaoImpl 생성
	   2. 인터페이스 memberService -> MemberServiceImpl, 	인터페이스 memberDao -> MemberDaoImpl
	   			메소드 프로토타입	   -> 	dao 호출 코드 ,				메소드 프로토타입	 ->  실제 동작 쿼리 코드
	   
	   3. Singleton 생성 ( loginID, Controller ) 여러개일 필요가 없는 것들.
	   4. MemberController에  view를 불러오는 메소드 작성(login, regi, regiAf 등)  
	   5. view패키지 생성 
	   6. memberDao getId 프로토타입 생성 -> DaoImpl에 코드 작성(override) /
	      memService getId 프로토타입생성 -> ServiceImpl코드 작성(override)
	    	
	    	View
	    	Controller  : Service와 대화 : View와 대화
	    	Service 	: Controller와 Dao의 중계
	    	Dao 		: DB와 대화
	   		DB
	   
	   		<ex> 
	    	1) longinView 
	    	2) -> 회원가입 버튼  s.memCtrl.regi()호출 -> new accountView();
	    	3) 작성된 dto 정보를 가지고 s.memCtrl.regiAf 이용해  
	  
	 */
	
	public static void main(String[] args) {
		DBConnection.initConnection();
		
		Singleton s = Singleton.getInstance();
		s.memCtrl.login();
	}
}
