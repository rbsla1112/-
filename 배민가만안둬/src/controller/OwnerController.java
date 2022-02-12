package controller;

import java.util.List;

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
}
