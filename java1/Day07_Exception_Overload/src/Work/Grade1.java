package Work;

import java.util.Scanner;

public class Grade1 {
	public static void main(String[] args) {

		/*
		 * 
		 * String Student[][]; 1.학생정보 추가(이름, 나이, 영어, 수학) 2.학생정보 삭제 3.학생정보 검색 4.학생정보 수정
		 * 5.학생성적 조회(1명) 총점 6.전체학생성적 총점 7.전체학생성적 평균 8.학생성적순출력
		 * 
		 * 어느작업을 하시겠습니까?
		 * 
		 */
//		String student[][] = new String[10][4];
		// student[][] = new String(); -> 일반객채일경우 일일히 다 잡아줘야한다
		/*
		 * for (int i = 0; i < student.length; i++) { // null 포인트 나오지 않게 for (int j = 0;
		 * j < student.length; j++) { // ""(빈칸)으로 초기화 student[i][j] = ""; // = new
		 * String(""); } }
		 */

//		insert(student);
	
//		delete(student);

//		select(student);

//		update(student);

//		studentOne_sum_avg(student);

//		studentAll_sum(student);

//		studentAll_avg(student);
		
		
		String student[][] = {
				{"홍길동","24","98","70"},
				{"성춘향","24","45","100"},
				{"","","",""},
				{"정수동","34","50","70"},
				{"일지매","22","87","92"}
		};
		student_sort(student);
	}

	static void insert(String student[][]) {
		Scanner sc = new Scanner(System.in);

		// next node == null 찾는다
		int nextNode = 0;
		for (int i = 0; i < student.length; i++) {

			if (student[i][0] == null) {
				nextNode = i;
				break;

			}
		}
		System.out.println("nextNode= " + nextNode);

		String column[] = { "name", "age", "eng", "math" };

		for (int i = 0; i < column.length; i++) {
			System.out.print(column[i] + "= ");
			student[nextNode][i] = sc.next();
		}
		for (int i = 0; i < column.length; i++) {
			System.out.println(student[nextNode][i] + " ");

		}
		System.out.println("\n 데이터가 등록 되었습니다.");

		/*
		    가독성이 더 좋은것이 좋은 코드 
		  System.out.print("name= ");
		  String name = sc.next();
		  student[nextNode][0] = name;
		 */
	}

	static void delete(String student[][]) {
		Scanner sc = new Scanner(System.in);

		// 입력
		System.out.print("삭제할 학생의 이름을 입력 = ");
		String name = sc.next();

		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if (name.equals(student[i][0])) {
				findIndex = i;
				break;
			}
		}

