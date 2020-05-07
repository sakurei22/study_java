package Viewer;

import java.util.Scanner;

import Controller.FoodController;
import Controller.IngredientsController;
import Controller.OrderController;

public class PosMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		OrderViewer orderViewer = new OrderViewer();
		IngredientsViewer ingredientsViewer = new IngredientsViewer();
		OrderController orderController = new OrderController();
		FoodController foodController = new FoodController(); 
		IngredientsController ingredientsController = new IngredientsController();
		
		while (true) {
			System.out.println("================= 주문 관리 시스템 =================");
			System.out.println("1.매장주문관리 2.외부주문관리 3.재료주문확인 4.수익보기 5.종료");
			int choice = scan.nextInt();
			if (choice == 1) {	// 1.매장내 주문
				orderViewer.orderTypeList(orderController, foodController, scan, choice);
				
			} else if (choice == 2) {	// 2. 외부주문
				orderViewer.orderTypeList(orderController, foodController, scan, choice);
							
			} else if (choice == 3) { // 3. 음식재료주문
				ingredientsViewer.showIngredientsList(orderController, ingredientsController, scan);
				
			} else if (choice == 4) {	// 수익보기
				
				orderViewer.plusList(orderController, foodController, ingredientsController, scan);
		
			} else if (choice == 5) {
				System.out.println("사용해주셔서 갑사합니다.");
				break;
			}
		}
		scan.close();
	}
}
