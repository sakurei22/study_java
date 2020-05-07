package Work_10_BaseBallmember;

import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		DataClass dc;
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		while (true) {
			System.out.println("1.선수 추가 2.모두출력 3.정렬 4.수정 5.삭제 6.파일저장 7.종료");
			int choice = sc.nextInt();
			if (choice == 1) {
				dao.insert();

			} else if (choice == 2) {
				dao.allprint();
			
			} else if (choice == 3) {
				dao.memberSort();

			} else if (choice == 4) {
				dao.update();

			}else if (choice == 5) {
				dao.delete();

			}else if (choice == 6) {
				dao.saveData();
			}else if (choice == 7) {
				break;
				
			}
		}
	}
}
