package com.petofy.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "pets")
public class Pets {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petsId;
	private String petOrigin;
	private String petBreedGroup;
	private String petHeight;
	private String petWeight;
	private String petLifespan;
	private String petBreed;
	private String petTemperament;
	private String petApartmentFriendly;
	private String petPrice;
	private String insertedAt;
	private String updatedAt;
	private String petImgUrl;
	private int petQuantity;
    private boolean petInStock;
    private int petSoldQuantity;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
	private StoreInfo storeInfo;
	
	public Pets() {}
	
	public Pets(int petsId, String petOrigin, String petBreedGroup, String petHeight, String petWeight,
			String petLifespan, String petBreed, String petTemperament, String petApartmentFriendly, String petPrice,
			String insertedAt, String updatedAt, String petImgUrl, int petQuantity, boolean petInStock, int petSoldQuantity,
			StoreInfo storeInfo) {
		super();
		this.petsId = petsId;
		this.petOrigin = petOrigin;
		this.petBreedGroup = petBreedGroup;
		this.petHeight = petHeight;
		this.petWeight = petWeight;
		this.petLifespan = petLifespan;
		this.petBreed = petBreed;
		this.petTemperament = petTemperament;
		this.petApartmentFriendly = petApartmentFriendly;
		this.petPrice = petPrice;
		this.insertedAt = insertedAt;
		this.updatedAt = updatedAt;
		this.petImgUrl = petImgUrl;
		this.petQuantity = petQuantity;
		this.petInStock = petInStock;
		this.petSoldQuantity = petSoldQuantity;
		this.storeInfo = storeInfo;
	}
	
	public int getPetsId() {
		return petsId;
	}

	public void setPetsId(int petsId) {
		this.petsId = petsId;
	}

	public String getPetOrigin() {
		return petOrigin;
	}

	public void setPetOrigin(String petOrigin) {
		this.petOrigin = petOrigin;
	}

	public String getPetBreedGroup() {
		return petBreedGroup;
	}

	public void setPetBreedGroup(String petBreedGroup) {
		this.petBreedGroup = petBreedGroup;
	}

	public String getPetHeight() {
		return petHeight;
	}

	public void setPetHeight(String petHeight) {
		this.petHeight = petHeight;
	}

	public String getPetWeight() {
		return petWeight;
	}

	public void setPetWeight(String petWeight) {
		this.petWeight = petWeight;
	}

	public String getPetLifespan() {
		return petLifespan;
	}

	public void setPetLifespan(String petLifespan) {
		this.petLifespan = petLifespan;
	}

	public String getPetBreed() {
		return petBreed;
	}

	public void setPetBreed(String petBreed) {
		this.petBreed = petBreed;
	}

	public String getPetTemperament() {
		return petTemperament;
	}

	public void setPetTemperament(String petTemperament) {
		this.petTemperament = petTemperament;
	}

	public String getPetApartmentFriendly() {
		return petApartmentFriendly;
	}

	public void setPetApartmentFriendly(String petApartmentFriendly) {
		this.petApartmentFriendly = petApartmentFriendly;
	}

	public String getPetPrice() {
		return petPrice;
	}

	public void setPetPrice(String petPrice) {
		this.petPrice = petPrice;
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

	public int getPetQuantity() {
		return petQuantity;
	}

	public void setPetQuantity(int petQuantity) {
		this.petQuantity = petQuantity;
	}

	public boolean isPetInStock() {
		return petInStock;
	}

	public void setPetInStock(boolean petInStock) {
		this.petInStock = petInStock;
	}

	public int getPetSoldQuantity() {
		return petSoldQuantity;
	}

	public void setPetSoldQuantity(int petSoldQuantity) {
		this.petSoldQuantity = petSoldQuantity;
	}

	public StoreInfo getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}
	
	public String getPetImgUrl() {
		return petImgUrl;
	}

	public void setPetImgUrl(String petImgUrl) {
		this.petImgUrl = petImgUrl;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
