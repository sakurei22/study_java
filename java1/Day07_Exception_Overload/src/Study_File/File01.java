package Study_File;

import java.io.File;
import java.io.IOException;

public class File01 {
	public static void main(String[] args) {
		
		/*

		 	기능부분	: file, upload
		 	logic부분	: 직접 구현. DAO, DTO, model
		 	
		 	window -> 파일	*.lib		*.dll
		 					library		dynamic link library
		 					정적			동적
		 					메모리점령		
		 					보안 탁월		보안 취약
		 					
		 					*.jar
		 	
		 	저장매체 -> 데이터 -> file, Database(file)
		 					
		 					이름		나이		주소
		 					홍길동	24		서울시	-> parsing(원하는 데이터 취합하여 산출)
		 											   parser(parsing하는 프로그램)
		 	
		 	*.txt
		 	
		 	파일(Database) 목적 :	데이터관리, 저장, 유지
		 				CRUD
		 				추가(insert), 삭제(delete), 읽기(read), 쓰기(write)
		 				검색(search, select), 수정(update)
		 					
		 */
		
		// 파일 목록
		File fdir = new File("c:\\");
		/*
		String filelist[] = fdir.list();
		for (int i = 0; i < filelist.length; i++) {
			System.out.println(filelist[i]);
		}
		*/
		
		File filelist[] = fdir.listFiles();
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isFile()) {				// 파일인이 아닌지
				System.out.println("[파일]"+filelist[i].getName());
			}else if(filelist[i].isDirectory()) {
				System.out.println("[폴더]"+filelist[i].getName());
			}else {
				System.out.println("[?]"+filelist[i].getName());
			}
		}
		
		// 파일 생성
		String fileStr = "d:\\tmp\\newfile.txt";
		File newFile = new File(fileStr);	// 파일포인터만 생성
		
		
			try {
				if(newFile.createNewFile()) {	// 실제 생성 함수
					System.out.println("파일 생성 성공");
				}else {
					System.out.println("파일 생성 실패");
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		// 폴더생성(디렉토리생성)
		String dirStr = "d:/tmp1/sub";
		File newDir = new File(dirStr);
		
		if(newDir.mkdirs()) {
			System.out.println("폴더 생성 성공");
		}else {
			System.out.println("폴더 생성 실패");
		}
		
		String filename = "newfile1"+ ".txt";
		File myfile = new File(dirStr + "/"+filename);
		
		try {
			if(myfile.createNewFile()) {
				System.out.println(filename+"생성 성공");
			}else {
				System.out.println(filename +"생성 실패");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 파일 존재 여부
		if(myfile.exists()) {
			System.out.println("파일이 존재합니다.");
		}else {
			System.out.println("파일이 없습니다.");
		}
		
		// 파일 삭제
		/*
		if(myfile.delete()) {
			System.out.println("파일을 삭제했습니다.");
		}else {
			System.out.println("파일을 삭제하지 못했습니다.");
		}
		*/
		
		//myfile.setReadOnly();
		
		// 읽기 가능 여부
		if(myfile.canRead()) {
			System.out.println("파일 읽기가 가능합니다.");
		}else {
			System.out.println("파일 읽기가 불가능합니다.");
		}
		
		if(myfile.canWrite()) {
			System.out.println("파일 쓰기가 가능합니다.");
		}else {
			System.out.println("파일 쓰기가 불가능합니다.");
		}
		
	}
}
