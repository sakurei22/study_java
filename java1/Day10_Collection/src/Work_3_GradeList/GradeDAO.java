package Work_3_GradeList;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeDAO {
	GradeFile gfile = new GradeFile();
	
	Scanner sc = new Scanner(System.in);
		private ArrayList<GradeDTO> list = new ArrayList<GradeDTO>();
		private ArrayList<GradeDTO> sortlist = new ArrayList<GradeDTO>(); 
		
	public GradeDAO() throws Exception {
		GradeDTO dto = new GradeDTO(100, "홍길동", 80, 90, 81);
		list.add(dto);
		GradeDTO dto1 = new GradeDTO(101, "일지매", 100, 80, 72);
		list.add(dto1);
		GradeDTO dto2;
		
		String splits[];
		ArrayList<String> txtList = gfile.file_Read();
		for (int i = 0; i < txtList.size(); i++) {
			splits = txtList.get(i).split(",");
			int id = Integer.parseInt(splits[0].substring(1, splits[0].length()));
			String name = splits[1].substring(0, splits[1].length());
			int kor = Integer.parseInt(splits[2].substring(0, splits[2].length()));
			int eng = Integer.parseInt(splits[3].substring(0, splits[3].length()));
			int math = Integer.parseInt(splits[4].substring(0, splits[4].length()));
		 dto2 = new GradeDTO(id, name, kor, eng, math);
		 list.add(dto2);
						
		}
	}
						
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
			}else if (choice == 1) { // 1. 학생정보 추가 (이름, 나이, 국어, 영어, 수학)
				insert();
				
			} else if (choice == 2) { // 2. 학생정보 삭제
				delete();

			} else if (choice == 3) { // 3. 학생정보 검색
				search();

			} else if (choice == 4) { // 4. 학생정보 수정(영어, 수학)
				update(sc);

			} else if (choice == 5) { // 5. 학생성적 조회(1명) 총점조회
				sumOne();
				
			} else if (choice == 6) { // 6. 학생성적 총점
				sumAll();

			} else if (choice == 7) { // 7. 학생성적 평균
				avg();
				
			} else if (choice == 8) { // 8. 학생성적순 출력
				sorting();
				System.out.println("1.학생정보출력 2.뒤로가기");
				int choice1 = sc.nextInt();
				if(choice1 ==1) {
					gfile.file_Write(sortlist);
				}
			}
		}
	sc.close();
	}
	

	public void sorting() {		// 원본데이터 보호 필요!
		
		
		for (int i = 0; i < list.size(); i++) { // 원본데이터의 빈자리 빼것 카운트
			if (list.get(i).getId() != 0 ) {
				sortlist.add(list.get(i));
				System.out.println(sortlist.get(i).toString());
			}
		}
		if(list.size() == 0) {
			System.out.println("입력된 데이터가 없습니다.");
		}
			
		//내림정렬
		int sum[] = new int[sortlist.size()];
		for (int i = 0; i < sortlist.size(); i++) {
			sum[i] = sortlist.get(i).getKor()
					+ sortlist.get(i).getEng()
					+ sortlist.get(i).getMath();
		
			System.out.println("총점= "+sum[i]);
		}
		
	
			GradeDTO temp2;
			int temp;
		for (int i = 0; i < sum.length; i++) {
			for (int j = i + 1; j < sum.length; j++) {
				if (sortlist.get(i).getId() == 0) {
					System.out.println("데이터가 없습니다.");
					break;
				} else if (sum[i] < sum[j]) {	
					temp2 = sortlist.get(i);
					temp = sum[i];
					sortlist.set(i, sortlist.get(j));
					sum[i] = sum[j];
					sortlist.set(j, temp2);
					sum[j] = temp;
				}
			}
		}
		for (int i = 0; i < sortlist.size(); i++) {
			System.out.println(sortlist.get(i).toString());
		}
	}
	public void avg() {
		int total = sumAll();
		double avg = 0;
		
		if (list.size() == 0) {
			System.out.println("나눌 데이터가 없습니다.");
		} else {
			avg = total / (double)list.size() ;
		}
		System.out.println("전체학생의 평균은" + avg + "점 입니다.");
	}

	public int sumAll() {
		int total = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() != 0) {
				
			total = total + list.get(i).getKor() + list.get(i).getEng() + list.get(i).getMath();
			}
		}
			
		System.out.println("전체학생의 총점은" + total + "점 입니다.");
		return total;

	}

	public void sumOne() {
		int sum = 0;
		int i = inputName(sc);
		
		if (i != -1) {
			sum = list.get(i).getKor() + list.get(i).getEng() + list.get(i).getMath();
		} else if (list.get(i).getId() == 0) {
			System.out.println("검색할 데이터가 없습니다.");
		}
		System.out.println("선택하신 학생의 총점은 " + sum + "점 입니다");
	}

	public void update(Scanner sc) {
		int i = inputName(sc);
		
		if (i != -1) {
			System.out.println("국어점수: ");
			int kor = sc.nextInt();
			System.out.println("영어점수: ");
			int eng = sc.nextInt();
			System.out.println("수학점수: ");
			int math = sc.nextInt();

			list.get(i).setKor(kor);
			list.get(i).setEng(eng);
			list.get(i).setMath(math);
			
			
		} else {
			System.out.println("데이터가 없습니다.");
		}
	}

	public void search() {
		int findIndex = inputName(sc);
		int i = findIndex;
		if (i != -1) {
			System.out.println(list.get(i).toString());
		} else {
			System.out.println("검색할 데이터가 없습니다.");
		}
	}

	public void delete() {
		int i = inputName(sc);
		
		list.get(i).setId(0);
		list.get(i).setName("");
		list.get(i).setKor(0);
		list.get(i).setEng(0);
		list.get(i).setMath(0);
		System.out.println("삭제되었습니다.");

	}

	public void insert() {
	
		System.out.print("id: ");
		int id = sc.nextInt();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("국어: ");
		int kor = sc.nextInt();
		System.out.print("영어: ");
		int eng = sc.nextInt();
		System.out.print("수학: ");
		int math = sc.nextInt();

		GradeDTO g = new GradeDTO();
		g.setId(id);
		g.setName(name);
		g.setKor(kor);
		g.setEng(eng);
		g.setMath(math);
		
		list.add(g);
	}

	public int inputName(Scanner sc) {
		System.out.println("이름을 입력하세요.");
		String selectName = sc.next();
		int findIndex = -1;
		for (int i = 0; i <list.size(); i++) {
			if (selectName.equals(list.get(i).getName())) {
				findIndex = i; // 일치하는 데이터를 찾으면 인덱스번호를 가져옴
				break;
			}
		}
		if (findIndex == -1) {
			System.out.println("데이터를 찾을 수 없습니다");
		}
		return findIndex;
	}
}
