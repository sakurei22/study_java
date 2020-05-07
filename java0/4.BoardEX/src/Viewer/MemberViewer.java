package Viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.BoardController;
import Controller.MemberController;
import DTO.BoardDTO;
import DTO.MemberDTO;

public class MemberViewer {
	public void showOne(MemberDTO logInUser, Scanner scan, MemberController memberController, BoardController boardController) {
		System.out.println("===========");
		System.out.println("이름: " + logInUser.getName());
		System.out.println("비밀번호: " + logInUser.getPassword());
		System.out.println("==========");
		System.out.println("작성글목록");
		ArrayList<BoardDTO> list = boardController.selectAll(logInUser.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		System.out.println("글번호 \t 제목\t 작성자\t 작성일");
		for (BoardDTO b : list) {
			System.out.printf("%d\t %s\t %s\t %s\n", b.getId(), b.getTitle(),
			        memberController.getWriterName(b.getWriterId()),
			        sdf.format(b.getUpdatedDate().getTime()));
		}
		System.out.println("1.회원정보수정 2.회원탈퇴");
		System.out.print(">");
		int choice = scan.nextInt();
		if(choice ==1) {
			//수정메소드
			update(logInUser, scan, memberController);
			showOne(logInUser, scan, memberController, boardController);
			
		}else if(choice ==2) {//탈퇴메소드
			delete(logInUser, scan, memberController);
			
		}
	}

	private void delete(MemberDTO logInUser, Scanner scan, MemberController memberController) {
		scan.nextLine();
		System.out.println("정말로 탈퇴하시겠습니까?");
		System.out.print("(y/n)");
		String agreement = scan.nextLine();
		if(agreement.equalsIgnoreCase("y")) {
			System.out.println("탈퇴를위해 비밀번호를 다시 입력해주세요: ");
			String password = scan.nextLine();
			if(password.equals(logInUser.getPassword())) {
				//회언이 동의도하고 비밀번호도입력햇으니 탈퇴메소드 호출
				memberController.delete(logInUser);
			}
		}
		
	}

	private void update(MemberDTO logInUser, Scanner scan, MemberController memberController) {
		scan.nextLine();
		System.out.println("이릅:");
		logInUser.setName(scan.nextLine());
		System.out.println("비밀번호: ");
		logInUser.setPassword(scan.nextLine());
		memberController.update(logInUser);
	}

	public void insert(MemberController memberController, Scanner scan) {
		scan.nextLine();
		MemberDTO memberDTO = new MemberDTO();
		System.out.print("사용자 id: ");
		memberDTO.setUserId(scan.nextLine());
		System.out.print("사용자 pw: ");
		memberDTO.setPassword(scan.nextLine());
		System.out.print("사용자 닉네임: ");
		memberDTO.setName(scan.nextLine());
		memberController.insert(memberDTO);
		
	}

	public MemberDTO logIn(Scanner scan, MemberController memberController) {
		scan.nextLine();
		System.out.print("id: ");
		String userId = scan.nextLine();
		System.out.print("password: ");
		String password = scan.nextLine();
		return memberController.selectOne(userId, password);
		
	}
	
}

















