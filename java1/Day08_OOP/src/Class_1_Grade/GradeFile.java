package Class_1_Grade;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class GradeFile {

	File myfile;
	
	public void foldCreat() {
		// 폴더생성(디렉토리생성)
		String dirStr = "d:/tmp1/grade";
		File newDir = new File(dirStr);

		if (newDir.mkdirs()) {
			System.out.println("폴더 생성 성공");
		} else {
			System.out.println("폴더 생성 실패");
		}

		String filename = "grade" + ".txt";
		myfile = new File(dirStr + "/" + filename);

		try {
			if (myfile.createNewFile()) {
				System.out.println(filename + "생성 성공");
			} else {
				System.out.println(filename + "생성 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void file_Write(String[][] student) throws Exception {
		// 파일 쓰기
		File file = new File("d:/tmp1/grade/grade.txt"); // 덮어쓰기 이므로 조심해야함

		// 문장으로 기입하기
		if (checkBeforeWriteFile(file)) {

			FileWriter fWriter;

			fWriter = new FileWriter(file);
			// 파일포인터 설정
			BufferedWriter bw = new BufferedWriter(fWriter); // 문장으로
			PrintWriter pw = new PrintWriter(bw);

			pw.println("번호  이름  나이  영어  수학");
			for (int i = 0; i < student.length; i++) {
				System.out.println(student[i]);
				pw.println(i+"번 : "+student[i]);
				
			}

			pw.close();

		} else {
			System.out.println("파일이 없거나 쓰기를 할 수 없습니다.");
		}
	}
		public boolean checkBeforeWriteFile(File f) {
			if (f.exists()) { // 파일이존재?
				if (f.isFile() && f.canWrite()) { // 파일인가 폴더인가? 그리고 쓰기가 가능한가?
					return true;
				}
			}
			return false;
		}
}
