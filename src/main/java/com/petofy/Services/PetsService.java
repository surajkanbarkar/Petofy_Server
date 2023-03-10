package com.petofy.Services;

import java.util.List;

import com.petofy.DTO.PetsDTO;
import com.petofy.Model.Pets;
import com.petofy.Model.StoreInfo;

public interface PetsService {
	boolean addPet(PetsDTO petsDTO, int userId, int storeId);
	boolean updatePet(PetsDTO petsDTO);
	boolean deletePetInfo(int storeId, int petId);
	Pets getPetInfoById(int petId);
	List<Pets> getAllPetsList(int userId);
	List<Pets> getAllPetsListBySearch(int userId, String searchKey);
	List<Pets> getAllPetsBySearch(int userId, String searchKey);
}
