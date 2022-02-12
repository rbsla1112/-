package model.dto;

import java.util.List;

public class OrderlistDTO {
	private int orderCode;
	private String ownerId;
	private String customerId;
	private String orderDateTime;
	private int totalOrderPrice;
	private int point;
	private List<OrderDTO> orderMenuList;
	
	public OrderlistDTO() {}

	public OrderlistDTO(int orderCode, String ownerId, String customerId, String orderDateTime, int totalOrderPrice,
			int point, List<OrderDTO> orderMenuList) {
		super();
		this.orderCode = orderCode;
		this.ownerId = ownerId;
		this.customerId = customerId;
		this.orderDateTime = orderDateTime;
		this.totalOrderPrice = totalOrderPrice;
		this.point = point;
		this.orderMenuList = orderMenuList;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getOrderDateTime() {
		return orderDateTime;
	}

	public int getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public int getPoint() {
		return point;
	}

	public List<OrderDTO> getOrderMenuList() {
		return orderMenuList;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public void setTotalOrderPrice(int totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setOrderMenuList(List<OrderDTO> orderMenuList) {
		this.orderMenuList = orderMenuList;
	}

	@Override
	public String toString() {
		return "OrderlistDTO [orderCode=" + orderCode + ", ownerId=" + ownerId + ", customerId=" + customerId
				+ ", orderDateTime=" + orderDateTime + ", totalOrderPrice=" + totalOrderPrice + ", point=" + point
				+ ", orderMenuList=" + orderMenuList + "]";
	}
}