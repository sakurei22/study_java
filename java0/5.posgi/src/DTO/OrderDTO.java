package DTO;

public class OrderDTO {		
	private int id;
	private String title;
	private int person;
	private int orderType; // 1:매장 2:외부주문
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int type) {
		this.orderType = type;
	}
	
}