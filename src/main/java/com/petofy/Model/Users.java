package com.petofy.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	private String mobNo;
	private String address;
	private String email;
	private String govIdName;
	private String govIdurl;
	private String password;
	private boolean loggedIn;
	private String insertedAt;
	private String updatedAt;
	private String userRole;
	private boolean isUserValid;
	
	public Users() {}

	public Users(int userId, String firstName, String lastName, String mobNo, String address, String email,
			String govIdName, String govIdurl, String password, boolean loggedIn, String insertedAt, String updatedAt,
			String userRole, boolean isUserValid) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNo = mobNo;
		this.address = address;
		this.email = email;
		this.govIdName = govIdName;
		this.govIdurl = govIdurl;
		this.password = password;
		this.loggedIn = loggedIn;
		this.insertedAt = insertedAt;
		this.updatedAt = updatedAt;
		this.userRole = userRole;
		this.isUserValid = isUserValid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGovIdName() {
		return govIdName;
	}

	public void setGovIdName(String govIdName) {
		this.govIdName = govIdName;
	}

	public String getGovIdurl() {
		return govIdurl;
	}

	public void setGovIdurl(String govIdurl) {
		this.govIdurl = govIdurl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public boolean isUserValid() {
		return isUserValid;
	}

	public void setUserValid(boolean isUserValid) {
		this.isUserValid = isUserValid;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
