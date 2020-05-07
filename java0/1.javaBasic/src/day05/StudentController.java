package day05;

public class StudentController {
	public int calcSum(StudentDTO s) {
		return s.getKor()+s.getEng()+s.getMath();
	 
	}
	public double calcAvg(StudentDTO s) {
	 
	 return calcSum(s)/ 3.0;
	}
}

