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

	public OwnerDTO login(String id, String pwd) {
		Connection con = getConnection();
		
		OwnerDTO owner = ownerDAO.login(con, id);
		
		close(con);
		
	

		return owner;
	}

	public int signup(String id, String pwd) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = ownerDAO.signup(con, id, pwd);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);
		
		return result;
	}

	public int createMenu(String menu, String price) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = ownerDAO.createMenu(con, menu, price);
		
		if(result >0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
