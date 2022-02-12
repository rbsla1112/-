package service;

import model.dao.CustomerDAO;
import model.dto.CustomerDTO;
import java.sql.*;
import static common.JDBCTemplate.*;

public class CustomerService {
	private CustomerDAO customerDAO = new CustomerDAO();

	public CustomerDTO login(String id, String pwd) {
		Connection con = getConnection();
		
		CustomerDTO customer = customerDAO.login(con, id);
		
		close(con);
		
		return customer;
	}

	public int signup(String id, String pwd) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = customerDAO.signup(con, id, pwd);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
