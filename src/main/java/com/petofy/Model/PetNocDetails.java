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
@Table(name = "pet_noc_details")
public class PetNocDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petNocDetailsId;
	private String petRecentPhotosUrl;
	private String petRecentPhotosName;
	private String userSignatureUrl;
	private String userSignatureName;
	private boolean isSignatureValid;
	private boolean isPetPhotosValid;
	private boolean isUserNocDetailsValid;
	private String insertedAt;
	private String updatedAt;
	private String nocApprovalDate;
	private boolean nocApproved;
	private String nocApprovalNote;
	private String nocPdfName;
	private String nocPdfPath;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
	private Users users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "petsId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
	private Pets pets;
	
	public PetNocDetails() {}
	
	public PetNocDetails(int petNocDetailsId, String petRecentPhotosUrl, String petRecentPhotosName,
			String userSignatureUrl, String userSignatureName, boolean isSignatureValid, boolean isPetPhotosValid,
			boolean isUserNocDetailsValid, String insertedAt, String updatedAt, String nocApprovalDate,
			boolean nocApproved, String nocApprovalNote, String nocPdfName, String nocPdfPath, Users users, Pets pets) {
		super();
		this.petNocDetailsId = petNocDetailsId;
		this.petRecentPhotosUrl = petRecentPhotosUrl;
		this.petRecentPhotosName = petRecentPhotosName;
		this.userSignatureUrl = userSignatureUrl;
		this.userSignatureName = userSignatureName;
		this.isSignatureValid = isSignatureValid;
		this.isPetPhotosValid = isPetPhotosValid;
		this.isUserNocDetailsValid = isUserNocDetailsValid;
		this.insertedAt = insertedAt;
		this.updatedAt = updatedAt;
		this.nocApprovalDate = nocApprovalDate;
		this.nocApproved = nocApproved;
		this.nocApprovalNote = nocApprovalNote;
		this.nocPdfName = nocPdfName;
		this.nocPdfPath = nocPdfPath;
		this.users = users;
		this.pets = pets;
	}
	
	public int getPetNocDetailsId() {
		return petNocDetailsId;
	}

	public void setPetNocDetailsId(int petNocDetailsId) {
		this.petNocDetailsId = petNocDetailsId;
	}

	public String getPetRecentPhotosUrl() {
		return petRecentPhotosUrl;
	}

	public void setPetRecentPhotosUrl(String petRecentPhotosUrl) {
		this.petRecentPhotosUrl = petRecentPhotosUrl;
	}

	public String getPetRecentPhotosName() {
		return petRecentPhotosName;
	}

	public void setPetRecentPhotosName(String petRecentPhotosName) {
		this.petRecentPhotosName = petRecentPhotosName;
	}

	public String getUserSignatureUrl() {
		return userSignatureUrl;
	}

	public void setUserSignatureUrl(String userSignatureUrl) {
		this.userSignatureUrl = userSignatureUrl;
	}

	public String getUserSignatureName() {
		return userSignatureName;
	}

	public void setUserSignatureName(String userSignatureName) {
		this.userSignatureName = userSignatureName;
	}

	public boolean isSignatureValid() {
		return isSignatureValid;
	}

	public void setSignatureValid(boolean isSignatureValid) {
		this.isSignatureValid = isSignatureValid;
	}

	public boolean isPetPhotosValid() {
		return isPetPhotosValid;
	}

	public void setPetPhotosValid(boolean isPetPhotosValid) {
		this.isPetPhotosValid = isPetPhotosValid;
	}

	public boolean isUserNocDetailsValid() {
		return isUserNocDetailsValid;
	}

	public void setUserNocDetailsValid(boolean isUserNocDetailsValid) {
		this.isUserNocDetailsValid = isUserNocDetailsValid;
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

	public String getNocApprovalDate() {
		return nocApprovalDate;
	}

	public void setNocApprovalDate(String nocApprovalDate) {
		this.nocApprovalDate = nocApprovalDate;
	}

	public boolean isNocApproved() {
		return nocApproved;
	}

	public void setNocApproved(boolean nocApproved) {
		this.nocApproved = nocApproved;
	}

	public String getNocApprovalNote() {
		return nocApprovalNote;
	}

	public void setNocApprovalNote(String nocApprovalNote) {
		this.nocApprovalNote = nocApprovalNote;
	}

	public String getNocPdfName() {
		return nocPdfName;
	}

	public void setNocPdfName(String nocPdfName) {
		this.nocPdfName = nocPdfName;
	}

	public String getNocPdfPath() {
		return nocPdfPath;
	}

	public void setNocPdfPath(String nocPdfPath) {
		this.nocPdfPath = nocPdfPath;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Pets getPets() {
		return pets;
	}

	public void setPets(Pets pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
