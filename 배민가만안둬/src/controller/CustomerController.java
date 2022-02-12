package controller;

import model.dto.CustomerDTO;
import service.CustomerService;
import view.ResultView;

public class CustomerController {
	private CustomerService customerService = new CustomerService();
	private ResultView rv = new ResultView();

	public int customerLogin(String id, String pwd) {
		CustomerDTO customer = customerService.login(id, pwd);
		int result = 0;
		
		if(id.equals(customer.getCustomerId()) && pwd.equals(customer.getCustomerPwd())) {
			rv.displayDmlResult("loginSuccess");
			result = 1;
		} else {
			rv.displayDmlResult("loginFailed");
		}
		
		return 0;
	}

	public void customerSignup(String id, String pwd) {
		int result = customerService.signup(id, pwd);
		
		if(result > 0) {
			rv.displayDmlResult("signupinsertSuccess");
		} else {
			rv.displayDmlResult("signupinsertFailed");
		}
	}
	
}
