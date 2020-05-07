package Work_3_GradeList;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class GradeFile {
	ArrayList<String> txtList = new ArrayList<String>();
	private File myfile;
	
	
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
	
	public void file_Write(ArrayList<GradeDTO> sortlist) throws Exception {
		// 파일 쓰기
		File file = new File("d:/tmp1/grade/grade.txt"); // 덮어쓰기 이므로 조심해야함

		// 문장으로 기입하기
		if (checkBeforeWriteFile(file)) {

			FileWriter fWriter;

			fWriter = new FileWriter(file);
			// 파일포인터 설정
			BufferedWriter bw = new BufferedWriter(fWriter); // 문장으로
			PrintWriter pw = new PrintWriter(bw);

			
			for (int i = 0; i < sortlist.size(); i++) {
				System.out.println(sortlist.get(i).toString());
				pw.println(sortlist.get(i).toString());
			}
			System.out.println("txt파일에 저장 ");
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
		
		public ArrayList<String> file_Read() throws Exception {
			// file read
			// 문장 단위로 읽기
			File file = new File("d:/tmp1/grade/grade1.txt"); // 파일을 가져옴  //102, 정수동, 90, 90, 93
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
				txtList.add(str);
			}
			br.close(); // 읽기가 끝나면 반드시 닫아줘야함
			return txtList;
		}
}
