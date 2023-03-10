package com.petofy.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pets_food")
public class PetsFood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodId;
	private String foodTitle;
	private String foodDesciption;
	private String foodBrand;
	private String foodFlavour;
	private String foodImages;
	private double foodPrice;
	private String foodTargetedSpecies;
	private String foodDietType;
	private String foodPetAgeRange;
	private String foodForm;
	private String foodUse;
	private int foodNetQuantity;
	private String foodCountryOfOrigin;
	private int foodQuantity;
	private String insertedAt;
	private String updatedAt;
	private int foodSoldQuantity;
	private boolean foodInStock;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeId")
	private StoreInfo storeInfo;
	
	public PetsFood() {}
	
	public PetsFood(int foodId, String foodTitle, String foodDesciption, String foodBrand, String foodFlavour,
			String foodImages, double foodPrice, String foodTargetedSpecies, String foodDietType,
			String foodPetAgeRange, String foodForm, String foodUse, int foodNetQuantity, String foodCountryOfOrigin,
			int foodQuantity, String insertedAt, String updatedAt, int foodSoldQuantity, boolean foodInStock,
			StoreInfo storeInfo) {
		super();
		this.foodId = foodId;
		this.foodTitle = foodTitle;
		this.foodDesciption = foodDesciption;
		this.foodBrand = foodBrand;
		this.foodFlavour = foodFlavour;
		this.foodImages = foodImages;
		this.foodPrice = foodPrice;
		this.foodTargetedSpecies = foodTargetedSpecies;
		this.foodDietType = foodDietType;
		this.foodPetAgeRange = foodPetAgeRange;
		this.foodForm = foodForm;
		this.foodUse = foodUse;
		this.foodNetQuantity = foodNetQuantity;
		this.foodCountryOfOrigin = foodCountryOfOrigin;
		this.foodQuantity = foodQuantity;
		this.insertedAt = insertedAt;
		this.updatedAt = updatedAt;
		this.foodSoldQuantity = foodSoldQuantity;
		this.foodInStock = foodInStock;
		this.storeInfo = storeInfo;
	}
	
	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodTitle() {
		return foodTitle;
	}

	public void setFoodTitle(String foodTitle) {
		this.foodTitle = foodTitle;
	}

	public String getFoodDesciption() {
		return foodDesciption;
	}

	public void setFoodDesciption(String foodDesciption) {
		this.foodDesciption = foodDesciption;
	}

	public String getFoodBrand() {
		return foodBrand;
	}

	public void setFoodBrand(String foodBrand) {
		this.foodBrand = foodBrand;
	}

	public String getFoodFlavour() {
		return foodFlavour;
	}

	public void setFoodFlavour(String foodFlavour) {
		this.foodFlavour = foodFlavour;
	}

	public String getFoodImages() {
		return foodImages;
	}

	public void setFoodImages(String foodImages) {
		this.foodImages = foodImages;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodTargetedSpecies() {
		return foodTargetedSpecies;
	}

	public void setFoodTargetedSpecies(String foodTargetedSpecies) {
		this.foodTargetedSpecies = foodTargetedSpecies;
	}

	public String getFoodDietType() {
		return foodDietType;
	}

	public void setFoodDietType(String foodDietType) {
		this.foodDietType = foodDietType;
	}

	public String getFoodPetAgeRange() {
		return foodPetAgeRange;
	}

	public void setFoodPetAgeRange(String foodPetAgeRange) {
		this.foodPetAgeRange = foodPetAgeRange;
	}

	public String getFoodForm() {
		return foodForm;
	}

	public void setFoodForm(String foodForm) {
		this.foodForm = foodForm;
	}

	public String getFoodUse() {
		return foodUse;
	}

	public void setFoodUse(String foodUse) {
		this.foodUse = foodUse;
	}

	public int getFoodNetQuantity() {
		return foodNetQuantity;
	}

	public void setFoodNetQuantity(int foodNetQuantity) {
		this.foodNetQuantity = foodNetQuantity;
	}

	public String getFoodCountryOfOrigin() {
		return foodCountryOfOrigin;
	}

	public void setFoodCountryOfOrigin(String foodCountryOfOrigin) {
		this.foodCountryOfOrigin = foodCountryOfOrigin;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public String getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(String insertedAt) {
		this.insertedAt = insertedAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getFoodSoldQuantity() {
		return foodSoldQuantity;
	}

	public void setFoodSoldQuantity(int foodSoldQuantity) {
		this.foodSoldQuantity = foodSoldQuantity;
	}

	public boolean isFoodInStock() {
		return foodInStock;
	}

	public void setFoodInStock(boolean foodInStock) {
		this.foodInStock = foodInStock;
	}

	public StoreInfo getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
