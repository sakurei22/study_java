package Viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import Controller.BoardController;
import Controller.CommentController;
import Controller.MemberController;
import DTO.BoardDTO;
import DTO.CommentDTO;
import DTO.MemberDTO;

public class BoardViewer {
	public void showList(BoardController boardController, MemberController memberController, CommentController commentController, Scanner scan,
	        MemberDTO logInUser) { //게시글목록을 보여주는 메소드
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		ArrayList<BoardDTO> list = boardController.selectAll();
		System.out.println("=============");
		System.out.println("글번호\t제목\t작성자\t날짜");
		for (BoardDTO b : list) {
			System.out.printf("%d\t%s\t%s\t%s\n", b.getId(), b.getTitle(),
			        memberController.getWriterName(b.getWriterId()), sdf.format(b.getUpdatedDate().getTime()));
		}
		System.out.println("1.새로작성 2.개별보기");
		int choice = scan.nextInt();
		scan.nextLine();
		if (choice == 1) { // 글 새로작성 코드
			write(boardController, logInUser, scan);
			showList(boardController, memberController, commentController, scan, logInUser);
		} else if (choice == 2) { // 글 번호 선택해서 개별보기코드
			System.out.println("개별보기할 글번호를 입력하세요");
			int boardId = scan.nextInt();
			showOne(boardController, memberController, commentController, logInUser, scan, boardId);

		}
	}

	private void write(BoardController boardController, MemberDTO logInUser, Scanner scan) {
		BoardDTO b = new BoardDTO();
		b.setWriterId(logInUser.getId());
		b.setWrittenDate(Calendar.getInstance());
		b.setUpdatedDate(Calendar.getInstance());
		System.out.println("=================");
		System.out.println("제목");
		System.out.print(">");
		b.setTitle(scan.nextLine());
		System.out.println("=================");
		System.out.println("내용");
		System.out.print(">");
		b.setContent(scan.nextLine());
		boardController.insert(b);
		
		

	}

	private void showOne(BoardController boardController, MemberController memberController,
			CommentController commentController, MemberDTO logInUser, Scanner scan, int boardId) {
		ArrayList<CommentDTO> commentList = commentController.selectByBoardId(boardId);
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM일 dd일 HH시 mm분 ss초");
		BoardDTO selectedBoard = boardController.selectOne(boardId);
		if (selectedBoard == null) {
			System.out.println("게시글이 없습니다.");
		} else {
			System.out.println("============");
			System.out.println("제목: " + selectedBoard.getTitle());
			System.out.println("==============");
			System.out.println("작성자: " + memberController.getWriterName(selectedBoard.getWriterId()));
			System.out.println("=========");
			System.out.println("작성일: " + sdf.format(selectedBoard.getWrittenDate().getTime()));
			System.out.println("수정일: " + sdf.format(selectedBoard.getUpdatedDate().getTime()));
			System.out.println("==========");
			System.out.println("내용");
			System.out.println("==========");
			System.out.println(selectedBoard.getContent());
			System.out.println("==========");
			System.out.println("댓글");
			System.out.println("==========");
			
			for(CommentDTO c: commentList) {
				System.out.println(c.getContent()+" "+memberController.getWriterName(c.getBoardId())+" "+sdf.format(c.getUpdateDate().getTime()));
			}
					
			if (selectedBoard.getWriterId() == logInUser.getId()) {
				System.out.println("1.댓글달기 2.수정 3.삭제 4.리스트로돌아가기");
				System.out.print(">");
				int choice = scan.nextInt();
				if (choice ==1) { //댓글
					CommentViewer commentViewer = new CommentViewer();
					commentViewer.insert(boardId, logInUser.getId(), scan, commentController);
					showOne(boardController, memberController, commentController, logInUser, scan, boardId);
				}
				if (choice == 4) {
					showList(boardController, memberController, commentController, scan, logInUser);
				}else if(choice == 2) {
					//수정
					update(boardController, scan, selectedBoard);
					showOne(boardController, memberController, commentController, logInUser, scan, boardId);
				}else if(choice == 3) {
					//삭제메소드
					delete(boardController, selectedBoard);
					showList(boardController, memberController, commentController, scan, logInUser);
				}
			} else {
				System.out.println("1.댓글달기 2.리스트로 돌아가기");
				int choice = scan.nextInt();
				if (choice == 1) {//댓글달기
					CommentViewer commentViewer = new CommentViewer();
					commentViewer.insert(boardId, logInUser.getId(), scan, commentController);
					showOne(boardController, memberController, commentController, logInUser, scan, boardId);
				} else if (choice == 2) {
					showList(boardController, memberController, commentController, scan, logInUser);
				}
			}
		}
	}

	private void delete(BoardController boardController, BoardDTO selectedBoard) {
		boardController.delete(selectedBoard);
		
	}

	private void update(BoardController boardController, Scanner scan, BoardDTO selectedBoard) {
		scan.nextLine();
		System.out.println("제목: ");
		selectedBoard.setTitle(scan.nextLine());
		System.out.println("내용: ");
		selectedBoard.setContent(scan.nextLine());
		boardController.update(selectedBoard);
		
		
	}
}
