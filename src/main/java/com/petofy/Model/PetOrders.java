package com.petofy.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pet_orders")
public class PetOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petsOrderId;
	private boolean orderStatus;
	private String orderInsertedDatetime;
	private String expectedOrderDeliveryDatetime;
	private String orderUpdatedAt;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "petsId")
	@JsonIgnore
	private Pets pets;
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId")
	@JsonIgnore
	private Users user;

	public PetOrders() {}
	
	public PetOrders(int petsOrderId, boolean orderStatus, String orderInsertedDatetime,
			String expectedOrderDeliveryDatetime, String orderUpdatedAt, Pets pets,
			Users user) {
		super();
		this.petsOrderId = petsOrderId;
		this.orderStatus = orderStatus;
		this.orderInsertedDatetime = orderInsertedDatetime;
		this.expectedOrderDeliveryDatetime = expectedOrderDeliveryDatetime;
		this.orderUpdatedAt = orderUpdatedAt;
		this.pets = pets;
		this.user = user;
	}
	
	public int getPetsOrderId() {
		return petsOrderId;
	}

	public void setPetsOrderId(int petsOrderId) {
		this.petsOrderId = petsOrderId;
	}

	public boolean getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderInsertedDatetime() {
		return orderInsertedDatetime;
	}

	public void setOrderInsertedDatetime(String orderInsertedDatetime) {
		this.orderInsertedDatetime = orderInsertedDatetime;
	}

	public String getExpectedOrderDeliveryDatetime() {
		return expectedOrderDeliveryDatetime;
	}

	public void setExpectedOrderDeliveryDatetime(String expectedOrderDeliveryDatetime) {
		this.expectedOrderDeliveryDatetime = expectedOrderDeliveryDatetime;
	}

	public String getOrderUpdatedAt() {
		return orderUpdatedAt;
	}

	public void setOrderUpdatedAt(String orderUpdatedAt) {
		this.orderUpdatedAt = orderUpdatedAt;
	}

	public Pets getPets() {
		return pets;
	}

	public void setPets(Pets pets) {
		this.pets = pets;
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
