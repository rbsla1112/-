package controller;

import java.sql.PreparedStatement;
import java.util.List;

import model.dto.MenuDTO;
import model.dto.OwnerDTO;
import service.OwnerService;
import view.ResultView;



public class OwnerController {
	private OwnerService ows = new OwnerService();

	private ResultView rv = new ResultView();
	
	public List<OwnerDTO> selectAllOwner() {
		List<OwnerDTO> ownerList = ows.selectAllOwner();
		
		return ownerList;
	}

	public void insertNewMenu() {
		
		Connection con = null;
		
		
		
		
	}

	public void deleteMenu(String menuName) {
		
		int deleteResult = OwnerService.deleteMenu(menuName);
		
		if(deleteResult > 0 ) {
			rv.displayDmlResult("deleteSuccess");
		} else {
			rv.displayDmlResult("deleteFailed");
		}
		
	}
	
	

	
}
