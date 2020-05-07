package Work_1_ArrayList;

import java.util.ArrayList;

public class mainClass {
	public static void main(String[] args) {
		ArrayList<MemberDTO> memlist = new ArrayList<MemberDTO>();
		
		
		//추가
		//뒤
		MemberDTO dto = new MemberDTO(101, "홍길동");
		memlist.add(dto);
		
		memlist.add(new MemberDTO(102,"일지매"));
		memlist.add(new MemberDTO(1011,"김영숙"));
		memlist.add(new MemberDTO(1022,"김영숙"));
		
		dto = new MemberDTO();
		dto.setNumber(103);
		dto.setName("정수동");
		memlist.add(dto);
		
		//원하는곳
		dto = new MemberDTO(1021, "성춘향");
		memlist.add(2, dto);
		
		//삭제
		memlist.remove(1);
		for (int i = 0; i < memlist.size(); i++) {
			MemberDTO d = memlist.get(i);
			System.out.println(d.toString());
		}
		
		//검색
		String findname = "정수동";
		int indexNumber = -1;
		for (int i = 0; i < memlist.size(); i++) {
			MemberDTO mem = memlist.get(i);
			if(mem.getName().equals(findname)) {
				indexNumber = i;
				break;
			}
		}
		System.out.println("찾은 데이터: "+memlist.get(indexNumber).toString());

		//다수의 데이터
			//배열이용시.	//갯수를 카운트(for)	//배열 동적할당	//찾아서 배열에 추가(for)
		ArrayList<MemberDTO> findDataList = new ArrayList<MemberDTO>();
		for (int i = 0; i < memlist.size(); i++) {
			MemberDTO d = memlist.get(i);
			if(d.getName().equals("김영숙")) {
				findDataList.add(d);
			}
		}
		for (int i = 0; i < findDataList.size(); i++) {
			MemberDTO d= findDataList.get(i);
			System.out.println("찾은데이터: "+d.toString());
		}
		
		//수정
		MemberDTO updateDTO = new MemberDTO(2022, "향단이");
		memlist.set(2, updateDTO);
		for (int i = 0; i < memlist.size(); i++) {
			MemberDTO d = memlist.get(i);
			System.out.println(d.toString());
		}
	}
}
