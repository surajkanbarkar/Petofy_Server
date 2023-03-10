package com.petofy.DTO;

import org.springframework.web.multipart.MultipartFile;

public class PetNocDetailsDTO {
	private int petNocDetailsId;
	private MultipartFile petPhoto;
	private MultipartFile userSignature;
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
	private int userId;
	private int petsId;
	
	public PetNocDetailsDTO() {}
	
	public PetNocDetailsDTO(int petNocDetailsId, MultipartFile petPhoto, MultipartFile userSignature,
			boolean isSignatureValid, boolean isPetPhotosValid, boolean isUserNocDetailsValid, String insertedAt,
			String updatedAt, String nocApprovalDate, boolean nocApproved, String nocApprovalNote, String nocPdfName,
			String nocPdfPath, int userId, int petsId) {
		super();
		this.petNocDetailsId = petNocDetailsId;
		this.petPhoto = petPhoto;
		this.userSignature = userSignature;
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
		this.userId = userId;
		this.petsId = petsId;
	}
	
	public int getPetNocDetailsId() {
		return petNocDetailsId;
	}

	public void setPetNocDetailsId(int petNocDetailsId) {
		this.petNocDetailsId = petNocDetailsId;
	}

	public MultipartFile getPetPhoto() {
		return petPhoto;
	}

	public void setPetPhoto(MultipartFile petPhoto) {
		this.petPhoto = petPhoto;
	}

	public MultipartFile getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(MultipartFile userSignature) {
		this.userSignature = userSignature;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPetsId() {
		return petsId;
	}

	public void setPetsId(int petsId) {
		this.petsId = petsId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
