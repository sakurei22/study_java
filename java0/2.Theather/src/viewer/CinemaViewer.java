package viewer;

import java.util.ArrayList;
import java.util.Scanner;
import controller.MovieController;
import dto.MovieDTO;

public class CinemaViewer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MovieController movieController = new MovieController();
		while (true) {
			System.out.println("----비트 시네마-----");
			System.out.println("1.영화전체목록 2.영화추가 3.종료");
			System.out.print(">");
			int choice = scanner.nextInt();
			if(choice ==3) {
				System.out.println("이용해주셔서 갑사합니다.");
				break;
			}else if(choice ==1) {
				showAll(scanner, movieController);
			}else if(choice ==2) {
				add(scanner, movieController);
			}
		}
		scanner.close();
	}
	private static void showAll(Scanner scanner, MovieController controller) {
		ArrayList<MovieDTO> list = controller.selectAll();
		System.out.println("----전체 목록----");
			for(int i = 0; i < list.size(); i++) {
			System.out.println(i+"번"+ list.get(i));
			}
			System.out.println("1.개별보기 2.영화추가 3.돌아가기");
			int choice = scanner.nextInt();
			if(choice ==1) {
				showOne(scanner, controller);
			}else if(choice ==2) {
				add(scanner, controller);
			}else if(choice ==3) {
				//돌아가기
			}
				
	}
	
	private static void add(Scanner scanner, MovieController controller) {
		MovieDTO m = new MovieDTO();
		scanner.nextLine();
		System.out.println("제목: ");
		m.setTitle(scanner.nextLine());
		System.out.println("길이 ");
		m.setLength(scanner.nextInt());
		controller.insert(m);
		showAll(scanner, controller);
		
	}
	private static void showOne(Scanner scanner, MovieController controller) {
		System.out.println("개별로 보실 영화번호를 선택하세요");
		System.out.print(">");
		int choice = scanner.nextInt();
		MovieDTO m = controller.select(choice);
		System.out.println("====" + m.getTitle() + "영화정보====");
		System.out.println("제목: " + m.getTitle());
		System.out.println("길이: " + m.getLength());
		System.out.println("==================");
		System.out.println("1.수정 2.삭제 3.리스트 보기");
		choice = scanner.nextInt();
		if(choice ==1) {
			update(scanner, controller, m);
		}else if(choice ==2) {
			delete(scanner, controller, m);
		}else if(choice ==3) {
			showAll(scanner, controller);
		}
	}
	private static void delete(Scanner scanner, MovieController controller, MovieDTO m) {
		controller.delete(m);
		showAll(scanner, controller);
	}
	private static void update(Scanner scanner, MovieController controller, MovieDTO m) {
		scanner.nextLine();
		System.out.println("제목: ");
		m.setTitle(scanner.nextLine());
		System.out.println("길이: ");
		m.setLength(scanner.nextInt());
		controller.update(m);
		showAll(scanner, controller);
	}
}

