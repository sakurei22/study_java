package Work_2_MemberList;

import java.util.ArrayList;
import java.util.Scanner;



public class MemberDao { //data access object

	Scanner sc = new Scanner(System.in);
	ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
	
		
	public MemberDao() {
		MemberDTO member;
		member = new MemberDTO(1001, "홍길동", 24, "서울시");
		list.add(member);
		member = new MemberDTO(1002, "일지매", 25, "광주시");
		list.add(member);
		member = new MemberDTO(1003, "정수동", 22, "부산시");
		list.add(member);
	}
	
	public void insert() { 
	System.out.print("회원번호:");
			int id = sc.nextInt();

			System.out.print("이름:");
			String name = sc.next();

			System.out.print("나이:");
			int age = sc.nextInt();

			System.out.print("주소:");
			String address = sc.next();

			MemberDTO dto = new MemberDTO(id, name, age, address);
			list.add(dto);
			
	}		
	public void delete() {
		int findIndex ;
		System.out.println("삭제할 이름:");
		String name = sc.next();
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("회원을 찾을 수 없습니다.");
		}else {
			list.get(findIndex).setName("");
			list.get(findIndex).setId(0);
			list.get(findIndex).setAge(0);
			list.get(findIndex).setAddress("");
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
		System.out.print("변경할 주소를 적어주세요 :");
		String address = sc.next();
		list.get(findIndex).setAddress(address);
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
		System.out.println(list.get(findIndex).toString());
		System.out.println("입니다.");
		}
	}
	
	public void selectAll() {
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
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
		for (MemberDTO dto : list) {
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
