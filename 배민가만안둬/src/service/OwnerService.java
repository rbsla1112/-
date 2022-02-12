package service;

import java.util.*;
import java.sql.*;
import static common.JDBCTemplate.*;

import model.dao.OwnerDAO;
import model.dto.OwnerDTO;

public class OwnerService {
	private OwnerDAO ownerDAO = new OwnerDAO();

	public List<OwnerDTO> selectAllOwner() {
		Connection con = getConnection();
		
		List<OwnerDTO> ownerList = ownerDAO.selectAllOwner(con);
		
		close(con);
		
		return ownerList;
	}

	public static int deleteMenu(String menuName) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = ownerDAO.deleteMenu(con, menuName);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}

	public static int updateMenu(String menuName, int menuPrice) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = ownerDAO.updateMenu(con, menuName, menuPrice);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

}
