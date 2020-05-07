package Work_1_Member;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		MemberDao dao = new MemberDao();
		
		int choice; 
		
		while (true) {
			System.out.println("1.추가 2.삭제 3.검색 4.수정 5.전체보기 6.종료");
			choice = sc.nextInt();

			if (choice == 1) {
				dao.insert();
				
			} else if (choice == 2) {
				dao.delete();

			} else if (choice == 3) {
				dao.selectOne();

			} else if (choice == 4) {
				dao.update();
				
			} else if(choice == 5) {
				dao.selectAll();
				
			} else {
				System.exit(0); // 위급시 프로그램 강제 종료
				System.out.println("이용해주셔서 감사합니다.");
				
				break;
			}
		}
	}
}
