package day05; 
//Collections

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ex02 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
				Random random = new Random();
		while(list.size() < 6) {
			Integer randomNumber = random.nextInt(45)+1 ;
			if(!list.contains(randomNumber)) {
				list.add(randomNumber);
			}
		}
		for(int i : list) {
			System.out.println(i);
		}
		//자바에 있는 소트를 쓰자!!
		Collections.sort(list); 
// 만일 내림차순 : Colletcions.reverse(list); 추가해주면된다.		

		System.out.println("=======정렬 후========");
		for(int i : list) {
			System.out.println(i);
		}
	}
}
