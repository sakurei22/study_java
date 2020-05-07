package DAO;

import java.util.Scanner;
import DTO.Batter;
import DTO.Human;
import DTO.Pitcher;

public class BaseUpdate implements DaoInterface{
		
	public BaseUpdate() {
	}
		
	public void process() {
		Scanner sc = new Scanner(System.in);
		Singleton si = Singleton.getInstance();
		System.out.println("수정하고 싶은 선수명을 입력해 주십시오.");
		System.out.print(">> ");
		String name = sc.next();
		
		Human h = null;
		h = si.map.get(name);
		
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
		System.out.println("수정할 데이터를 입력해 주십시오.");
		if(h.getNumber() < 2000) {	// 투수
			Pitcher p = (Pitcher)h;
			System.out.print("승:");
			int win = sc.nextInt();
			
			System.out.print("패:");
			int lose = sc.nextInt();
			
			System.out.print("방어율:");
			double defence = sc.nextDouble();
			
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);			
			
		}else {						// 타자
			Batter b = (Batter)h;
			
			System.out.print("타수:");
			int batcount = sc.nextInt();
			
			System.out.print("안타:");
			int hit = sc.nextInt();
			
			System.out.print("타율:");
			double hitAvg = sc.nextDouble();
			
			b.setBatcount(batcount);
			b.setHit(hit);
			b.setHitAvg(hitAvg);			
		}		
		System.out.println("데이터를 수정하였습니다");
	}
}
