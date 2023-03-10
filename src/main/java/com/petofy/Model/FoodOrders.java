package com.petofy.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "food_orders")
public class FoodOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodOrderId;
	private boolean foodOrderStatus;
	private String foodOrderDatetime;
	private String foodExpectedOrderDeliveryDatetime;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foodPaymentId")
	private FoodPayment foodPayment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "foodId")
	private PetsFood petsFood;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private Users user;

	public int getFoodOrderId() {
		return foodOrderId;
	}

	public void setFoodOrderId(int foodOrderId) {
		this.foodOrderId = foodOrderId;
	}

	public boolean isFoodOrderStatus() {
		return foodOrderStatus;
	}

	public void setFoodOrderStatus(boolean foodOrderStatus) {
		this.foodOrderStatus = foodOrderStatus;
	}

	public String getFoodOrderDatetime() {
		return foodOrderDatetime;
	}

	public void setFoodOrderDatetime(String foodOrderDatetime) {
		this.foodOrderDatetime = foodOrderDatetime;
	}

	public String getFoodExpectedOrderDeliveryDatetime() {
		return foodExpectedOrderDeliveryDatetime;
	}

	public void setFoodExpectedOrderDeliveryDatetime(String foodExpectedOrderDeliveryDatetime) {
		this.foodExpectedOrderDeliveryDatetime = foodExpectedOrderDeliveryDatetime;
	}

	public FoodPayment getFoodPayment() {
		return foodPayment;
	}

	public void setFoodPayment(FoodPayment foodPayment) {
		this.foodPayment = foodPayment;
	}

	public PetsFood getPetsFood() {
		return petsFood;
	}

	public void setPetsFood(PetsFood petsFood) {
		this.petsFood = petsFood;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
