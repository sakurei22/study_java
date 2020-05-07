package day05;

import java.util.HashMap;
import java.util.Map;

//collection -map //19
public class Ex04 {
	public static void main(String[] args) {
		// 맵핑이란?
		// 그 단어가 몇번 나왔는지 카운트
		// I ate hamburgers. I love hamburgers.
		// <I. 2>, <ate, 1>, <hamburgers, 2>, <love, 1>
		// <분류 :key, 값: value>

		// 우리가 했던 collection 객체들은 polymothism을 적용시킬 수 있다.
		Map<String, String> map = new HashMap<String, String>();

		// map에 데이터를 저장할때에는 키와 벨류를 put 메소드에 담아서 저장한다.
		map.put("키1번", "벨류1번");
		map.put("키2번", "벨류2번");
		map.put("키1번", "벨류01번");

		// map의 저장된 데이터를 불러올때에는 키값으로 불러오게 된다.
		System.out.println(map.get("키1번"));

		// map에 저장을 할때 key는 key Set 에 저장된다.
		// 즉, 중복된 key값은 허용되지 않는다.(덮어씌어진다)
		for (String s : map.keySet()) {
			System.out.println(s);
		}
		// 만약 우리가 map의 키값과 벨류값을 전부 출력하고 싶다면?
		for (String s : map.keySet()) {
			System.out.println("key: "+s+"value"+map.get(s));
		}

	}
}
