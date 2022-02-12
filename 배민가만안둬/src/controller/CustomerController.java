package controller;

import java.util.List;

import model.dto.CustomerDTO;
import model.dto.OrderlistDTO;
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
		
		return result;
	}

	public void customerSignup(String id, String pwd) {
		int result = customerService.signup(id, pwd);
		
		if(result > 0) {
			rv.displayDmlResult("signupinsertSuccess");
		} else {
			rv.displayDmlResult("signupinsertFailed");
		}
	}

	public void modifyPassword(String id, String inputPwd) {
		int result = customerService.updatePassword(id, inputPwd);
		
		if(result > 0) {
			rv.displayDmlResult("updateSuccess");
		} else {
			rv.displayDmlResult("updateFailed");
		}
	}

	public void selectOrderHistory(String id) {
		List<OrderlistDTO> orderHistory = customerService.selectOrderHistory(id);
		
		if(!orderHistory.isEmpty()) {
			rv.displayDmlResult("selectSuccess");
			rv.display(orderHistory);
		} else {
			rv.displayDmlResult("selectFailed");
		}
	}

	public void deleteCustomer(String id) {
		int result = customerService.deleteCustomer(id);
		
		if(result > 0) {
			rv.displayDmlResult("deleteSuccess");
		} else {
			rv.displayDmlResult("deleteFailed");
		}
	}
	
}
