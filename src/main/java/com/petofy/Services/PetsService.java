package com.petofy.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.petofy.DTO.PetsDTO;
import com.petofy.Model.Pets;
import com.petofy.Model.StoreInfo;

public interface PetsService {
	boolean addPet(PetsDTO petsDTO, int userId, int storeId) throws IOException;
	boolean updatePet(PetsDTO petsDTO);
	boolean deletePetInfo(int storeId, int petId);
	Pets getPetInfoById(int petId);
	List<Pets> getAllPetsList(int userId);
	List<Pets> getAllPetsListBySearch(int userId, String searchKey);
	List<Pets> getAllPetsBySearch(int userId, String searchKey);
	Resource getPetImage(String userId, String imageName);
}
