package Study_File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class File03 {
	public static void main(String[] args) throws Exception {

		// 파일 쓰기
		File file = new File("d:/tmp/newfile.txt"); // 덮어쓰기 이므로 조심해야함

		// 한문자 쓰기
		/*
		 * FileWriter fw = new FileWriter(file); fw.write("하이하이"+"\n"); fw.close(); //
		 * 쓰기 후 반드시 닫아야함
		 */

		// 추가쓰기
		/*
		 * FileWriter fappend = new FileWriter(file, true); // 추가기입
		 * fappend.write("건강하세요"+"\n"); fappend.close();
		 */

		// 문장으로 기입하기
		if (checkBeforeWriteFile(file)) {

			FileWriter fWriter;
			
				fWriter = new FileWriter(file);
				// 파일포인터 설정
				BufferedWriter bw = new BufferedWriter(fWriter); // 문장으로
				PrintWriter pw = new PrintWriter(bw);

				pw.print("안녕하세요" + "\n");
				pw.println("하이");
				pw.println("건강하세요");

				pw.close();
			
		} else {
			System.out.println("파일이 없거나 쓰기를 할 수 없습니다.");
		}

	}

	static boolean checkBeforeWriteFile(File f) {
		if (f.exists()) { // 파일이존재?
			if (f.isFile() && f.canWrite()) { // 파일인가 폴더인가? 그리고 쓰기가 가능한가?
				return true;
			}
		}
		return false;
	}

}
