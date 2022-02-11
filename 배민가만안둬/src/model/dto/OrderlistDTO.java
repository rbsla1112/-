package model.dto;

public class OrderlistDTO {
	private int orderCode;
	private int menuCode;
	private String ownerId;
	private String customerId;
	private int totalOrderAmount;
	private int totalOrderPrice;
	private int point;
	
	public OrderlistDTO() {}

	public OrderlistDTO(int orderCode, int menuCode, String ownerId, String customerId, int totalOrderAmount,
			int totalOrderPrice, int point) {
		super();
		this.orderCode = orderCode;
		this.menuCode = menuCode;
		this.ownerId = ownerId;
		this.customerId = customerId;
		this.totalOrderAmount = totalOrderAmount;
		this.totalOrderPrice = totalOrderPrice;
		this.point = point;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public int getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public int getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public int getPoint() {
		return point;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setTotalOrderAmount(int totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public void setTotalOrderPrice(int totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "OrderlistDTO [orderCode=" + orderCode + ", menuCode=" + menuCode + ", ownerId=" + ownerId
				+ ", customerId=" + customerId + ", totalOrderAmount=" + totalOrderAmount + ", totalOrderPrice="
				+ totalOrderPrice + ", point=" + point + "]";
	}
}