		// 처리
		if (findIndex == -1) {
			System.out.println("학생데이터를 찾을 수 없습니다.");
		} else {
			for (int i = 0; i < student[0].length; i++) {
				student[findIndex][i] = "";
			}
			System.out.println("학생데이터를 삭제하였습니다.");
		}
	}

	static void select(String student[][]) {
		Scanner sc = new Scanner(System.in);

		// 입력
		System.out.print("검색할 학생의 이름을 입력 = ");
		String name = sc.next();

		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if (name.equals(student[i][0])) {
				findIndex = i;
				break;
			}
		}

		if (findIndex == -1) {
			System.out.println("학생데이터를 찾을 수 없습니다.");
		} else {
			System.out.println("학생데이터를 찾았습니다.");
			System.out.println("이름: " + student[findIndex][0]);
			System.out.println("나이: " + student[findIndex][1]);
			System.out.println("영어: " + student[findIndex][2]);
			System.out.println("수학: " + student[findIndex][3]);
		}
	}

	static void update(String student[][]) {
		Scanner sc = new Scanner(System.in);

		// 입력
		System.out.print("수정할 학생의 이름을 입력 = ");
		String name = sc.next();

		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if (name.equals(student[i][0])) {
				findIndex = i;
				break;
			}
		}
		if (findIndex == -1) {
			System.out.println("학생데이터를 찾을 수 없습니다.");
		} else {
			System.out.println("학생데이터를 찾았습니다.");
			System.out.println("수정할 점수를 입력해 주십시오.");
			System.out.print("영어 = ");
			String eng = sc.next();
			System.out.print("수학 = ");
			String math = sc.next();

			student[findIndex][2] = eng;
			student[findIndex][3] = math;

			System.out.println("점수를 수정하였습니다.");
			System.out.println("영어: " + student[findIndex][2]);
			System.out.println("수학: " + student[findIndex][3]);
		}
	}

	static void studentOne_sum_avg(String student[][]) { // 가독성
		Scanner sc = new Scanner(System.in);

		// 입력
		System.out.print("총점과 평균을 구할 학생의 이름을 입력 = ");
		String name = sc.next();

		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if (name.equals(student[i][0])) {
				findIndex = i;
				break;
			}
		}
		if (findIndex == -1) {
			System.out.println("학생데이터를 찾을 수 없습니다.");
		} else {
			System.out.println("이름: " + student[findIndex][0]);
			int eng = Integer.parseInt(student[findIndex][2]);
			int math = Integer.parseInt(student[findIndex][3]);
			int sum = eng + math;

			double avg = (double) sum / 2;

			System.out.println("총점  = " + sum + "/ 평균= " + avg);
		}
	}

	static void studentAll_sum(String student[][]) {
		int sum = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i][0] != null && !student[i][0].equals("")) {
				sum = sum + Integer.parseInt(student[i][2]);
				sum = sum + Integer.parseInt(student[i][3]);
			}
		}
		System.out.println("전체학생의 총점: " + sum);
	}

	static void studentAll_avg(String student[][]) {
		// 각 학생의 합계에 대한 평균
		// 학생 몇명?
		int count = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i][0] != null && !student[i][0].equals("")) {
				count++;
			}
		}
		System.out.println("count: " + count);
		if (count == 0) {
			System.out.println("학생이 한명도 등록되어있지 않습니다.");
			return; // 밑 코드 실행 안됨. 호출된 곳으로 튕겨나감
		}

		int sum[] = new int[count];

		int j = 0;
		for (int i = 0; i < student.length; i++) { // i : 0 2 3 -> 불규칙일수 있으므로 j 선언
			if (student[i][0] != null && !student[i][0].equals("")) {
				sum[j] = sum[j] + Integer.parseInt(student[i][2]);
				sum[j] = sum[j] + Integer.parseInt(student[i][3]);
				j++;
			}
		}
		int allsum = 0;
		for (int i = 0; i < sum.length; i++) {
			allsum = allsum + sum[i];
		}
		double allAvg = (double) allsum / count;
		System.out.println("전체학생 총점들의 평균= " + allAvg);
	}

	static void student_sort(String student[][]) {
		String studentSort[][]; // 원본데이터는 건드리면 안된다!!
		int count = 0;

		for (int i = 0; i < student.length; i++) { // 원본데이터의 빈자리 빼고 복사 
			if (student[i][0] != null && !student[i][0].equals("")) {
				count++;
			}
		}
		studentSort = new String[count][4];
		int val = 0 ;
		for (int i = 0; i < student.length; i++) {
			if(student[i][0] != null && !student[i][0].equals("")) {
				studentSort[val][0] = student[i][0];
				studentSort[val][1] = student[i][1];	
				studentSort[val][2] = student[i][2];	
				studentSort[val][3] = student[i][3];
				val++;
				}
		}
		
		for (int i = 0; i < studentSort.length; i++) {
			for (int j = 0; j < studentSort[0].length; j++) {
				System.out.println(studentSort[i][j]+" ");
			}
			System.out.println();
		}
		
		// 내림 정렬
		int sum[] = new int[studentSort.length];
		for (int i = 0; i < studentSort.length; i++) {
			sum[i] = sum[i] + Integer.parseInt(studentSort[i][2]); //+영어
			sum[i] = sum[i] + Integer.parseInt(studentSort[i][3]); //+수학
		}
		
		for (int i = 0; i < sum.length; i++) {
			System.out.println("sum["+ i + "]= " + sum[i]);
			
		}
		String temp[];
		for (int i = 0; i < sum.length - 1; i++) {
			for (int j = i + 1 ; j < sum.length; j++) {
				if(sum[i] < sum[j]) {
					temp = studentSort[i];
					studentSort[i] = studentSort[j];
					studentSort[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < studentSort.length; i++) {
			for (int j = 0; j < studentSort[0].length; j++) {
				
				System.out.print(studentSort[i][j]+ " ");
			}
			System.out.println();
		}
	}
}