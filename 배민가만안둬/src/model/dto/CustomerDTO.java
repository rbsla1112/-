package model.dto;

public class CustomerDTO {
	private String customerId;
	private String customerPwd;
	
	public CustomerDTO() {}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", customerPwd=" + customerPwd + "]";
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

	public CustomerDTO(String customerId, String customerPwd) {
		super();
		this.customerId = customerId;
		this.customerPwd = customerPwd;
	}	
}