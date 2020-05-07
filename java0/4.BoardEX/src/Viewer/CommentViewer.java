package Viewer;

import java.util.Scanner;

import Controller.CommentController;
import DTO.CommentDTO;

public class CommentViewer {
	public void insert(int boardId, int memberId, Scanner scan, CommentController commentController) {
		CommentDTO c = new CommentDTO();
		c.setBoardId(boardId);
		c.setMemberId(memberId);
		scan.nextLine();
		System.out.println("댓글내용: ");
		c.setContent(scan.nextLine());
		commentController.insert(c);
	}
}
