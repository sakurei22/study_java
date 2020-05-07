package Work_2_BaseBallMember;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		BMemberDAO bd = new BMemberDAO();
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("선수관리프로그램");
			System.out.println("1.추가 2.삭제  3.수정  4.검색 5.모두출력 6.정렬 7.파일로저장");
			int choice = sc.nextInt();
			if (choice == 1) {
				bd.insert();

			} else if (choice == 2) {
				bd.delete();

			} else if (choice == 3) {
				bd.update();
				
			} else if (choice == 4) {
				bd.search();

			} else if(choice == 5) {
				bd.allMember();
				
			} else if(choice == 6) {
				bd.sorting();
			} else if(choice == 7) {
				bd.saveData();
			}
		}

	}

}
