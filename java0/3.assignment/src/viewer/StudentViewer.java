package viewer;

import java.util.ArrayList;
import java.util.Scanner;
import controller.StudentController;
import dto.StudentDTO;

public class StudentViewer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		StudentController studentController = new StudentController();
		while (true) {
			System.out.println("==학생관리 프로그램==");
			System.out.println("1.전체보기 2.새로입력 3.종료");
			System.out.print(">");
			int choice = scan.nextInt();
			if (choice == 3) {
				System.out.println("종료되었습니다.");
				break;
			} else if (choice == 1) {
				showAll(scan, studentController);
			} else if (choice == 2) {
				add(scan, studentController);
			}

		}
		scan.close();
	}

	private static void showAll(Scanner scan, StudentController controller) {
		ArrayList<StudentDTO> list = controller.selectAll();
		System.out.println("====목록보기====");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "번" + list.get(i));
		}
		System.out.println("1.새로 입력 2.개별 보기 3.돌아가기");
		int choice = scan.nextInt();
		if (choice == 1) {
			// 새로입력하는 메소드
			add(scan, controller);
		} else if (choice == 2) {
			// 개별보기
			showOne(scan, controller);
		} else if (choice == 3) {
			// 돌아가기
		}
	}

	private static void add(Scanner scan, StudentController controller) {
		StudentDTO s = new StudentDTO();
		scan.nextLine();
		System.out.println("이름: ");
		s.setName(scan.nextLine());
		System.out.println("전공: ");
		s.setMajor(scan.nextLine());
		System.out.println("국어: ");
		s.setKor(scan.nextInt());
		System.out.println("영어: ");
		s.setEng(scan.nextInt());
		System.out.println("수학: ");
		s.setMath(scan.nextInt());
		controller.insert(s);
		showAll(scan, controller);
	}

	private static void showOne(Scanner scan, StudentController controller) {
		System.out.println("개별로 보실 학생의 번호를 입력하세요");
		System.out.print(">");
		int choice = scan.nextInt();
		StudentDTO s = controller.select(choice);
		System.out.println("====" + s.getName() + "학생정보====");
		System.out.println("이름: " + s.getName());
		System.out.println("학번: " + s.getId());
		System.out.println("전공: " + s.getMajor());
		System.out.println("국어: " + s.getKor());
		System.out.println("영어: " + s.getEng());
		System.out.println("수학: " + s.getMath());
		System.out.println("==================");
		System.out.println("1.수정 2.삭제 3.리스트 보기");
		choice = scan.nextInt();
		if (choice == 1) {
			update(scan, controller, s);
		} else if (choice == 2) {
			delete(scan, controller, s);
		} else if (choice == 3) {
			showAll(scan, controller);
		}
	}

	private static void update(Scanner scan, StudentController controller, StudentDTO s) {
		scan.nextLine();
		System.out.println("이름: ");
		s.setName(scan.nextLine());
		System.out.println("전공: ");
		s.setMajor(scan.nextLine());
		System.out.println("국어: ");
		s.setKor(scan.nextInt());
		System.out.println("영어: ");
		s.setEng(scan.nextInt());
		System.out.println("수학: ");
		s.setMath(scan.nextInt());
		controller.update(s);
		showAll(scan, controller);
	}

	private static void delete(Scanner scan, StudentController controller, StudentDTO s) {
		controller.delete(s);
		showAll(scan, controller);
	}
}
