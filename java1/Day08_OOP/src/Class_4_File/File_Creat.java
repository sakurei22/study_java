package Class_4_File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
 
public class File_Creat {
	File myfile;
	
	public void fileList() {
	// 파일 목록
		File fdir = new File("c:\\");
		File filelist[] = fdir.listFiles();
		for (int i = 0; i < filelist.length; i++) {
			if (filelist[i].isFile()) { // 파일인이 아닌지
				System.out.println("[파일]" + filelist[i].getName());
			} else if (filelist[i].isDirectory()) {
				System.out.println("[폴더]" + filelist[i].getName());
			} else {
				System.out.println("[?]" + filelist[i].getName());
			}
		}
	}

	public void fileCreat() {
		// 파일 생성
		String fileStr = "d:\\tmp\\newfile.txt";
		File newFile = new File(fileStr); // 파일포인터만 생성

		try {
			if (newFile.createNewFile()) { // 실제 생성 함수
				System.out.println("파일 생성 성공");
			} else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void foldCreat() {
		// 폴더생성(디렉토리생성)
		String dirStr = "d:/tmp1/sub";
		File newDir = new File(dirStr);

		if (newDir.mkdirs()) {
			System.out.println("폴더 생성 성공");
		} else {
			System.out.println("폴더 생성 실패");
		}

		String filename = "newfile1" + ".txt";
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

	public void fileExists() {

		// 파일 존재 여부
		if (myfile.exists()) {
			System.out.println("파일이 존재합니다.");
		} else {
			System.out.println("파일이 없습니다.");
		}
	}

	public void fileDelete() {
		// 파일 삭제

		if (myfile.delete()) {
			System.out.println("파일을 삭제했습니다.");
		} else {
			System.out.println("파일을 삭제하지 못했습니다.");
		}
	}

	// myfile.setReadOnly();
	public void file_Can() {
		// 읽기 가능 여부
		if (myfile.canRead()) {
			System.out.println("파일 읽기가 가능합니다.");
		} else {
			System.out.println("파일 읽기가 불가능합니다.");
		}

		if (myfile.canWrite()) {
			System.out.println("파일 쓰기가 가능합니다.");
		} else {
			System.out.println("파일 쓰기가 불가능합니다.");
		}
	}

	public void file_Read() throws Exception {
		// file read
		// 문장 단위로 읽기
		File file = new File("d:/tmp/newfile.txt"); // 파일을 가져옴

		FileReader fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);

		String str;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close(); // 읽기가 끝나면 반드시 닫아줘야함
	}

	public void file_Write() throws Exception {
		// 파일 쓰기
		File file = new File("d:/tmp/newfile.txt"); // 덮어쓰기 이므로 조심해야함

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

	public boolean checkBeforeWriteFile(File f) {
		if (f.exists()) { // 파일이존재?
			if (f.isFile() && f.canWrite()) { // 파일인가 폴더인가? 그리고 쓰기가 가능한가?
				return true;
			}
		}
		return false;
	}
}
