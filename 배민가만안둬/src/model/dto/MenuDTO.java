package model.dto;

public class MenuDTO {

	private int menuCode;
	private String menuName;
	private int menuPrice;
	private String ownerId;
	private String orderableStatus;
	
	public MenuDTO() {}

	public MenuDTO(int menuCode, String menuName, int menuPrice, String ownerId, String orderableStatus) {
		super();
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.ownerId = ownerId;
		this.orderableStatus = orderableStatus;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOrderableStatus() {
		return orderableStatus;
	}

	public void setOrderableStatus(String orderableStatus) {
		this.orderableStatus = orderableStatus;
	}

	@Override
	public String toString() {
		return "MenuDTO [menuCode=" + menuCode + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", ownerId="
				+ ownerId + ", orderableStatus=" + orderableStatus + "]";
	}	
}