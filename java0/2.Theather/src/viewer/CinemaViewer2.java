package viewer;

import java.util.ArrayList;
import java.util.Scanner;
import controller.MovieController;
import dto.MovieDTO;

public class CinemaViewer2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MovieController movieController = new MovieController();
		showMain(scanner, movieController);
		scanner.close();
	}

	private static void showMain(Scanner scanner, MovieController movieController) {
		while (true) {
			System.out.println("====비트 영화관리 프로그램====");
			System.out.println("1.목록보기 2.새로입력 3.종료");
			int choice = scanner.nextInt();
			if (choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			} else if (choice == 1) {
				showList(scanner, movieController);
			} else if (choice == 2) {
				// 입력하는메소드
				insert(scanner, movieController);
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	private static void showList(Scanner scanner, MovieController controller) {
		ArrayList<MovieDTO> list = controller.selectAll();
		System.out.println("======목록보기=====");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "번" + list.get(i));
		}
		System.out.println("============");
		System.out.println("1.새로입력 2.개별보기 3.메인메뉴로");
		int choice = scanner.nextInt();
		if (choice == 1) {
			insert(scanner, controller);
			
		} else if (choice == 2) {
			// 개별보기메소드
			showOne(scanner, controller);
		} else if (choice == 3) {
			// showMain(scanner, movieController); - 결국 showMaint 무한루프가 한번더 실행.
			// 따라서 바깥쪽 무한루프는 살아있게된다.
		} else {
			System.out.println("잘못입력하셨습니다.");
			showList(scanner, controller);
		}
	}

	private static void showOne(Scanner scanner, MovieController controller) {
		System.out.println("개별 보기할 번호를 눌러주세요");
		int id = scanner.nextInt();
		if (id < 0 || id >= controller.selectAll().size()) {
			System.out.println("잘못입력하셨습니다.");
			showOne(scanner, controller);

		} else {
			MovieDTO m = controller.select(id);
			System.out.println("====="+m.getTitle()+"====");
			System.out.println("길이: " + m.getLength());
			System.out.println("1.수정 2.삭제 3.리스트로");
			int choice = scanner.nextInt();
			if (choice == 1) {
				update(scanner, controller, m);
			} else if (choice == 2) {
				controller.delete(m);
				showList(scanner, controller);
			} else if (choice == 3) {
				showList(scanner, controller);
			}
		}
	}
	private static void update(Scanner scanner, MovieController controller, MovieDTO m) {
		scanner.nextLine();
		System.out.println("제목: ");
		m.setTitle(scanner.nextLine());
		System.out.println("길이: ");
		m.setLength(scanner.nextInt());
		controller.update(m);
		showList(scanner, controller);
	}
	private static void insert(Scanner scanner, MovieController controller) {
		scanner.nextLine();
		MovieDTO m = new MovieDTO();
		System.out.println("제목: ");
		m.setTitle(scanner.nextLine());
		System.out.println("길이: ");
		m.setLength(scanner.nextInt());
		controller.insert(m);
		showList(scanner, controller);
	}
}
