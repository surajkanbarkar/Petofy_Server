package com.petofy.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "StoreInfo")
public class StoreInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	private String storeName;
	private String storeAddress;
	private String storeContact;
	private String storeType;
	private String insertedAt;
	private String updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	@JsonIgnore
	private Users users;
    
	public StoreInfo() {}

	
	public StoreInfo(int storeId, String storeName, String storeAddress, String storeContact, String storeType,
			String insertedAt, String updatedAt, Users users) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storeContact = storeContact;
		this.storeType = storeType;
		this.insertedAt = insertedAt;
		this.updatedAt = updatedAt;
		this.users = users;
	}


	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}



	public String getStoreName() {
		return storeName;
	}



	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}



	public String getStoreAddress() {
		return storeAddress;
	}



	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}



	public String getStoreContact() {
		return storeContact;
	}



	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}



	public String getStoreType() {
		return storeType;
	}



	public void setStoreType(String storeType) {
		this.storeType = storeType;
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



	public Users getUsers() {
		return users;
	}



	public void setUsers(Users users) {
		this.users = users;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
