package service;

import java.util.*;
import java.sql.*;
import static common.JDBCTemplate.*;

import model.dao.OrderDAO;
import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OrderlistDTO;

public class OrderService {
	private OrderDAO orderDAO = new OrderDAO();

	public List<MenuDTO> selectMenuByOwner(String inputOwner) {
		Connection con = getConnection();
		
		List<MenuDTO> menuList = orderDAO.selectMenuByOwner(con, inputOwner);
		
		close(con);
		
		return menuList;
	}

	public int registOrder(OrderlistDTO orderList) {
		Connection con = getConnection();
		
		int result = 0;
		
		int orderResult = orderDAO.insertOrder(con, orderList);
		
		List<OrderDTO> orderMenuList = orderList.getOrderMenuList();
		int orderMenuResult = 0;
		for(OrderDTO orderMenu : orderMenuList) {
			orderMenuResult += orderDAO.insertOrderMenu(con, orderMenu);
		}
		
		if(orderResult > 0 && orderMenuResult == orderMenuList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
