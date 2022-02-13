package controller;

import java.util.List;
import java.util.Map;

import model.dto.MenuDTO;
import model.dto.OwnerDTO;
import service.OwnerService;
import view.ResultView;

public class OwnerController {
	private OwnerService ows = new OwnerService();
	private ResultView rv = new ResultView();
	private OrderController oc = new OrderController();

	public List<OwnerDTO> selectAllOwner() {
		List<OwnerDTO> ownerList = ows.selectAllOwner();
		
		return ownerList;
	}

	public int ownerLogin(String id, String pwd) {
		OwnerDTO owner = ows.login(id, pwd);
		int result = 0;
		
		if(id.equals(owner.getOwnerId()) && pwd.equals(owner.getOwnerPwd())) {
			rv.displayDmlResult("loginSuccess");
			result = 1;
		} else {
			rv.displayDmlResult("loginFailed");
		}
		
		return result;
	}

	public void ownerSignup(String id, String pwd) {
		int result = ows.signup(id, pwd);
		
		if(result > 0) {
			rv.displayDmlResult("signupinsertSuccess");
		} else {
			rv.displayDmlResult("signupinsertFailed");
		}
	}

	public void modifyPassword(String id, String inputPwd) {
		int result = ows.updatePassword(id, inputPwd);
		
		if(result > 0) {
			rv.displayDmlResult("updateSuccess");
		} else {
			rv.displayDmlResult("updateFailed");
		}
	}

	public void deleteMenu(String menuName) {
		int deleteResult = ows.deleteMenu(menuName);
		
		if(deleteResult > 0 ) {
			rv.displayDmlResult("deleteSuccess");
		} else {
			rv.displayDmlResult("deleteFailed");
		}
	}

	public void createNewMenu(Map<String, String> inputMenu) {
		MenuDTO menu = new MenuDTO();
		menu.setMenuName(inputMenu.get("menuName"));
		menu.setMenuPrice(Integer.valueOf(inputMenu.get("menuPrice")));
		menu.setOwnerId(inputMenu.get("ownerId"));
		menu.setOrderableStatus(inputMenu.get("orderableStatus"));
		
		int result = ows.createMenu(menu);
		
		if(result > 0) {
			rv.displayDmlResult("insertSuccess");
		} else {
			rv.displayDmlResult("insertFailed");
		}
	}
}
