package Study_File;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class File02 {
	public static void main(String[] args) throws Exception { // 예외 처리
		// file read 
		
		File file = new File("d:/tmp/newfile.txt"); //파일을 가져옴
		
		FileReader fr;
		
			fr = new FileReader(file);
				//파일리더로 파일 읽기
		
			//한문자씩 읽기.
		/*
		int c = fr.read();
		while(c != -1) {	// -1 == 파일끝
			System.out.println((char)c);
			c = fr.read();
		}
		int c;
		while((c = fr.read()) != -1) {	// -1 == 파일끝
			System.out.println((char)c);
			c = fr.read();
		}
		 */
		
			//한문장씩 읽기.
		// Buffer == 저장공간
		BufferedReader br = new BufferedReader(fr);
		/*
		String str = br.readLine();
		while(str !=null) {
			System.out.println(str);
			str = br.readLine();
		}
		br.close(); //읽기가 끝나면 반드시 닫아줘야함
		*/
		
		String str;
		while((str = br.readLine()) !=null) {
			System.out.println(str);
		}
		
		br.close();
		
		
	}
}
