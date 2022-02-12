package controller;

import java.util.List;

import model.dto.OwnerDTO;
import service.OwnerService;

public class OwnerController {
	private OwnerService ows = new OwnerService();

	public List<OwnerDTO> selectAllOwner() {
		List<OwnerDTO> ownerList = ows.selectAllOwner();
		
		return ownerList;
	}
	
}
