package model.dto;

public class OrderDTO {

	private int orderCode;
	private int menuCode;
	private int amount;
	
	public OrderDTO() {}

	public OrderDTO(int orderCode, int menuCode, int amount) {
		super();
		this.orderCode = orderCode;
		this.menuCode = menuCode;
		this.amount = amount;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public int getAmount() {
		return amount;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderCode=" + orderCode + ", menuCode=" + menuCode + ", amount=" + amount + "]";
	}

	
}