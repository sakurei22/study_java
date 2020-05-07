package main;

import java.util.Scanner;

import DAO.BaseAllprint;
import DAO.BaseDelete;
import DAO.BaseInsert;
import DAO.BaseSorting;
import DAO.BaseUpdate;
import DAO.DaoInterface;
import file.DataFile;

public class mainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DataFile dataCls = new DataFile("baseball2");
		dataCls.readFile();

		while (true) {
			
			DaoInterface dao = null;
			int choice = 0;
			System.out.println("1.선수 추가 2.모두출력 3.정렬 4.수정 5.삭제 6.파일저장");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					dao = new BaseInsert();
					break;
				case 2:
					dao = new BaseAllprint();
					break;
				case 3:
					dao = new BaseSorting();
					break;
				case 4:
					dao = new BaseUpdate();
					break;
				case 5:
					dao = new BaseDelete();
					break;
				case 6:
					dataCls.writeFile();
					break;
			}
			if(dao != null) {
				dao.process();
			}
		}
	}
}