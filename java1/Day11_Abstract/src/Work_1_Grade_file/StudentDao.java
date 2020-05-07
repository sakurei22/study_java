package Work_1_Grade_file;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class StudentDao {
	Scanner sc = new Scanner(System.in);
	
	List<StudentDto> list;
	Datafile df;
	
	public StudentDao() {
		list = new ArrayList<StudentDto>();		
		df = new Datafile("student");
		
		loadData();
		
		/*
		list.add(new StudentDto("홍길동", 24, 90, 85));
		list.add(new StudentDto("일지매", 22, 85, 100));
		list.add(new StudentDto("정수동", 25, 95, 100));
		*/
	}
	
	public void insert() {		
		StudentDto dto = new StudentDto();
		
		System.out.print("이름:");
		dto.setName(sc.next());
		
		System.out.print("나이:");
		dto.setAge(sc.nextInt());
		
		System.out.print("영어:");
		dto.setEng(sc.nextInt());
		
		System.out.print("수학:");
		dto.setMath(sc.nextInt());	
		
		list.add(dto);
	}
	
	public void delete() {
		System.out.print("이름:");
		String name = sc.next();
		
		int findnum = search(name);
		if(findnum == -1) {
			System.out.println("데이터를 찾을 수 없습니다");
		}else {
			list.remove(findnum);
			System.out.println("데이터를 삭제하였습니다");
		}
	}
	
	public void select() {
		System.out.print("이름:");
		String name = sc.next();
		
		int findnum = search(name);
		if(findnum == -1) {
			System.out.println("데이터를 찾을 수 없습니다");
		}else {
			StudentDto dto = list.get(findnum);
			System.out.println("데이터:" + dto.toString());
		}
	}
	
	public void update() {
		System.out.print("이름:");
		String name = sc.next();
		
		int findnum = search(name);
		if(findnum == -1) {
			System.out.println("데이터를 찾을 수 없습니다");
		}else {
			System.out.print("영어:");
			list.get(findnum).setEng(sc.nextInt());
			
			System.out.print("수학:");
			list.get(findnum).setMath(sc.nextInt());
			
			System.out.println("데이터를 수정했습니다");
		}
	}
	
	public int search(String name) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if(name.equals(list.get(i).getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void selectOne() {
		System.out.print("이름:");
		String name = sc.next();
		
		int findnum = search(name);
		if(findnum == -1) {
			System.out.println("데이터를 찾을 수 없습니다");
		}else {
			int english = list.get(findnum).getEng();
			int math = list.get(findnum).getMath();
			int sum = english + math;
			double avg = sum / 2;
			System.out.println("학생:" + list.get(findnum).toString());
			System.out.println("총점:" + sum);
			System.out.println("평균:" + avg);
		}
	}
	
	public void allGrade() {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);
			sum += dto.getSum();			
		}
		System.out.println("학생들의 총점:" + sum);		
	}
	
	public void allAvg() {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);
			sum += dto.getSum();			
		}
		double avg = sum / list.size();
		System.out.println("학생들의 평균:" + avg);
	}
	
	public void gradeSort() {
		List<StudentDto> sortlist = new ArrayList<StudentDto>( list );
		for (int i = 0; i < sortlist.size() - 1; i++) {
			for (int j = i + 1; j < sortlist.size(); j++) {			
				if(sortlist.get(i).getSum() < sortlist.get(j).getSum()) {
					StudentDto dto = sortlist.get(i);
					sortlist.set(i, sortlist.get(j));
					sortlist.set(j, dto);
				}
			}			
		}
		
		for (int i = 0; i < sortlist.size(); i++) {
			System.out.println(sortlist.get(i).toString());
		}
		
	}
	
	public void allStudents() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	
	public void saveData() {		
		/*
		 이름-나이-영어-수학		  
		 */
		String[] datas = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);
			datas[i] = dto.getName() + "-" + dto.getAge() 
					+ "-" + dto.getEng() + "-" + dto.getMath();
		}
		df.writefile(datas);
	}
	
	public void loadData() {
		
		String datas[] = df.readfile();
		
		for (int i = 0; i < datas.length; i++) {
			String split[] = datas[i].split("-");
			StudentDto dto = new StudentDto(
										split[0], 
										Integer.parseInt(split[1]), 
										Integer.parseInt(split[2]), 
										Integer.parseInt(split[3]) );
			list.add(dto);
		}
	}
	
}






