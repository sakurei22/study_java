package day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//map안에 map안에 어레이리스트
public class StudentEx {
	public static void main(String[] args) {

		// 모든학년을 담당할 hashMap
		// 안에 모든 반을 담당하는 hashMap안에
		// 각반의 학생을 담고있는 ArrayList
		HashMap<Integer, HashMap<Integer, ArrayList<StudentDTO>>> schoolMap = new HashMap<Integer, HashMap<Integer, ArrayList<StudentDTO>>>();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("=====비트고등학교 학생관리 프로그램=====");
			System.out.println("1.입력 2.출력 3.종료");
			int choice = scanner.nextInt();
			if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;

			}else if(choice == 1) {
				// 각 반을 담당할 hashMap
				HashMap<Integer, ArrayList<StudentDTO>> yearMap = new HashMap<Integer, ArrayList<StudentDTO>>();
				StudentDTO s = new StudentDTO();
				System.out.println("학년: ");
				s.setYear(scanner.nextInt());
				System.out.println("반: ");
				s.setRoom(scanner.nextInt());
				System.out.println("번호: ");
				s.setNumber(scanner.nextInt());
				System.out.println(("이름: "));
				scanner.nextLine(); // scanner 버그 방지
				s.setName(scanner.nextLine());
				System.out.println("국어점수: ");
				s.setKor(scanner.nextInt());
				System.out.println("영어점수: ");
				s.setEng(scanner.nextInt());
				System.out.println("수학점수: ");
				s.setMath(scanner.nextInt());

				// 람다식 메소드. schoolMap에 입력한 학년키를 가져오고 -> 밸류값:동일한 반이 없으면 새로 반을 담당하는 hashMap 생성
				// ->반키를 가져오고 ->밸류값:동일한 반이 없으면 학생명단을 생성하여 명단에 s를 추가한다.
				schoolMap.computeIfAbsent(s.getYear(), k -> new HashMap<Integer, ArrayList<StudentDTO>>())
				        .computeIfAbsent(s.getRoom(), j -> new ArrayList<StudentDTO>()).add(s);

				// 3가지 경우가 생긴다.
				// 1. 학년, 반 모두 있을 때 -> 곧장 해당 ArrayList에 s 를 추가한다.
				// 2. 학년은 있고 반을 없을 때 -> 반을 답당할 ArrayList를 만들고 그 새로 만들어진 ArrayList에 s를 추가한다.
				// 3. 학년, 반 모두 없을 때 -> 학년을 담당할 HashMap을 만들고 그안에 반을 담당할 ArrayList를 만들고 s를 추가한다.
			}else if(choice == 2) {
				if (schoolMap.size() == 0) {
					System.out.println("입력된 학생이 없습니다.");
				}else {
					System.out.println("학년: ");
					int year = scanner.nextInt();
					while (!schoolMap.containsKey(year)) {
						System.out.println("해당학년기록이 없습니다.");
						System.out.println("학년: ");
						year = scanner.nextInt();
					}
					System.out.println("반: ");
					int room = scanner.nextInt();
					while (!schoolMap.containsKey(room)) {
						System.out.println("해당 반 기록이 없습니다.");
						System.out.println("반: ");
						room = scanner.nextInt();
					}
					for (StudentDTO s : schoolMap.get(year).get(room)) {
						System.out.println(s);
					}
				}
			}
		}
		for (int i : schoolMap.keySet()) {
			for (int j : schoolMap.get(i).keySet()) {
				for (StudentDTO s : schoolMap.get(i).get(j)) {
					System.out.println(s);
				}
			}
		}
		scanner.close();
	}
}
