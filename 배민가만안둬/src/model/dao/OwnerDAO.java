package model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import static common.JDBCTemplate.*;

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

	public static int deleteMenu(Connection con, String menuName) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMenu");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, menuName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		result = pstmt.executeUpdate();
		
		return result;
	}

	public static int updateMenu(Connection con, String menuName, int menuPrice) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("UpdateMenu");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, menuName);
			pstmt.setInt(2, menuPrice);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
