package model.dto;

public class CustomerDTO {
	private String customerId;
	private String customerPwd;
	private int count;
	private String grade;
	
	public CustomerDTO() {}

	public CustomerDTO(String customerId, String customerPwd, int count, String grade) {
		super();
		this.customerId = customerId;
		this.customerPwd = customerPwd;
		this.count = count;
		this.grade = grade;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPwd() {
		return customerPwd;
	}

	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", customerPwd=" + customerPwd + ", count=" + count
				+ ", grade=" + grade + "]";
	}
}