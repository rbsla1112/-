package model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static common.JDBCTemplate.*;

import model.dto.CustomerDTO;

public class CustomerDAO {
	private Properties prop = new Properties();
	
	public CustomerDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/order-query"));
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

}
