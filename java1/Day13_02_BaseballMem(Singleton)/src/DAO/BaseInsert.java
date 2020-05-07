package DAO;

import java.util.Scanner;
import DTO.Batter;
import DTO.Human;
import DTO.Pitcher;


public class BaseInsert implements DaoInterface {
	private int MemNumber;
	
	public BaseInsert() {
		MemNumber = 1000;
		
		Singleton si = Singleton.getInstance();
		if(si.map.size() > 0) {
			MemNumber = si.MemNumber;
		}
	}
	
	public void process() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(">> 선수등록");
		System.out.println("투수(1)/타자(2) 등록하고 싶은 포지션을 입력해 주십시오.");
		System.out.print(">>>>> ");
		int choice = sc.nextInt();
		
		// human
		Human human = null;
		
		System.out.print("이름:");
		String name = sc.next();
		
		System.out.print("나이:");
		int age = sc.nextInt();
		
		System.out.print("신장:");
		double height = sc.nextDouble();
		
		System.out.println("생일");
		String birth = sc.next();
		
		if(choice == 1) {			// pitcher
			System.out.print("승:");
			int win = sc.nextInt();
			
			System.out.print("패:");
			int lose = sc.nextInt();
			
			System.out.print("방어율:");
			double defence = sc.nextDouble();
			
			human = new Pitcher(MemNumber, name, age, height, 
								birth, win, lose, defence);			
		}
		else {						// batter
			System.out.print("타수:");
			int batcount = sc.nextInt();
			
			System.out.print("안타수:");
			int hit = sc.nextInt();
			
			System.out.print("타율:");
			double hitAvg = sc.nextDouble();
			
			human = new Batter(MemNumber + 1000, name, age, height, 
								birth, batcount, hit, hitAvg);
		}
		
		// map에 추가
		Singleton si = Singleton.getInstance();
		si.map.put(human.getName(), human);
		
		MemNumber++;
	}
}
	

