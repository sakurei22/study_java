package Viewer;

import java.util.Scanner;

import Controller.BoardController;
import Controller.CommentController;
import Controller.MemberController;

import DTO.MemberDTO;

public class BoardMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberController memberController = new MemberController();
		BoardController boardController = new BoardController();
		CommentController commentController = new CommentController();
		
		BoardViewer boardViewer = new BoardViewer();
		MemberViewer memberViewer = new MemberViewer();
		
		while (true) { // 기본화면에서 로그인할지 종료할지 선택 -> 종료면 종료 로그인이면 로그인화면이동
			System.out.println("======비트 게시판======");
			System.out.println("1.로그인 2.회원가입 3.종료");
			int choice = scan.nextInt();

			if (choice == 1) { // 로그인메소드
				MemberDTO logInUser = memberViewer.logIn(scan, memberController);

				if (logInUser != null) { // 로그인 성공 이후 코드
					while (true) {
						System.out.println(logInUser.getName() + " 사용자님 환영합니다.");
						System.out.println("1.게시판보기 2.회원 정보 보기 3.로그아웃");
						choice = scan.nextInt();

						if (choice == 1) { // 게시판목록보는 코드
							boardViewer.showList(boardController, memberController,commentController, scan, logInUser);

						} else if (choice == 2) { // 회원정보 출력하고 수정할수있는코드
							memberViewer.showOne(logInUser, scan, memberController, boardController);
						} else if (choice == 3) { // 로그아웃코드
							System.out.println("로그아웃되었습니다.");
							logInUser = null;
							break;
						}
					}

				} else {
					System.out.println("로그인 실패");
				}
			} else if (choice == 2) { // 회원가입메소드
				memberViewer.insert(memberController, scan);

			} else if (choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}
		scan.close();
	}
}
