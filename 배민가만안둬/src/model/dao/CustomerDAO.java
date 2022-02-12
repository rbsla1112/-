package model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static common.JDBCTemplate.*;

import model.dto.CustomerDTO;
import model.dto.OrderlistDTO;

public class CustomerDAO {
	private Properties prop = new Properties();
	
	public CustomerDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/order-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CustomerDTO login(Connection con, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		CustomerDTO customer = null;
		
		String query = prop.getProperty("customerLogin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				customer = new CustomerDTO();
				
				customer.setCustomerId(rset.getString("CUSTOMER_ID"));
				customer.setCustomerPwd(rset.getString("CUSTOMER_PWD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return customer;
	}

	public int signup(Connection con, String id, String pwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("customerSignup");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePassword(Connection con, String id, String inputPwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePassword");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, inputPwd);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<OrderlistDTO> selectOrderHistory(Connection con, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<OrderlistDTO> orderHistory = null;
		
		String query = prop.getProperty("selectOrderHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			orderHistory = new ArrayList<>();
			
			while(rset.next()) {
				OrderlistDTO orderList = new OrderlistDTO();
				orderList.setOrderCode(rset.getInt("ORDER_CODE"));
				orderList.setOwnerId(rset.getString("OWNER_ID"));
				orderList.setCustomerId(rset.getString("CUSTOMER_ID"));
				orderList.setOrderDateTime(rset.getString("ORDER_DATE_TIME"));
				orderList.setTotalOrderPrice(rset.getInt("TOTAL_ORDER_PRICE"));
				
				orderHistory.add(orderList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return orderHistory;
	}

	public int deleteCustomer(Connection con, String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteCustomer");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
