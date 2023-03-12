package com.petofy.DTO;

public class FoodOrderDTO {

	int userId;
	private int foodId;
	private int foodPaymentId;

	public FoodOrderDTO(int userId, int foodId, int foodPaymentId) {
		super();
		this.userId = userId;
		this.foodId = foodId;
		this.foodPaymentId = foodPaymentId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getFoodPaymentId() {
		return foodPaymentId;
	}

	public void setFoodPaymentId(int foodPaymentId) {
		this.foodPaymentId = foodPaymentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
