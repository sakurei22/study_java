package Controller;

import java.util.ArrayList;

import DTO.OrderDTO;

public class OrderController { // 오더를 상속받아 1.storeOrder 2.DeliveryOrder 로 클래스 생성.
	ArrayList<OrderDTO> list;

	public OrderController() {

		list = new ArrayList<OrderDTO>();
		OrderDTO o = new OrderDTO();
		o.setId(0);
		o.setPerson(2);
		o.setTitle("피자");
		o.setOrderType(1);

		OrderDTO o1 = new OrderDTO();
		o1.setId(1);
		o1.setPerson(5);
		o1.setTitle("치킨");
		o1.setOrderType(2);

		OrderDTO o2 = new OrderDTO();
		o2.setId(2);
		o2.setPerson(3);
		o2.setTitle("족발");
		o2.setOrderType(1);

		list.add(o);
		list.add(o1);
		list.add(o2);
	}

	public void insert(OrderDTO o) { // 주문은 중복내용 가능이므로 번호만 증가시키면서 추가

		int id = list.get(list.size() - 1).getId() + 1;
		o.setId(id);
		list.add(o);

	}

	public void update(OrderDTO selectedOrder) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == selectedOrder.getId()) {
				list.set(i, selectedOrder);
			}
		}
	}

	public void delete(OrderDTO selecetedOrder) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == selecetedOrder.getId()) {
				list.remove(i);
			}
		}
	}

	public OrderDTO selectOne(int id) {
		for (OrderDTO o : list) {
			if (o.getId() == id) {
				return o;
			}
		}
		return null;
	}

	public ArrayList<OrderDTO> selectAll() {
		return list;
	}

	public ArrayList<OrderDTO> selectType(int type) {
		ArrayList<OrderDTO> orderTypeList = new ArrayList<OrderDTO>(); // 새로운리스트를 만들어서 같은타입만 추가하여 리턴
		
		for (OrderDTO o : list) {
			if (o.getOrderType() == type) {
				orderTypeList.add(o);
			}
		}
		return orderTypeList;
	}
	
	public ArrayList<OrderDTO> selectTitle(String type) {
		ArrayList<OrderDTO> orderTitleList = new ArrayList<OrderDTO>(); // 새로운리스트를 만들어서 같은타입만 추가하여 리턴
		
		for (OrderDTO o : list) {
			if (o.getTitle().equals("type")) {
				orderTitleList.add(o);
			}
		}
		return orderTitleList;
	}
}
