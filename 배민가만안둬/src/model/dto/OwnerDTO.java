package model.dto;

public class OwnerDTO {

	private String ownerId;
	private String ownerPwd;
	
	OwnerDTO() {}

	public OwnerDTO(String ownerId, String ownerPwd) {
		super();
		this.ownerId = ownerId;
		this.ownerPwd = ownerPwd;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerPwd() {
		return ownerPwd;
	}

	public void setOwnerPwd(String ownerPwd) {
		this.ownerPwd = ownerPwd;
	}

	@Override
	public String toString() {
		return "OwnerDTO [ownerId=" + ownerId + ", ownerPwd=" + ownerPwd + "]";
	}
	
}