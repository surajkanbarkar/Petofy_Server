package com.petofy.Services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.petofy.DTO.PetNocDetailsDTO;
import com.petofy.DTO.UserRoles;
import com.petofy.Model.PetNocDetails;
import com.petofy.Model.Pets;
import com.petofy.Model.Users;
import com.petofy.Repository.PetNocDetailsRepository;
import com.petofy.Repository.PetsRepository;
import com.petofy.Repository.UsersRepository;

@Transactional
@Service
public class PetNocDetailsServiceImpl implements PetNocDetailsService{

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	PetsRepository petsRepository;
	
	@Autowired
	PetNocDetailsRepository petsNocDetailsRepository;
	
	@Autowired
	FilesStorageService storageService;
	
	@Override
	public String requestNoc(MultipartFile petImg, MultipartFile userSignImg, int userId, int petId) throws IOException {
		Users user =  usersRepository.findByUserId(userId);
		Pets pet = petsRepository.findByPetsId(petId);
		try {
			PetNocDetails oldObj = petsNocDetailsRepository.findByPetsIdUserId(petId, userId);
			if (oldObj != null)
				return "Request already raised";
			if (user.getUserRole().equals(UserRoles.CUSTOMER.name()) || user.getUserRole().equals(UserRoles.STOREOWNER.name()) || user.getUserRole().equals(UserRoles.GOVUSER.name())) {
				PetNocDetails petsNocDetails = new PetNocDetails();
				petsNocDetails.setSignatureValid(false);
				petsNocDetails.setPetPhotosValid(false);	
				petsNocDetails.setUserNocDetailsValid(false);
				petsNocDetails.setInsertedAt(new Date().toString());
				petsNocDetails.setUpdatedAt(new Date().toString());
				petsNocDetails.setNocApprovalDate(null);
				petsNocDetails.setNocApproved(false);
				petsNocDetails.setNocApprovalNote(null);
				petsNocDetails.setNocPdfName(null);
				petsNocDetails.setNocPdfPath(null);
				
				petsNocDetails.setUsers(user);
				petsNocDetails.setPets(pet);
				PetNocDetails petsObj = petsNocDetailsRepository.save(petsNocDetails);
				
				storageService.delete(Integer.toString(userId), petImg.getOriginalFilename());
				storageService.delete(Integer.toString(userId), userSignImg.getOriginalFilename());
				
//				if (petImgFile.exists())
//					storageService.delete(Integer.toString(userId), petImgFile.getFilename());
//					//return "Error while uploading pet image";
//				if (userSignFile.exists())
//					//return "Error while uploading signature";
//					storageService.delete(Integer.toString(userId), userSignFile.getFilename());
				
				storageService.save(petImg, Integer.toString(userId));
				storageService.save(userSignImg, Integer.toString(userId));
				Resource petImgFile = storageService.load(Integer.toString(userId), petImg.getOriginalFilename());
				Resource userSignFile = storageService.load(Integer.toString(userId), userSignImg.getOriginalFilename());
				petsObj.setPetRecentPhotosUrl(petImgFile.getURL().toString());
				petsObj.setPetRecentPhotosName(petImgFile.getFilename());
				petsObj.setUserSignatureUrl(userSignFile.getURL().toString());
				petsObj.setUserSignatureName(userSignFile.getFilename());
				petsNocDetailsRepository.save(petsObj);
				return "Noc request created successful";
			}
		}catch (MultipartException e) {
			return "Image size must be less than 2 MB";
		}
		return "Error while creating NOC request";
	}

	@Override
	public PetNocDetails getNocById(int userId, int nocId) {
		Users user =  usersRepository.findByUserId(userId);
		if (user.getUserRole().equals(UserRoles.CUSTOMER.name()) || user.getUserRole().equals(UserRoles.GOVUSER.name()))
			return petsNocDetailsRepository.findByPetNocDetailsId(nocId);
		return null;
	}

	@Override
	public List<PetNocDetails> getAllNocsByUserId(int userId) {
		Users user =  usersRepository.findByUserId(userId);
		List<PetNocDetails> pnd = petsNocDetailsRepository.findByUserId(userId);
		if (pnd != null && user.getUserRole().equals(UserRoles.CUSTOMER.name()))
			return petsNocDetailsRepository.findByUserId(userId);
		return null;
	}
	@Override
	public List<PetNocDetails> getAllNocs(int userId) {
		Users user =  usersRepository.findByUserId(userId);
		List<PetNocDetails> pnd = petsNocDetailsRepository.findAll();
		if (pnd != null && user.getUserRole().equals(UserRoles.GOVUSER.name()))
			return pnd;
		return null;
	}
	@Override
	public boolean deleteNoc(int userId, int nocId) {
		Users user =  usersRepository.findByUserId(userId);
		if (user.getUserRole().equals(UserRoles.CUSTOMER.name()) || user.getUserRole().equals(UserRoles.GOVUSER.name()))
		{
			PetNocDetails nocDetails = petsNocDetailsRepository.findByPetNocDetailsId(nocId);
			if (nocDetails != null) {
				storageService.delete(Integer.toString(userId), nocDetails.getPetRecentPhotosName());
				storageService.delete(Integer.toString(userId), nocDetails.getUserSignatureName());
				storageService.delete(Integer.toString(userId), nocDetails.getNocPdfName());
				petsNocDetailsRepository.delete(nocDetails);
				return true;
			}
		}
		return false;
	}

	@Override
	public String approveNoc(int govUserId, int petUserId, boolean nocApproved, String nocApprovalNote, MultipartFile nocFile,
			boolean isUserNocDetailsValid, boolean isPetPhotosValid, boolean isSignatureValid, int nocId) throws IOException {
		Users user =  usersRepository.findByUserId(govUserId);
		if (user.getUserRole().equals(UserRoles.GOVUSER.name()))
		{
			try {
				PetNocDetails nocDetails = petsNocDetailsRepository.findByPetNocDetailsId(nocId);
				if (nocDetails != null) {
					storageService.delete(Integer.toString(petUserId), nocDetails.getNocPdfName());
					if (nocApproved) {
						storageService.save(nocFile, Integer.toString(petUserId));
						Resource file = storageService.load(Integer.toString(petUserId), nocFile.getOriginalFilename());
						if (file.exists())
							nocDetails.setNocPdfName(file.getFilename());
							nocDetails.setNocPdfPath(file.getURL().toString());
							nocDetails.setNocApproved(nocApproved);
							nocDetails.setNocApprovalNote(nocApprovalNote);
							nocDetails.setUserNocDetailsValid(isUserNocDetailsValid);
							nocDetails.setPetPhotosValid(isPetPhotosValid);
							nocDetails.setSignatureValid(isSignatureValid);
							petsNocDetailsRepository.save(nocDetails);
							return "NOC approved";
					}else {
						nocDetails.setNocApproved(nocApproved);
						nocDetails.setNocApprovalNote(nocApprovalNote);
						nocDetails.setUserNocDetailsValid(isUserNocDetailsValid);
						nocDetails.setPetPhotosValid(isPetPhotosValid);
						nocDetails.setSignatureValid(isSignatureValid);
						petsNocDetailsRepository.save(nocDetails);
						return "NOC not approved"; 
					}
				}
			}catch (MultipartException e) {
				return "Image size must be less than 2 MB";
			}
		}
		return "NOC not approved";
	}

}
