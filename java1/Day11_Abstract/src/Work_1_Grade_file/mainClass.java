package Work_1_Grade_file;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		StudentDao dao = new StudentDao();
	
		while(true) {
			System.out.println("1.학생정보 추가	(이름, 나이, 영어, 수학)");
			System.out.println("2.학생정보 삭제");
			System.out.println("3.학생정보 검색");
			System.out.println("4.학생정보 수정");
			System.out.println("5.학생성적 조회(1명)");
			System.out.println("6.전체 학생성적 총점");
			System.out.println("7.전체 학생성적 평균");
			System.out.println("8.학생성적순 출력");
			System.out.println("9.학생저장");
			System.out.println("10.학생정보 모두 출력");
			System.out.println("11.종료");
			
			System.out.println("어느 작업을 하시겠습니까? >> ");
			String choice = sc.next();
			
			switch(choice) {
				case "1":
					dao.insert();
					break;
				case "2":
					dao.delete();
					break;
				case "3":
					dao.select();
					break;
				case "4":
					dao.update();
					break;
				case "5":
					dao.selectOne();
					break;
				case "6":
					dao.allGrade();
					break;
				case "7":
					dao.allAvg();
					break;
				case "8":
					dao.gradeSort();
					break;
				case "9":
					dao.saveData();
					break;
				case "10":
					dao.allStudents();					
					break;
				case "11":
					System.exit(0);					
					break;
				default:
					System.out.println("잘못 입력하셨습니다");
			}
			
		}
	
	}

}





