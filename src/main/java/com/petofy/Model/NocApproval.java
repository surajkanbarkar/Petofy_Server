package com.petofy.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "noc_approval")
public class NocApproval {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nocApprovalId;
	private String nocApprovalDate;
	private String nocApproved;
	private String nocApprovalNote;
	private String nocPdfPath;
	private String insertedAt;
	private String updatedAt;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "petNocDetailsId")
	private PetNocDetails petNocDetails;
	
	public NocApproval() {}
	
	public NocApproval(int nocApprovalId, String nocApprovalDate, String nocApproved, String nocApprovalNote,
			String nocPdfPath, String insertedAt, String updatedAt, PetNocDetails petNocDetails) {
		super();
		this.nocApprovalId = nocApprovalId;
		this.nocApprovalDate = nocApprovalDate;
		this.nocApproved = nocApproved;
		this.nocApprovalNote = nocApprovalNote;
		this.nocPdfPath = nocPdfPath;
		this.insertedAt = insertedAt;
		this.updatedAt = updatedAt;
		this.petNocDetails = petNocDetails;
	}
	
	public int getNocApprovalId() {
		return nocApprovalId;
	}

	public void setNocApprovalId(int nocApprovalId) {
		this.nocApprovalId = nocApprovalId;
	}

	public String getNocApprovalDate() {
		return nocApprovalDate;
	}

	public void setNocApprovalDate(String nocApprovalDate) {
		this.nocApprovalDate = nocApprovalDate;
	}

	public String getNocApproved() {
		return nocApproved;
	}

	public void setNocApproved(String nocApproved) {
		this.nocApproved = nocApproved;
	}

	public String getNocApprovalNote() {
		return nocApprovalNote;
	}

	public void setNocApprovalNote(String nocApprovalNote) {
		this.nocApprovalNote = nocApprovalNote;
	}

	public String getNocPdfPath() {
		return nocPdfPath;
	}

	public void setNocPdfPath(String nocPdfPath) {
		this.nocPdfPath = nocPdfPath;
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

	public PetNocDetails getPetNocDetails() {
		return petNocDetails;
	}

	public void setPetNocDetails(PetNocDetails petNocDetails) {
		this.petNocDetails = petNocDetails;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
