package DAO;

import java.util.Scanner;

import DTO.Human;

public class BaseDelete implements DaoInterface{
	// 텍스트필드. 입력버튼.
	// 검색한 선수 삭제.
	public BaseDelete() {
	}
	public void process() {
		Scanner sc = new Scanner(System.in);
		Singleton si = Singleton.getInstance();
		System.out.println("방출하고 싶은 선수명을 입력해 주십시오.");
		System.out.print(">> ");
		String name = sc.next();
		
		Human h = null;
		h = si.map.get(name);
			
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
			
		h = si.map.remove(name);
		System.out.println(h.getName() + "선수의 데이터가 삭제되었습니다");
	}
}