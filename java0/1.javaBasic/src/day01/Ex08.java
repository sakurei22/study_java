package day01;
//별찍기
//
public class Ex08 {
	public static void main(String[] agrs) {
		System.out.println(" --1번--");
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	
		System.out.println(" --2번--");
		for(int i = 1; i <=5; i++) {
			String starPrint ="";
			for(int j =i; j <=5; j++) {
				//String을 연결하는 방법1. 
				//+연산자를 이용한다.
				//starPint = starPrint + "*";
				//위의 코드를 간략화시키면?
				starPrint += "*";
			}
			System.out.println(starPrint);
		}
		System.out.println("--3번--");
		//String 연결2번
		for(int i = 1; i <=5; i++) {
					String starPrint = "";
			for(int j = 1; j<=5-i; j++) {
				starPrint = starPrint.concat(" ");
			}
			for(int j = 1; j <=i; j++) {
				starPrint = starPrint.concat("*");
		} 
		System.out.println(starPrint);
		}
		System.out.println("--4번--");
		for(int i = 1; i<=5; i++) {
		StringBuilder stringBuilder = new StringBuilder();
			for(int j = 1; j <= i-1; j++) {
				stringBuilder.append(' ');
			}
			for(int j = i; j <= 5; j++) {
				stringBuilder.append("*");
			}
		System.out.println(stringBuilder.toString());
		}
		System.out.println("--5번--");
		for(int i = 0; i<5; i ++) {
			for(int j = 4; j>i; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k<=i*2+1; k++) {
				System.out.print("*");
			}
		System.out.println();
		}
		System.out.println("--6번--");
		for(int i =0; i <5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(" ");
			}
			for(int k = 9; k>=i*2+1; k--) {
			System.out.print("*");
			}
		System.out.println();
		}
		System.out.println("--7번--");
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
			}
		for(int k = 1; k <=4; k++) {
			String starPrint ="";
			for(int l =k; l <=4; l++) {
				starPrint += "*";
			}
			System.out.println(starPrint);
		}
		System.out.println("--8번--");
		for(int i = 1; i <=5; i++) {
					String starPrint = "";
			for(int j = 1; j<=5-i; j++) {
				starPrint = starPrint.concat(" ");
			}
			for(int j = 1; j <=i; j++) {
				starPrint = starPrint.concat("*");
		} 
		System.out.println(starPrint);
		}
		for(int i = 1; i<=4; i++) {
			StringBuilder stringBuilder = new StringBuilder();
				for(int j = 1; j <= i; j++) {
					stringBuilder.append(' ');
				}
				for(int j = i; j <= 4; j++) {
					stringBuilder.append("*");
				}
			System.out.println(stringBuilder.toString());
			}
	
		System.out.println("--9번--");
		for(int i=0; i<5; i++) {
			for(int j= 4; j>i; j--) {
				System.out.print(" ");
			}
			for(int k=1; k<= i*2+1; k++) {
				System.out.print("*");
			}
		System.out.println(" ");
		}
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
			System.out.print(" ");
			}
			for(int k=7; k>=i*2+1; k--) {
			System.out.print("*");
			}
		System.out.println();
		}
	
		System.out.println("--10번--");
		for(int i=0; i<5; i++) {
			for(int j= 4; j>i; j--) {
				System.out.print("*");
			}
			for(int k=1; k<= i*2+1; k++) {
				System.out.print(" ");
			}
		System.out.println(" ");
		}
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
			System.out.print("*");
			}
			for(int k=7; k>=i*2+1; k--) {
			System.out.print(" ");
			}
		System.out.println();
		}
	}
		
}	
		