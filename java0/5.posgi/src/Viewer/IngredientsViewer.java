package Viewer;


import java.util.Scanner;

import Controller.IngredientsController;
import Controller.OrderController;
import DTO.OrderDTO;

public class IngredientsViewer {

	public void showIngredientsList(OrderController orderController, IngredientsController ingredientsController, Scanner scan) {
		
		int totalPi = 0;
		int totalChi = 0;
		int totalJok = 0;
		for (OrderDTO p : orderController.selectAll()) {
			if (p.getTitle().equals("피자")) {
				totalPi += p.getPerson();
			} else if (p.getTitle().equals("치킨")) {
				totalChi += p.getPerson();
			} else if (p.getTitle().equals("족발")) {
				totalJok += p.getPerson();
			}
		}
		System.out.println("치즈: "+totalPi);
		System.out.println("병아리 : " +totalChi);
		System.out.println("돼지: "+totalJok);
	
		System.out.println("---------------------------------");
		System.out.println("1.총주문비용보기 2.돌아가기");
		System.out.print(">");
		int choice = scan.nextInt();
		if (choice == 1) {
			getCost(orderController, ingredientsController);
		}
			
		
	}

	public int getCost(OrderController orderController, IngredientsController ingredientsController) {
		
		int totalCost = 0;
		for (OrderDTO o : orderController.selectAll()) {
			totalCost += o.getPerson() * ingredientsController.selectOne(o.getTitle()).getCost();
		}
		System.out.println(totalCost);
		return totalCost;

	}

}
