package com.petofy.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pets_payment")
public class PetsPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petsPaymentId;
    private String petsPaymentStatus;
    private String petsPaymentTransactionId;
    private String petsPaymentDatetime;
    private String petsPaymentMode;
    private double petsPaymentAmount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "storeId", nullable = false, updatable = false)
	@JsonIgnore
    private StoreInfo storeInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", nullable = false, updatable = false)
	@JsonIgnore
	private Users users;

	public PetsPayment() {}

	
	public PetsPayment(int petsPaymentId, String petsPaymentStatus, String petsPaymentTransactionId,
			String petsPaymentDatetime, String petsPaymentMode, double petsPaymentAmount, StoreInfo storeInfo,
			Users users) {
		super();
		this.petsPaymentId = petsPaymentId;
		this.petsPaymentStatus = petsPaymentStatus;
		this.petsPaymentTransactionId = petsPaymentTransactionId;
		this.petsPaymentDatetime = petsPaymentDatetime;
		this.petsPaymentMode = petsPaymentMode;
		this.petsPaymentAmount = petsPaymentAmount;
		this.storeInfo = storeInfo;
		this.users = users;
	}


	public int getPetsPaymentId() {
		return petsPaymentId;
	}


	public void setPetsPaymentId(int petsPaymentId) {
		this.petsPaymentId = petsPaymentId;
	}


	public String isPetsPaymentStatus() {
		return petsPaymentStatus;
	}


	public void setPetsPaymentStatus(String petsPaymentStatus) {
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


	public StoreInfo getStoreInfo() {
		return storeInfo;
	}


	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
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
