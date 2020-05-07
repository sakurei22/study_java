package Class_4_File;

public class mainClass {
	public static void main(String[] args) throws Exception {
		File_Creat filing = new File_Creat();
		filing.foldCreat();	//폴더+ 파일생성
		filing.file_Can(); // 편집가능확인
		filing.file_Read();
		filing.file_Write();
		
		
	}
}
