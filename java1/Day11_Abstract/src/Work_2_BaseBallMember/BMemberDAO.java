package Work_2_BaseBallMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import Work_1_Grade_file.Datafile;
import Work_1_Grade_file.StudentDto;

public class BMemberDAO {
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Human> ballMap = new HashMap<>();
	List<Human> list;
	Datafile df;

	public BMemberDAO() {
		list = new ArrayList<Human>();
		df = new Datafile("Baseball");

		loadData();
	}

	// 추가
	public void insert() {
		while (true) {
			int number;
			int number1;
			System.out.println("1.피처등록  2.배터등록 3. 목록");
			int choice = sc.nextInt();
			int key = list.size();

			switch (choice) {
			case 1:
				if (list.get(list.size() - 1).getNumber() < 2000) {
					number = list.get(list.size() - 1).getNumber();
				}
				// inputPitcher(number, key);
				break;
			case 2:

				number1 = list.get(list.size() - 1).getNumber() + 1000;
				inputBatter(number1, key);
				break;

			case 3:
				break;
			}
		}
	}

	// 모두출력
	public void allMember() {
		Iterator<Integer> mkey = ballMap.keySet().iterator();
		while (mkey.hasNext()) {
			Integer key = mkey.next();
			Human allMem = ballMap.get(key);
			System.out.println("key: " + key + " / " + allMem.toString());
		}
	}

	// 검색
	public int search() {
		// 선수넘버가 1000 이면 키 1가져오려고함

		int findkey = -1;
		int _number = sc.nextInt();// 선수넘버
		Iterator<Integer> mkey = ballMap.keySet().iterator();
		while (mkey.hasNext()) {
			int key = mkey.next();
			if (ballMap.get(key).getNumber() == _number) {
				findkey = key;
				break;
			}
		}
		return findkey;
	}

	// 삭제
	public void delete() {
		System.out.println("삭제할 선수번호 입력: ");
		int findkey = search();
		Human delh = ballMap.remove(findkey);
		System.out.println(delh + " 값이 삭제되었습니다.");
	}

	public void update() {
		System.out.println("수정할 선수번호 검색:");
		int findkey = search();
		Human h = ballMap.get(findkey);
		if (h instanceof Pitcher) {
			Pitcher p = (Pitcher) h;
			System.out.println("승리:");
			p.setWin(sc.nextInt());
			System.out.println("패배:");
			p.setLose(sc.nextInt());
			System.out.println("방어율:");
			p.setDefence(sc.nextDouble());

		} else {
			Batter b = (Batter) h;
			System.out.println("타석:");
			b.setBat(sc.nextInt());
			System.out.println("안타:");
			b.setHit(sc.nextInt());
			System.out.println("타율:");
			b.setBatAvg(sc.nextDouble());

		}
	}

	public void inputPitcher(int number, int key) {
		Human h = new Pitcher();
		Pitcher p = (Pitcher) h;
		System.out.println("정보를 입력해주세요: ");
		System.out.print("이름: ");
		p.setName(sc.next());
		System.out.print("나이: ");
		p.setAge(sc.nextInt());
		System.out.print("키: ");
		p.setHeight(sc.nextInt());
		System.out.println("승리:");
		p.setWin(sc.nextInt());
		System.out.println("패배:");
		p.setLose(sc.nextInt());
		System.out.println("방어율:");
		p.setDefence(sc.nextDouble());
		ballMap.put(key, p);
		number++;
		key++;
	}

	public void inputBatter(int number1, int key) {
		Human h = new Batter();
		Batter b = (Batter) h;
		System.out.println("정보를 입력해주세요: ");
		System.out.print("이름: ");
		b.setName(sc.next());
		System.out.print("나이: ");
		b.setAge(sc.nextInt());
		System.out.print("키: ");
		b.setHeight(sc.nextInt());
		System.out.println("타석:");
		b.setBat(sc.nextInt());
		System.out.println("안타:");
		b.setHit(sc.nextInt());
		System.out.println("타율:");
		b.setBatAvg(sc.nextDouble());
		ballMap.put(key, b);
		number1++;
		key++;
	}

	public void sorting() {
		System.out.println("1.투수정렬 2.타자정렬");
		int choice = sc.nextInt();

		TreeMap<Double, Human> treeMap = new TreeMap<Double, Human>();

		if (choice == 1) {
			Iterator<Integer> itkey = ballMap.keySet().iterator();
			while (itkey.hasNext()) {
				Integer key = itkey.next();
				Human h = ballMap.get(key);
				if (h instanceof Pitcher) {
					Pitcher p = (Pitcher) h;
					double d = p.getDefence();
					treeMap.put(d, h);
				}
			}
			Iterator<Double> itkey1 = treeMap.keySet().iterator(); // 올림차순
			while (itkey1.hasNext()) {
				Double dkey = itkey1.next();
				System.out.println("방어율: " + dkey + " / value: " + treeMap.get(dkey));
			}
		} else {
			Iterator<Integer> itkey = ballMap.keySet().iterator();
			while (itkey.hasNext()) {
				Integer key = itkey.next();
				Human h = ballMap.get(key);
				if (h instanceof Batter) {
					Batter b = (Batter) h;
					double d = b.getBatAvg();
					treeMap.put(d, h);
				}
			}
			Iterator<Double> itkey1 = treeMap.descendingKeySet().iterator(); // 내림차순
			while (itkey1.hasNext()) {
				Double dkey = itkey1.next();
				System.out.println("타율: " + dkey + " / value: " + treeMap.get(dkey));
			}
		}
	}

	public void saveData() {
		/*
		 * 피쳐 : 1000, "신종하", 30, 175, 30, 3, 2.0
		 */
		String[] datas = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Human dto = list.get(i);
			if (dto instanceof Pitcher) {
				Pitcher p = (Pitcher) dto;
				datas[i] = p.getNumber() + "-" + p.getName() + "-" + p.getAge() + "-" + p.getHeight() + "-" + p.getWin()
						+ "-" + p.getLose() + "-" + p.getDefence();
			} else {
				Batter b = (Batter) dto;
				datas[i] = b.getNumber() + "-" + b.getName() + "-" + b.getAge() + "-" + b.getHeight() + "-" + b.getBat()
						+ "-" + b.getHit() + "-" + b.getBatAvg();
			}
		}
		df.writefile(datas);
	}

	public void loadData() {
		String datas[] = df.readfile();
		if (Integer.parseInt(datas[0]) < 2000) {
			for (int i = 0; i < datas.length; i++) {
				String split[] = datas[i].split("-");
				Human dto = new Pitcher(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]),
						Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]),
						Double.parseDouble(split[6]));
				list.add(dto);
			}
		} else {
			for (int i = 0; i < datas.length; i++) {
				String split[] = datas[i].split("-");
				Human dto = new Batter(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]),
						Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]),
						Double.parseDouble(split[6]));
				list.add(dto);
			}
		}
	}
}