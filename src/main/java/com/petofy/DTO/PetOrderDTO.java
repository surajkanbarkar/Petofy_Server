package com.petofy.DTO;

public class PetOrderDTO {
	private boolean orderStatus;
	private int petsId;
	
	public PetOrderDTO() {}
	
	public PetOrderDTO(boolean orderStatus, int petsId) {
		super();
		this.orderStatus = orderStatus;
		this.petsId = petsId;
	}
	
	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getPetsId() {
		return petsId;
	}

	public void setPetsId(int petsId) {
		this.petsId = petsId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
