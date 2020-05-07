package DAO;

import java.util.Scanner;

import DTO.Human;

public class BaseSelect implements DaoInterface{
	
	public BaseSelect() {
	
	}
	
	public void process() {
		Scanner sc = new Scanner(System.in);
		Singleton si = Singleton.getInstance();
		System.out.println("검색하고 싶은 선수명을 입력해 주십시오.");
		System.out.print(">> ");
		String name = sc.next();
		
		Human h = null;
		h = si.map.get(name);
		
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
		System.out.println("검색된 선수입니다.");
		h.infomation();
	}
}


