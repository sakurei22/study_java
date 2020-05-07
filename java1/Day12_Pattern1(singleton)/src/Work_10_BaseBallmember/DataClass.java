package Work_10_BaseBallmember;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class DataClass {
	private File file;

	public DataClass(String filename) {
		file = new File("d:/tmp/" + filename + ".txt");
	}

	public void createfile() {
		try {
			if (file.createNewFile()) {
				System.out.println("파일 생성 성공!");
			} else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeFile(String data[]) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

			for (int i = 0; i < data.length; i++) {
				pw.println(data[i]);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("파일에 성공적으로 기입하였습니다.");
	}

	public HashMap<String, HumanDTO> readFile() { // 파일이 존재하는지 체크
		HashMap<String, HumanDTO> map = new HashMap<String, HumanDTO>();
		try {
			if (checkBeforeReadFile(file)) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String str = "";
				HumanDTO human = null;
				
				while ((str = br.readLine()) != null) {
					String split[] = str.split("-");

					// 투수
					if (Integer.parseInt(split[0]) < 2000) {
						human = new Pitcher(Integer.parseInt(split[0]),
											split[1],
											Integer.parseInt(split[2]),
											Double.parseDouble(split[3]),
											Integer.parseInt(split[4]),
											Integer.parseInt(split[5]),
											Double.parseDouble(split[6]));
						
					} else {// 타자
						human = new Batter(Integer.parseInt(split[0]),
											split[1],
											Integer.parseInt(split[2]),
											Double.parseDouble(split[3]),
											Integer.parseInt(split[4]),
											Integer.parseInt(split[5]),
											Double.parseDouble(split[6]));
					}
					map.put(human.getName(), human);
				}
			} else {
				System.out.println("파일이 없거나 읽을 수 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// 파일이 있고 읽을 수 있는 파일인지 확인용 메소드
	public boolean checkBeforeReadFile(File f) { // 유틸리티 함수
		if (f.exists()) {
			if (f.isFile() && f.canRead()) {
				return true;
			}
		}
		return false;
	}
}
