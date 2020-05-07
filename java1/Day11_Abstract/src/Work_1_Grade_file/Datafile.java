package Work_1_Grade_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Datafile {

	private String filename;
	private File file;
	
	public Datafile(String filename) {
		this.filename = filename;
		file = new File("d:\\tmp\\" + filename + ".txt");
		
		createfile();
	}
	
	public void createfile() {
		try {
			if(file.createNewFile()) {		
				System.out.println("파일 생성 성공!");
			}else{			
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {			 
			e.printStackTrace();
		}
	}
	
	public void writefile(String[] datas) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			pw.close();			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] readfile() {
		
		String arrStr[] = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// 데이터 갯수를 카운터
			String str;
			int count = 0;
			while((str = br.readLine()) != null) {					
				count++;
			} 
			br.close();
			
			arrStr = new String[count];
			
			br = new BufferedReader(new FileReader(file));
			// 데이터를 읽고 기입
			int w = 0;
			while((str = br.readLine()) != null) {		
				arrStr[w] = str;
				w++;
			}			
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return arrStr;
	}
	
}



