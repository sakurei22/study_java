package controller;

import java.util.ArrayList;
import dto.StudentDTO;

public class StudentController {
	//selectAll(), select(id), insert(StudentDTO)
	//update(StudentDTO), delete(StudentDTO)  
	//art + shift + r : 변수이름 한번에 바꾸기
	
	ArrayList<StudentDTO> list;

	public StudentController() {
		list = new ArrayList<StudentDTO>();
		StudentDTO s = new StudentDTO();
		s.setId(0);
		s.setName("신종하");
		s.setMajor("economic");
		s.setKor(90);
		s.setEng(70);
		s.setMath(100);

		StudentDTO s1 = new StudentDTO();
		s1.setId(1);
		s1.setName("정우철");
		s1.setMajor("bb");
		s1.setKor(80);
		s1.setEng(90);
		s1.setMath(80);

		StudentDTO s2 = new StudentDTO();
		s2.setId(2);
		s2.setName("박수진");
		s2.setMajor("cc");
		s2.setKor(100);
		s2.setEng(70);
		s2.setMath(90);

		list.add(s);
		list.add(s1);
		list.add(s2);
	}

	public ArrayList<StudentDTO> selectAll() {
		return list;
	}

	public StudentDTO select(int index) {
		return list.get(index);
	}

	public void insert(StudentDTO s) {
		int lastId = list.get(list.size() - 1).getId() + 1;
		s.setId(lastId);
		list.add(s);
	}

	public void update(StudentDTO s) {
		list.set(list.indexOf(s), s);
		
//		int index = list.indexOf(s);
//		list.remove(index);
//		list.add(index, s);
	}

	public void delete(StudentDTO s) {
		list.remove(s);
	}
}
