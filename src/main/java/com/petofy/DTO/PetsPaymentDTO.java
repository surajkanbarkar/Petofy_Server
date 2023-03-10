package com.petofy.DTO;

public class PetsPaymentDTO {
	private int petsPaymentId;
    private boolean petsPaymentStatus;
    private String petsPaymentTransactionId;
    private String petsPaymentDatetime;
    private String petsPaymentMode;
    private double petsPaymentAmount;	
    private int storeId;
	private int userId;

	public PetsPaymentDTO() {}
	
	public PetsPaymentDTO(int petsPaymentId, boolean petsPaymentStatus, String petsPaymentTransactionId,
			String petsPaymentDatetime, String petsPaymentMode, double petsPaymentAmount, int storeId, int userId) {
		super();
		this.petsPaymentId = petsPaymentId;
		this.petsPaymentStatus = petsPaymentStatus;
		this.petsPaymentTransactionId = petsPaymentTransactionId;
		this.petsPaymentDatetime = petsPaymentDatetime;
		this.petsPaymentMode = petsPaymentMode;
		this.petsPaymentAmount = petsPaymentAmount;
		this.storeId = storeId;
		this.userId = userId;
	}

	public int getPetsPaymentId() {
		return petsPaymentId;
	}

	public void setPetsPaymentId(int petsPaymentId) {
		this.petsPaymentId = petsPaymentId;
	}

	public boolean isPetsPaymentStatus() {
		return petsPaymentStatus;
	}

	public void setPetsPaymentStatus(boolean petsPaymentStatus) {
		this.petsPaymentStatus = petsPaymentStatus;
	}

	public String getPetsPaymentTransactionId() {
		return petsPaymentTransactionId;
	}

	public void setPetsPaymentTransactionId(String petsPaymentTransactionId) {
		this.petsPaymentTransactionId = petsPaymentTransactionId;
	}

	public String getPetsPaymentDatetime() {
		return petsPaymentDatetime;
	}

	public void setPetsPaymentDatetime(String petsPaymentDatetime) {
		this.petsPaymentDatetime = petsPaymentDatetime;
	}

	public String getPetsPaymentMode() {
		return petsPaymentMode;
	}

	public void setPetsPaymentMode(String petsPaymentMode) {
		this.petsPaymentMode = petsPaymentMode;
	}

	public double getPetsPaymentAmount() {
		return petsPaymentAmount;
	}

	public void setPetsPaymentAmount(double petsPaymentAmount) {
		this.petsPaymentAmount = petsPaymentAmount;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
