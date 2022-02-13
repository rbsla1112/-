package model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import static common.JDBCTemplate.*;

import model.dto.MenuDTO;
import model.dto.OwnerDTO;

public class OwnerDAO {
	private Properties prop = new Properties();
	
	public OwnerDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/order-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<OwnerDTO> selectAllOwner(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<OwnerDTO> ownerList = null;
		
		String query = prop.getProperty("selectAllOwner");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			ownerList = new ArrayList<>();
			
			while(rset.next()) {
				OwnerDTO owner = new OwnerDTO();
				owner.setOwnerId(rset.getString("OWNER_ID"));
				owner.setOwnerPwd(rset.getString("OWNER_PWD"));
				
				ownerList.add(owner);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ownerList;
	}

	public OwnerDTO login(Connection con, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		OwnerDTO owner = null;
		
		String query = prop.getProperty("ownerLogin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				owner = new OwnerDTO();
				owner.setOwnerId(rset.getString("OWNER_ID"));
				owner.setOwnerPwd(rset.getString("OWNER_PWD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return owner;
	}

	public int signup(Connection con, String id, String pwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("ownerSignup");
		
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
		
		String query = prop.getProperty("updateOwnerPassword");
		
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

	public int createMenu(Connection con, MenuDTO menu) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("createMenu");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, menu.getMenuName());
			pstmt.setInt(2, menu.getMenuPrice());
			pstmt.setString(3, menu.getOwnerId());
			pstmt.setString(4, menu.getOrderableStatus());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMenu(Connection con, String menuName) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMenu");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, menuName);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
