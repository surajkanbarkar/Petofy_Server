package com.petofy.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.petofy.DTO.PetNocDetailsDTO;
import com.petofy.Model.PetNocDetails;

public interface PetNocDetailsService {
	String requestNoc(MultipartFile petImg, MultipartFile userSignImg, int userId, int petId) throws IOException;
	PetNocDetails getNocById(int userId, int nocId);
	List<PetNocDetails> getAllNocsByUserId(int userId);
	List<PetNocDetails> getAllNocs(int userId);
	String approveNoc(int govUserId, int petUserId, boolean nocApproved, String nocApprovalNote, MultipartFile nocFile, boolean isUserNocDetailsValid, boolean isPetPhotosValid, boolean isSignatureValid, int nocId) throws IOException;
	boolean deleteNoc(int userId, int nocId);
	

	
}
