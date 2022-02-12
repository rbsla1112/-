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

}
