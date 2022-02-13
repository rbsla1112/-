package model.dto;

public class ReviewDTO {
	private int orderCode;
	private int point;
	private String review;
	
	public ReviewDTO() {}

	public ReviewDTO(int orderCode, int point, String review) {
		super();
		this.orderCode = orderCode;
		this.point = point;
		this.review = review;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "ReviewDTO [orderCode=" + orderCode + ", point=" + point + ", review=" + review + "]";
	}
}
