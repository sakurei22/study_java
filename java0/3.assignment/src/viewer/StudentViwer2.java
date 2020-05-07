//package viewer;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import controller.StudentController;
//import dto.StudentDTO;
//
//public class StudentViewer {
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		StudentController studentController = new StudentController();
//		while (true) {
//			System.out.println("==학생관리 프로그램==");
//			System.out.println("1.학생목록 2.종료");
//			System.out.println(">");
//			int choice = scanner.nextInt();
//			if (choice == 2) {
//				System.out.println("종료되었습니다.");
//				break;
//			} else if (choice == 1) {
//				System.out.println("학생목록페이지");
//				System.out.println("1.학생목록보기");
//				choice = scanner.nextInt();
//				if (choice == 1) {
//					ArrayList<StudentDTO> list = studentController.selectAll();
//					for (int i = 0; i < list.size(); i++) {
//						StudentDTO s = list.get(i);
//						System.out.println(i + "번: " + s.getName());
//					}
//					System.out.println("1.새로입력 2.상세보기");
//					choice = scanner.nextInt();
//					if (choice == 1) {
//						StudentDTO studentDTO = new StudentDTO();
//						scanner.nextLine();
//						System.out.println("이름: ");
//						studentDTO.setName(scanner.nextLine());
//						System.out.println("전공");
//						studentDTO.setMajor(scanner.nextLine());
//						System.out.println("국어");
//						studentDTO.setKor(scanner.nextInt());
//						System.out.println("영어");
//						studentDTO.setEng(scanner.nextInt());
//						System.out.println("수학");
//						studentDTO.setMath(scanner.nextInt());
//
//						studentController.insert(studentDTO);
//					} else if (choice == 2) {
//						System.out.println("상세보기할 학생의 번호를 입력하세요");
//						int index = scanner.nextInt();
//						if (index < 0 || index > list.size() - 1) {
//							System.out.println("잘못입력하셨습니다.");
//						} else {
//							StudentDTO studentDTO = studentController.select(index);
//							System.out.println("학생번호: " + studentDTO.getId());
//							System.out.println("학생이름: " + studentDTO.getName());
//							System.out.println("전공: " + studentDTO.getMajor());
//							System.out.println("국어: " + studentDTO.getKor());
//							System.out.println("영어: " + studentDTO.getEng());
//							System.out.println("수학: " + studentDTO.getMath());
//							System.out.println("======================");
//							System.out.println("1.수정 2.삭제");
//							choice = scanner.nextInt();
//							if (choice == 1) {
//								System.out.println("학생이름: ");
//								scanner.nextLine();
//								studentDTO.setName(scanner.nextLine());
//								System.out.println("전공: ");
//								studentDTO.setMajor(scanner.nextLine());
//								System.out.println("국어: ");
//								studentDTO.setKor(scanner.nextInt());
//								System.out.println("영어: ");
//								studentDTO.setEng(scanner.nextInt());
//								System.out.println("수학: ");
//								studentDTO.setMath(scanner.nextInt());
//								studentController.update(studentDTO);
//							} else if (choice == 2) {
//								studentController.delete(studentDTO);
//							}
//
//						}
//					}
//				}
//			}
//		}
//		scanner.close();
//	}
//}package viewer;
//
//public class StudentViwer2 {
//
//}
