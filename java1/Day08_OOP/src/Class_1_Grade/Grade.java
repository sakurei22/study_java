package Class_1_Grade;

import java.util.Scanner;


public class Grade {
		GradeFile gFile = new GradeFile();		//다른 클래스의 메소드를 이용할땐 생성자를 이용
		Scanner sc = new Scanner(System.in);
		private int findIndex;
		String student[][] = new String[5][4];
						
	public void roop() throws Exception {
		while (true) {
			System.out.println("===============================");
			System.out.println("어느작업을 하시겠습니까?");
			System.out.println("학생정보 1.추가 2.삭제 3.검색 4.삭제");
			System.out.println("학생성적 5.조회 6.총점 7.평균 8.성적순 출력");
			System.out.println("      9.종료");
			System.out.print(">");
			int choice = sc.nextInt();
			if (choice == 9) {
				System.out.println("이용해 주셔서 감사합니다.");
				break;
			}else if (choice == 1) { // 1. 학생정보 추가 (이름, 나이, 영어, 수학)
				insert(student, sc);
				//파일 쓰기메소드
				gFile.file_Write(student);
			} else if (choice == 2) { // 2. 학생정보 삭제
				findIndex = inputname(student, sc);
				delete(student, sc, findIndex);

			} else if (choice == 3) { // 3. 학생정보 검색
				findIndex = inputname(student, sc);
				search(student, sc, findIndex);

			} else if (choice == 4) { // 4. 학생정보 수정(영어, 수학)
				findIndex = inputname(student, sc);
				update(student, sc, findIndex);

			} else if (choice == 5) { // 5. 학생성적 조회(1명) 총점조회
				findIndex = inputname(student, sc);
				sumOne(student, sc, findIndex);

			} else if (choice == 6) { // 6. 학생성적 총점
				sumAll(student);

			} else if (choice == 7) { // 7. 학생성적 평균
				avg(student);

			} else if (choice == 8) { // 8. 학생성적순 출력
				sorting(student);

			}
		}
	sc.close();
	}
	

	public void sorting(String[][] student) {		// 원본데이터 보호 필요!
		String studentSort[][];
		int count = 0;
		for (int i = 0; i < student.length; i++) { // 원본데이터의 빈자리 빼것 카운트
			if (student[i][0] != null && !student[i][0].equals("")) {
				count++;
			}
		}
		if(count == 0) {
			System.out.println("입력된 데이터가 없습니다.");
		}
		studentSort = new String[count][4]; // count열의 새로운 2차 배열 생성
		
		int val = 0;
		for (int i = 0; i < student.length; i++) {	// 원본데이터에서 복사
			if(student[i][0] != null && !student[i][0].equals("")) {
				studentSort[val][0] = student[i][0];
				studentSort[val][1] = student[i][1];	
				studentSort[val][2] = student[i][2];	
				studentSort[val][3] = student[i][3];
				val++;
				}
		}
			
		//내림정렬
		int sum[] = new int[studentSort.length];
		for (int i = 0; i < studentSort.length; i++) {
			sum[i] = sum[i] + Integer.parseInt(studentSort[i][2]);
			sum[i] = sum[i ]+ Integer.parseInt(studentSort[i][3]);
		}
			
		String temp2[];				// 자리바꿔줄 배열생성
		for (int i = 0; i < sum.length - 1; i++) {
			for (int j = i + 1; j < sum.length; j++) {
				if (studentSort[i][j] == null) {
					break;
				} else if (sum[i] < sum[j]) { 
					temp2 = studentSort[i];	// 2차원배열중  i열의 배열을 몽땅 가져와서 temp2에 대입
					studentSort[i] = studentSort[j];
					studentSort[j] = temp2;
				}
			}
		}
		for (int i = 0; i < studentSort.length; i++) {
			for (int j = 0; j < studentSort[0].length; j++) {
				System.out.print(studentSort[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void avg(String[][] student) {
		int total = sumAll(student);
		int count = 0;
		double avg = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i][0] != null) {
				count++;
			}
		}
		if (count == 0) {
			System.out.println("나눌 데이터가 없습니다.");
		} else {
			avg = total / (double) count;
		}
		System.out.println("전체학생의 평균은" + avg + "점 입니다.");

	}

	public int sumAll(String[][] student) {
		int total = 0;
		for (int i = 0; i < student.length; i++) {
			for (int j = 2; j < student[0].length; j++) {
				if (student[i][j] == null) {
					break;
				} else {
					total = total + Integer.parseInt(student[i][j]);
				}
			}
		}
		System.out.println("전체학생의 총점은" + total + "점 입니다.");
		return total;

	}

	public void sumOne(String[][] student, Scanner sc, int findIndex) {
		int sum = 0;
		int i = findIndex;
		if (i != -1) {
			sum = Integer.parseInt(student[i][2]) + Integer.parseInt(student[i][3]);
		} else if (student[i][0] == null) {
			System.out.println("검색할 데이터가 없습니다.");
		}
		System.out.println("선택하신 학생의 총점은 " + sum + "점 입니다");
	}

	public void update(String[][] student, Scanner sc, int findIndex) {
		int i = findIndex;
		if (i != -1) {
			System.out.println("영어점수: ");
			String eng = sc.next();
			System.out.println("수학점수: ");
			String math = sc.next();

			student[i][2] = eng;
			student[i][3] = math;
		} else {
			System.out.println("데이터가 없습니다.");
		}
	}

	public void search(String[][] student, Scanner sc, int findIndex) {
		int i = findIndex;
		if (i != -1) {
			System.out.println("선택한 학생의 이름: " + student[i][0]);
			System.out.println("선택한 학생의 나이: " + student[i][1]);
			System.out.println("선택한 학생의 영어점수: " + student[i][2]);
			System.out.println("선택한 학생의 수학점수: " + student[i][3]);

		} else {
			System.out.println("검색할 데이터가 없습니다.");
		}
	}

	public void delete(String[][] student, Scanner sc, int findIndex) {
		int i = findIndex;
		student[i][0] = null;
		student[i][1] = null;
		student[i][2] = null;
		student[i][3] = null;
		System.out.println("삭제되었습니다.");

	}

	public void insert(String[][] student, Scanner sc) {

		int select;
		while (true) {
			System.out.println("추가하실 학생번호를 선택하세요(1~5) 6.뒤로가기");
			select = sc.nextInt() - 1;
			if (select>6) {
				System.out.println("범위를벗어났습니다. 다시입력해주세요");
				break;
			} else if (select == 5) {
				break;
			} else if (student[select][1] != null) {
					System.out.println("학생이 이미 존재합니다. 다른번호를 선택해주세요");
			} else {
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("나이: ");
		String age = sc.next();
		System.out.print("영어: ");
		String eng = sc.next();
		System.out.print("수학: ");
		String math = sc.next();

		student[select][0] = name;
		student[select][1] = age;
		student[select][2] = eng;
		student[select][3] = math;
			}
		}
		out: for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[0].length; j++) {
				if (student[i][j] == null) {
					break out;
				} else {
					System.out.print(student[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public int inputname(String[][] student, Scanner sc) {
		System.out.println("이름을 입력하세요.");
		String selectName = sc.next();
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if (selectName.equals(student[i][0])) {
				findIndex = i; // 일치하는 데이터를 찾으면 인덱스번호를 가져옴
				break;
			}
		}
		if (findIndex == -1) {
			System.out.println("삭제할 데이터를 찾을 수 없습니다");
		}
		return findIndex;
	}
}
