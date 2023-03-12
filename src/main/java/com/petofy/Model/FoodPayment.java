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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "food_payment")
public class FoodPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodPaymentId;
	private boolean foodPaymentStatus;
	private String foodPaymentTransactionId;
	private String foodPaymentDatetime;
	private String foodPaymentMode;
	private double foodPaymentAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeId")
	private StoreInfo storeInfo; 

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId")
	@JsonIgnore
	private Users user;
	
	public FoodPayment() {}
	
	public FoodPayment(int foodPaymentId, boolean foodPaymentStatus, String foodPaymentTransactionId,
			String foodPaymentDatetime, String foodPaymentMode, double foodPaymentAmount, StoreInfo storeInfo) {
		super();
		this.foodPaymentId = foodPaymentId;
		this.foodPaymentStatus = foodPaymentStatus;
		this.foodPaymentTransactionId = foodPaymentTransactionId;
		this.foodPaymentDatetime = foodPaymentDatetime;
		this.foodPaymentMode = foodPaymentMode;
		this.foodPaymentAmount = foodPaymentAmount;
		this.storeInfo = storeInfo;
	}
	
	public int getFoodPaymentId() {
		return foodPaymentId;
	}

	public void setFoodPaymentId(int foodPaymentId) {
		this.foodPaymentId = foodPaymentId;
	}

	public boolean isFoodPaymentStatus() {
		return foodPaymentStatus;
	}

	public void setFoodPaymentStatus(boolean foodPaymentStatus) {
		this.foodPaymentStatus = foodPaymentStatus;
	}

	public String getFoodPaymentTransactionId() {
		return foodPaymentTransactionId;
	}

	public void setFoodPaymentTransactionId(String foodPaymentTransactionId) {
		this.foodPaymentTransactionId = foodPaymentTransactionId;
	}

	public String getFoodPaymentDatetime() {
		return foodPaymentDatetime;
	}

	public void setFoodPaymentDatetime(String foodPaymentDatetime) {
		this.foodPaymentDatetime = foodPaymentDatetime;
	}

	public String getFoodPaymentMode() {
		return foodPaymentMode;
	}

	public void setFoodPaymentMode(String foodPaymentMode) {
		this.foodPaymentMode = foodPaymentMode;
	}

	public double getFoodPaymentAmount() {
		return foodPaymentAmount;
	}

	public void setFoodPaymentAmount(double foodPaymentAmount) {
		this.foodPaymentAmount = foodPaymentAmount;
	}

	public StoreInfo getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
