package model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import static common.JDBCTemplate.*;

import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OrderlistDTO;

public class OrderDAO {
	private Properties prop = new Properties();
	
	public OrderDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/order-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<MenuDTO> selectMenuByOwner(Connection con, String inputOwner) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<MenuDTO> menuList = null;
		
		String query = prop.getProperty("selectMenuByOwner");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, inputOwner);
			
			rset = pstmt.executeQuery();
			
			menuList = new ArrayList<>();
			
			while(rset.next()) {
				MenuDTO menu = new MenuDTO();
				menu.setMenuCode(rset.getInt("MENU_CODE"));
				menu.setMenuName(rset.getString("MENU_NAME"));
				menu.setMenuPrice(rset.getInt("MENU_PRICE"));
				menu.setOwnerId(rset.getString("OWNER_ID"));
				menu.setOrderableStatus(rset.getString("ORDERABLE_STATUS"));
				
				menuList.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return menuList;
	}

	public int insertOrder(Connection con, OrderlistDTO orderList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertOrder");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, orderList.getOwnerId());
			pstmt.setString(2, orderList.getCustomerId());
			pstmt.setString(3, orderList.getOrderDateTime());
			pstmt.setInt(4, orderList.getTotalOrderPrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertOrderMenu(Connection con, OrderDTO orderMenu) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertOrderMenu");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderMenu.getMenuCode());
			pstmt.setInt(2, orderMenu.getAmount());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
