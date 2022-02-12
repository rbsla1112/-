package service;

import java.util.*;
import java.sql.*;
import static common.JDBCTemplate.*;

import model.dao.OrderDAO;
import model.dto.MenuDTO;

public class OrderService {
	private OrderDAO orderDAO = new OrderDAO();

	public List<MenuDTO> selectMenuByOwner(String inputOwner) {
		Connection con = getConnection();
		
		List<MenuDTO> menuList = orderDAO.selectMenuByOwner(con, inputOwner);
		
		close(con);
		
		return menuList;
	}

}
