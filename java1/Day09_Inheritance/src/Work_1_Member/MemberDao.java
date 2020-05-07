package Work_1_Member;

import java.util.Scanner;

public class MemberDao { //data access object

	Scanner sc = new Scanner(System.in);
	
	private MemberDTO member[];	
	private final int MEMBER_NUM = 10;
	
	private int count;
		
	public MemberDao() {
		member = new MemberDTO[MEMBER_NUM]; // 변수만 선언.
		//임시데이터
		member[0] = new MemberDTO(1001, "홍길동", 24, "서울시");
		member[1] = new MemberDTO(1002, "일지매", 25, "광주시");
		member[2] = new MemberDTO(1003, "정수동", 22, "부산시");
		
		count = 3;
	}
	
	public void insert() { 

		while (count < 10) {
			System.out.print("회원번호:");
			int id = sc.nextInt();

			System.out.print("이름:");
			String name = sc.next();

			System.out.print("나이:");
			int age = sc.nextInt();

			System.out.print("주소:");
			String address = sc.next();

			MemberDTO dto = new MemberDTO(id, name, age, address); //
			member[count] = dto;
			
			count++;
			
			System.out.println("1.계속 추가  2.뒤로가기");
			int choice = sc.nextInt();
			if (choice == 1)
				count++;
			else
				break;
		}if(count>10)
		System.out.println("데이터 갯수를 초과하였습니다.");
	}

	public void delete() {
		int findIndex ;
		System.out.println("삭제할 이름:");
		String name = sc.next();
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("회원을 찾을 수 없습니다.");
		}else {
			member[findIndex].setName("");
			member[findIndex].setId(0);
			member[findIndex].setAge(0);
			member[findIndex].setAddress("");
			System.out.println("삭제하였습니다.");
		}
		
		
	}

	public void update() {
		int findIndex ;
		System.out.println("수정할 이름:");
		String name = sc.next();
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("회원을 찾을 수 없습니다.");
		}else {
		System.out.println("기존 주소: " + member[findIndex].getAddress());
		System.out.print("변경할 주소를 적어주세요 :");
		String address = sc.next();
		member[findIndex].setAddress(address);
		System.out.println("수정되었습니다.");
		}
	}

	public void selectOne() {
		int findIndex ;
		System.out.println("검색할 이름:");
		String name = sc.next();
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("회원을 찾을 수 없습니다.");
		}else {
		System.out.println("찾은 회원 정보는");
		System.out.println(member[findIndex].toString());
		System.out.println("입니다.");
		}
	}
	
	public void selectAll() {
		for (int i = 0; i < member.length; i++) {
			MemberDTO dto = member[i];
			if (dto != null && !dto.getName().equals("")) {
				System.out.println(dto.toString());
			}
		}
	}

	public int search(String name) {
		int indexNum = -1;
		/*
		for (int i = 0; i < member.length; i++) {
			MemberDTO dto = member[i];
			if (dto !=null && !dto.getName().equals("")) {
				indexNum = i; // 일치하는 데이터를 찾으면 인덱스번호를 가져옴
				break;
			}
		}
		if (IndexNum == -1) {
			System.out.println("데이터를 찾을 수 없습니다.");
		}
		return IndexNum;
		*/
		int i = 0;
		for (MemberDTO dto : member) {
			if (dto !=null && !dto.getName().equals("")) {
				if(name.equals(dto.getName())) {
					indexNum = i;
					break;
				}
			}
			i++;
		}
		return indexNum;
		
	}

}
