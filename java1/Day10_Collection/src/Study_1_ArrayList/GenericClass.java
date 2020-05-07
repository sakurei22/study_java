package Study_1_ArrayList;

public class GenericClass {
	public static void main(String[] args) {
		/*
		 	
		 	Generic == template
		 	
		 */
		
		Box<Integer> box = new Box<Integer>(234);
		System.out.println(box.getTemp());
		
		Box<String> sbox = new Box<String>("my world");
		System.out.println(sbox.getTemp());
		
		BoxMap<Integer, String> bm = new BoxMap<Integer, String>(123, "hi hello");
		
		System.out.println(bm.getKey());
		System.out.println(bm.getValue());
	}
}

// Generic == 자료형의 변수
class Box<T>{
	
	T temp;
	
	public Box(T temp) {
		this.temp = temp;
	}

	public T getTemp() {
		return temp;
	}
	public void setTemp(T temp) {
		this.temp = temp;
	}
}

class BoxMap<K, V>{
	
	K key;
	V value;
	public BoxMap(K key, V value) {
		
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}






