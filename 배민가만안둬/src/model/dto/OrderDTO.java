package model.dto;

public class OrderDTO {

	private int orderCode;
	private int menuCode;
	private int amount;
	private String orderTime;
	private int totalPrice;
	
	public OrderDTO() {}

	public OrderDTO(int orderCode, int menuCode, int amount, String orderTime, int totalPrice) {
		super();
		this.orderCode = orderCode;
		this.menuCode = menuCode;
		this.amount = amount;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderCode=" + orderCode + ", menuCode=" + menuCode + ", amount=" + amount + ", orderTime="
				+ orderTime + ", totalPrice=" + totalPrice + "]";
	}
	
}