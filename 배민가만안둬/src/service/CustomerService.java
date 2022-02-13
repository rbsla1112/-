package service;

import model.dao.CustomerDAO;
import model.dto.CustomerDTO;
import model.dto.OrderlistDTO;

import java.sql.*;
import java.util.List;

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

	public int updatePassword(String id, String inputPwd) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = customerDAO.updatePassword(con, id, inputPwd);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public List<OrderlistDTO> selectOrderHistory(String id) {
		Connection con = getConnection();
		
		List<OrderlistDTO> orderHistory = customerDAO.selectOrderHistory(con, id);
		
		close(con);
		
		return orderHistory;
	}

	public int plustCount(String id) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = customerDAO.plusCount(con, id);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}

	public int modifyGrade(String id, int count) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = customerDAO.modifyGrade(con, id, count);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}

	public CustomerDTO selectCustomerById(String id) {
		Connection con = getConnection();
		
		CustomerDTO customer = customerDAO.selectCustomerById(con, id);
		
		close(con);
		
		return customer;
	}

}
