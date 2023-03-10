package com.petofy.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class UsersDTO {
	
	private int userId;
	@NotNull(message = "Please enter first name")
	private String firstName;
	@NotNull(message = "Please enter last name")
	private String lastName;
	@NotNull(message = "Please enter mobile")
	@Size(max = 10, min = 10)
	private String mobNo;
	@NotNull(message = "Please enter address")
	private String address;
	@NotNull(message = "Please enter email")
	private String email;
	@NotNull(message = "Please upload image")
	private MultipartFile file;
	@NotNull(message = "Please enter password")
	private String password;
	@NotNull
	private boolean loggedIn;
	@NotNull
	private String insertedAt;
	@NotNull
	private String updatedAt;
	@NotNull(message = "Please select role")
	private String userRole;
	private boolean isUserValid;
	
	public UsersDTO() {}
	
	public UsersDTO(int userId, String firstName, String lastName, String mobNo, String address, String email,
			MultipartFile file, String password, boolean loggedIn, String insertedAt, String updatedAt,
			String userRole, boolean isUserValid) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNo = mobNo;
		this.address = address;
		this.email = email;
		this.file = file;
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
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
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
