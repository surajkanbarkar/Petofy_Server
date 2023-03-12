package com.petofy.DTO;

public class FoodPaymentDTO {
	private int FoodPaymentId;
	private boolean FoodPaymentStatus;
	private String FoodPaymentTransactionId;
	private String FoodPaymentDatetime;
	private String FoodPaymentMode;
	private double FoodPaymentAmount;
	private int storeId;
	private int userId;

	public int getFoodPaymentId() {
		return FoodPaymentId;
	}

	public void setFoodPaymentId(int foodPaymentId) {
		FoodPaymentId = foodPaymentId;
	}

	public boolean isFoodPaymentStatus() {
		return FoodPaymentStatus;
	}

	public void setFoodPaymentStatus(boolean foodPaymentStatus) {
		FoodPaymentStatus = foodPaymentStatus;
	}

	public String getFoodPaymentTransactionId() {
		return FoodPaymentTransactionId;
	}

	public void setFoodPaymentTransactionId(String foodPaymentTransactionId) {
		FoodPaymentTransactionId = foodPaymentTransactionId;
	}

	public String getFoodPaymentDatetime() {
		return FoodPaymentDatetime;
	}

	public void setFoodPaymentDatetime(String foodPaymentDatetime) {
		FoodPaymentDatetime = foodPaymentDatetime;
	}

	public String getFoodPaymentMode() {
		return FoodPaymentMode;
	}

	public void setFoodPaymentMode(String foodPaymentMode) {
		FoodPaymentMode = foodPaymentMode;
	}

	public double getFoodPaymentAmount() {
		return FoodPaymentAmount;
	}

	public void setFoodPaymentAmount(double foodPaymentAmount) {
		FoodPaymentAmount = foodPaymentAmount;
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

	public FoodPaymentDTO(int foodPaymentId, boolean foodPaymentStatus, String foodPaymentTransactionId,
			String foodPaymentDatetime, String foodPaymentMode, double foodPaymentAmount, int storeId, int userId) {
		super();
		FoodPaymentId = foodPaymentId;
		FoodPaymentStatus = foodPaymentStatus;
		FoodPaymentTransactionId = foodPaymentTransactionId;
		FoodPaymentDatetime = foodPaymentDatetime;
		FoodPaymentMode = foodPaymentMode;
		FoodPaymentAmount = foodPaymentAmount;
		this.storeId = storeId;
		this.userId = userId;
	}

	public FoodPaymentDTO() {
		super();
	}

}
