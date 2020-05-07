package Viewer;


import java.util.Scanner;

import Controller.FoodController;
import Controller.IngredientsController;
import Controller.OrderController;
import DTO.OrderDTO;

public class OrderViewer {
	// 1. 2. 타입별 리스트 보기
	public void orderTypeList(OrderController orderController, FoodController foodController, Scanner scan,
	        int choice) {

		System.out.println("주문번호 \t 음식\t 인원\t 타입");
		System.out.println("---------------------------------");
		for (OrderDTO type : orderController.selectType(choice)) {
			if (type.getOrderType() == 1) {
				System.out.printf("%d\t %s\t %d\t %s\n", type.getId(), type.getTitle(), type.getPerson(), "매장");
			} else if (type.getOrderType() == 2) {
				System.out.printf("%d\t %s\t %d\t %s\n", type.getId(), type.getTitle(), type.getPerson(), "외부배달");
			}
		}
		System.out.println("---------------------------------");
		System.out.println("1.추가 2.수정 3.삭제 4.총수익 5.메인메뉴로");
		int choice1 = scan.nextInt();

		if (choice1 == 1) {
			addOrder(orderController, foodController, scan, choice);
		} else if (choice1 == 2) {
			updateOrder(orderController, foodController, scan);
		} else if (choice1 == 3) {
			deleteOrder(orderController, scan);
		} else if (choice1 == 4) { // 타입별 총수익
			getTypePrice(orderController, foodController, choice);
		} else if (choice1 == 5) {
			System.out.println("메인메뉴로 이동합니다.");
		}

	}

	// 3. ingredientsViewr.java에 있음

	// 4. 전체주문목록 보기, 순이익보기 리스트
	public void plusList(OrderController orderController, FoodController foodController,
	        IngredientsController ingredientsController, Scanner scan) {
		System.out.println("주문번호 \t 음식\t 인원\t 타입");
		System.out.println("---------------------------------");
		for (OrderDTO all : orderController.selectAll()) {
			if (all.getOrderType() == 1) {
				System.out.printf("%d\t %s\t %d\t %s\n", all.getId(), all.getTitle(), all.getPerson(), "매장");

			} else if (all.getOrderType() == 2) {
				System.out.printf("%d\t %s\t %d\t %s\n", all.getId(), all.getTitle(), all.getPerson(), "외부배달");

			}
		}
		System.out.println("---------------------------------");
		getPrice(orderController, foodController);
		System.out.println("1.오늘얼마?");
		System.out.print(">");
		int choice = scan.nextInt();
		if (choice == 1)
			getPlus(orderController, foodController, ingredientsController);
	}

	// 4-1. 전체 수익
	public int getPrice(OrderController orderController, FoodController foodController) {

		int totalPrice = 0;
		for (OrderDTO o : orderController.selectAll()) {
			totalPrice += o.getPerson() * foodController.selectOne(o.getTitle()).getCost();

		}
		System.out.println("총 " + totalPrice + "원");
		return totalPrice;

	}

	// 1.2.-4.타입별 수익
	public int getTypePrice(OrderController orderController, FoodController foodController, int choice) {
		int totalPrice = 0;
		for (OrderDTO type : orderController.selectType(choice)) {
			totalPrice += type.getPerson() * foodController.selectOne(type.getTitle()).getCost();

		}
		System.out.println(totalPrice);
		return totalPrice;

	}

	// 4-1. 순이익 (전체수익 - 재료비용)
	public int getPlus(OrderController orderController, FoodController foodController,
	        IngredientsController ingredientsController) {

		int totalPrice = 0;
		int totalCost = 0;
		for (OrderDTO o : orderController.selectAll()) {
			totalPrice += o.getPerson() * foodController.selectOne(o.getTitle()).getCost();
		}
		for (OrderDTO o : orderController.selectAll()) {
			totalCost += o.getPerson() * ingredientsController.selectOne(o.getTitle()).getCost();
		}

		int totalPlus = totalPrice - totalCost; //
		System.out.println(totalPlus + "원을 벌었다!!");
		System.out.println();

		return totalPlus;

	}

	public void addOrder(OrderController orderController, FoodController foodController, Scanner scan, int choice) {
		OrderDTO o = new OrderDTO();
		scan.nextLine();
		System.out.println("---------------------------------");
		System.out.println("새로주문할 음식을 선택하세요.");
		System.out.println("< 1.피자  2.치킨  3.족발 >");
		int food = scan.nextInt(); // String 입력시 오류발생
		if (food == 1) {
			o.setTitle("피자");
		} else if (food == 2) {
			o.setTitle("치킨");
		} else if (food == 3) {
			o.setTitle("족발");
		} else {
			System.out.println("잘못된입력입니다.");
			addOrder(orderController, foodController, scan, food);
		}
		System.out.println("---------------------------------");
		System.out.print("인원: ");
		o.setPerson(scan.nextInt());
		scan.nextLine();
		System.out.println("---------------------------------");
		System.out.println("주문타입을 선택하세요.");
		System.out.println("1.매장 2.외부주문");
		int place = scan.nextInt();
		if (place == 1) {
			o.setOrderType(1);
		} else if (place == 2) {
			o.setOrderType(2);
		} else {
			System.out.println("잘못된입력입니다.");
			addOrder(orderController, foodController, scan, place);
		}
		orderController.insert(o);
		orderTypeList(orderController, foodController, scan, choice);
	}

	public void deleteOrder(OrderController orderController, Scanner scan) {
		System.out.println("---------------------------------");
		System.out.println("환불하실주문을 선택해주세요");
		System.out.print(">");
		int selectId = scan.nextInt();
		OrderDTO selectedOrder = orderController.selectOne(selectId);
		orderController.delete(selectedOrder);

	}

	public void updateOrder(OrderController orderController, FoodController foodController, Scanner scan) {
		scan.nextLine();
		System.out.println("---------------------------------");
		System.out.println("수정하실 주문을 선택해주세요");
		System.out.print(">");
		int selectId = scan.nextInt();
		OrderDTO selectedOrder = orderController.selectOne(selectId);
		scan.nextLine();
		System.out.println("---------------------------------");
		System.out.println("무엇으로 바꾸시겠습니까?");
		System.out.println("< 1.피자  2.치킨  3.족발 >");
		int food = scan.nextInt();
		if (food == 1) {
			selectedOrder.setTitle("피자");
		} else if (food == 2) {
			selectedOrder.setTitle("치킨");
		} else if (food == 3) {
			selectedOrder.setTitle("족발");
		} else {
			System.out.println("잘못된입력입니다.");
		}
		System.out.println("---------------------------------");
		System.out.println("인원: ");
		selectedOrder.setPerson(scan.nextInt());
		System.out.println("---------------------------------");
		System.out.println("주문타입을 선택하세요.");
		System.out.println("1.매장 2.외부주문");
		int place = scan.nextInt();
		if (place == 1) {
			selectedOrder.setOrderType(1);
		} else if (place == 2) {
			selectedOrder.setOrderType(2);
		} else {
			System.out.println("잘못된입력입니다.");
		}
		orderController.update(selectedOrder);
	}
}
