package Work_10_BaseBallmember;



import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberDAO {
	Scanner sc = new Scanner(System.in);
	private HashMap<String, HumanDTO> map;
	private int MemNumber;	//sequence number 관리 변수
	DataClass dataCls;
	
	public MemberDAO() {
		dataCls = new DataClass("baseball");
		dataCls.createfile();
		
		map = dataCls.readFile();
		MemNumber = 1000;
		
		// sequence number 산출
//		if(!map.isEmpty()) {
		if(map.size() > 0) {
			Iterator<String> it = map.keySet().iterator(); // 파일로 불러와서 맵에 넣었음. 그런데 어떤 선수는 1000. 다른 선수는 2000 어떤게 마지막인지 모름
			int lastNum = 0;
			while(it.hasNext()) {	//맨 마지막번호를 얻기위해
				String key = it.next(); 	// 키값 얻어옴
				HumanDTO h = map.get(key);	
				
				int lastMemNum = h.getNumber();
				if(lastMemNum >= 2000) {	//2000이상일 경우 - 1000해준다
					lastMemNum = lastMemNum - 1000;
				}
				if(lastNum < lastMemNum) {
					lastNum = lastMemNum;
				}
			}
			MemNumber = lastNum +1;
		}
	}
	
	public void insert() {
		System.out.println(">> 선수등록");
		System.out.println("투수(1) / 타자(2) 등록하고 싶은 포지션을 입력해주세요");
		System.out.print(">>>>> ");
		int choice = sc.nextInt();
		
		HumanDTO human = null;	// 입력받기전 초기화
		// human
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("신장: ");
		double height = sc.nextDouble();

		if(choice ==1) {		//pitcher
			System.out.print("승:");
			int win = sc.nextInt();
			
			System.out.print("패:");
			int lose = sc.nextInt();
			
			System.out.print("방어율:");
			double defence= sc.nextDouble();
			
			human = new Pitcher(MemNumber, name, age, height, win, lose, defence);
		}
		else {			//batter
			System.out.print("타수:");
			int batcount = sc.nextInt();
			
			System.out.print("안타수:");
			int hit = sc.nextInt();
			
			System.out.print("타율:");
			double hitAvg= sc.nextDouble();
			
			human = new Batter(MemNumber + 1000, name, age, height, batcount, hit, hitAvg);
		}
		map.put(human.getName(), human);
		
		MemNumber++;
	}
	
	public void delete() {
		System.out.println("방출하고 싶은 선수명을 입력해주십시오.");
		System.out.print(">>");
		String name = sc.next();
		
		HumanDTO h = null;	// 입력받기전 초기화
		h = map.get(name);
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return;
		}
		
		h = map.remove(name);
		System.out.println(h.getName()+"선수의 데이터가 삭제되었습니다.");
	}
	
	public void select() {
		System.out.println("검색하고 싶은 선수명을 입력해주십시오.");
		System.out.print(">>");
		String name = sc.next();
		
		HumanDTO h = null;
		h = map.get(name);
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return;
		}
		System.out.println("검색된 선수입니다");
		h.infomation();
	}
	
	public void update() {
		System.out.println("수정하고 싶은 선수명을 입력해주십시오.");
		System.out.print(">>");
		String name = sc.next();
		
		HumanDTO h = null;
		h = map.get(name);
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return;
		}
		System.out.println("수정할 데이터를 입력해주세요.");
		if(h.getNumber()<2000) {	//투수
			Pitcher p = (Pitcher)h;
			System.out.println("승: ");
			int win = sc.nextInt();
			System.out.println("패: ");
			int lose = sc.nextInt();
			System.out.println("방어율: ");
			double defence = sc.nextDouble();
			
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);
			
		}else {						//타자
			Batter b = (Batter)h;
			
			System.out.println("타수: ");
			int batcount = sc.nextInt();
			System.out.println("안타: ");
			int hit = sc.nextInt();
			System.out.println("타율: ");
			double hitAvg = sc.nextDouble();
			
			b.setBatcount(batcount);
			b.setHit(hit);
			b.setHitAvg(hitAvg);
		}
		System.out.println("데이터를 수정하였습니다.");
	}
	
	public void allprint() {
		Iterator<String> it =  map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			HumanDTO h = map.get(key);
			System.out.println(h.toString());
		}
	}
	
	public void memberSort() {
		HashMap<String, HumanDTO> hashMap = new HashMap<String, HumanDTO>(); // 원본 복사    참고>원본: map
		HashMap<String, HumanDTO> hashMap2 = new HashMap<String, HumanDTO>();
		
		Iterator<String> it = map.keySet().iterator(); 	// 기존데이터 맵의 키를 몽땅 얻어옴
		int w = 0; 										// 루프형 변수. 같은 키값이 들어가는것을 막아주기위한 변수
		while(it.hasNext()) {
			String key = it.next();
			HumanDTO h = map.get(key);
			if(h instanceof Pitcher) {
				Pitcher p = (Pitcher)h;
				hashMap.put(p.getDefence()+""+ w, p);	//double + "" -> 문자열
				w++;
			}else {
				Batter b = (Batter) h;
				hashMap2.put(b.getHitAvg() +""+ w, b);
			}
		}
		//투수 올림차순
		TreeMap<String, HumanDTO> tMap = new TreeMap<String, HumanDTO>(hashMap);
		Iterator<String> updownIt = tMap.keySet().iterator();
		while(updownIt.hasNext()) {
			String key = updownIt.next();
			System.out.print("key: "+key+" ");
			HumanDTO h = tMap.get(key);
			System.out.println(h.toString());
		}
		//타자 내림차순
		TreeMap<String, HumanDTO> tMap2 = new TreeMap<String, HumanDTO>(hashMap2);
		Iterator<String> updownIt2 = tMap2.descendingKeySet().iterator();
		while(updownIt2.hasNext()) {
			String key = updownIt2.next();
			System.out.print("key: "+key+" ");
			HumanDTO h = tMap2.get(key);
			System.out.println(h.toString());
		}
	}
	
	public void saveData() {
		String arrStr[] = new String[map.size()];
		int w = 0;
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			HumanDTO h = map.get(key); // .toString
			arrStr[w] = h.toString();
			w++;
		}
		dataCls.writeFile(arrStr);
	}
}

