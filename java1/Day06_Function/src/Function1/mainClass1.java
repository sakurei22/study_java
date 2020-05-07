package Function1;

public class mainClass1 {
	public static void main(String[] args) {
		/*
		array		array
		 자료형 함수명 (매개변수)
		 	처리
		 	리턴값 array
		 */
		
		int num;	//stact
		int arrNum[] = new int[1];
		
		num = 11;
		arrNum[0]	= 11;
	
		//			11, 주소값,	11 이 넘어감
		num = func(num, arrNum, arrNum[0]);
		System.out.println("num="+num);
		System.out.println("arrNum[0]=" + arrNum[0]);
		
		
		int aNumber[] = {2, 4, 6, 8, 10};
		arrDiv2(aNumber);
		for (int i = 0; i < aNumber.length; i++) {
			System.out.println("aNumber[" + i + "]= "+aNumber[i]);
		}
		
		
		int a, b;
		a = 1;
		b = 2;
		System.out.println("함수전 a= "+a + " b ="+b);
		swap(a, b);
		System.out.println("함수후 a= "+a + " b ="+b);
		
		
		
		int arr[] = new int[2];
		arr[0] = 1;
		arr[1] = 2;
		System.out.println("함수전 arr[0]= "+arr[0]+ "arr[1]= "+arr[1]);
		swapArr(arr);
		System.out.println("함수후 arr[0]= "+arr[0]+ "arr[1]= "+arr[1]);
		
	}
	//				value		adress(=pointer), value
	static int func(int n, int arr[], int arrNum) {
		System.out.println("n= "+n);
		System.out.println("arr[0]="+arr[0]);
		
		n = 22;
		arr[0] = 22;
		return n;
	}
	
	static void arrDiv2(int anum[]) {
		for (int i = 0; i < anum.length; i++) {
			anum[i] = anum[i]/2;
		}
	}
	
	static void swap(int a, int b) {
		int temp;
		
		temp = a;
		a = b;
		b = temp;
		System.out.println("함수안 a= "+a + " b ="+b);
	}
	
	static void swapArr(int arr[]) {
		int temp;
		temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
		System.out.println("함수안 arr[0]= "+arr[0]+ "arr[1]= "+arr[1]);
	}
	
	//배열리턴경우
	static int[] randomValue(int rnum) {
		int array[] = new int[rnum];
		for (int i = 0; i < array.length; i++) {
			array[i]= (int)(Math.random()*10);
		}
		return array;
	}
}
