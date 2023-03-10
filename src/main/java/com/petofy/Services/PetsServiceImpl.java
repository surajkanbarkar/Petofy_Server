package com.petofy.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.petofy.DTO.PetsDTO;
import com.petofy.DTO.UserRoles;
import com.petofy.Model.Pets;
import com.petofy.Model.StoreInfo;
import com.petofy.Model.Users;
import com.petofy.Repository.PetsRepository;
import com.petofy.Repository.StoreInfoRepository;
import com.petofy.Repository.UsersRepository;

@Service
public class PetsServiceImpl implements PetsService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PetsRepository petsRepository;
	
	@Autowired
	private StoreInfoRepository storeInfoRepository;
	
	@Autowired
	private FilesStorageService storageService;
	
	@Override
	public boolean addPet(PetsDTO petsDTO, int userId, int storeId) {
		Users user = usersRepository.findByUserId(userId);
		StoreInfo storeInfo = storeInfoRepository.findByStoreId(storeId);
		Resource file = storageService.load(Integer.toString(userId), petsDTO.getFile().getOriginalFilename());
		if (file.exists())
			storageService.delete(Integer.toString(userId), petsDTO.getFile().getOriginalFilename());
		if (user != null && storeInfo != null && user.getUserRole().equals(UserRoles.STOREOWNER.name())) {
			storageService.save(petsDTO.getFile(), Integer.toString(userId));
			Pets pet = new Pets();
			pet.setPetHeight(petsDTO.getPetHeight());
			pet.setPetWeight(petsDTO.getPetWeight());
			pet.setPetBreedGroup(petsDTO.getPetBreedGroup());
			pet.setPetBreed(petsDTO.getPetBreed());
			pet.setPetApartmentFriendly(petsDTO.getPetApartmentFriendly());
			pet.setPetInStock(true);
			pet.setPetTemperament(petsDTO.getPetTemperament());
			pet.setPetOrigin(petsDTO.getPetOrigin());
			pet.setPetLifespan(petsDTO.getPetLifespan());
			pet.setPetPrice(petsDTO.getPetPrice());
			pet.setPetQuantity(petsDTO.getPetQuantity());
			pet.setPetSoldQuantity(0);
			pet.setStoreInfo(storeInfo);
			pet.setInsertedAt(new Date().toString());
			pet.setUpdatedAt(new Date().toString());
			pet.setPetImgUrl(petsDTO.getFile().getOriginalFilename());
			petsRepository.save(pet);
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePet(PetsDTO petsDTO) {
		Pets pet = petsRepository.findByPetIdAndStoreId(petsDTO.getPetsId(), petsDTO.getStoreId());
		if (pet != null) {
			pet.setPetHeight(petsDTO.getPetHeight());
			pet.setPetWeight(petsDTO.getPetWeight());
			pet.setPetBreedGroup(petsDTO.getPetBreedGroup());
			pet.setPetBreed(petsDTO.getPetBreed());
			pet.setPetApartmentFriendly(petsDTO.getPetApartmentFriendly());
			pet.setPetInStock(petsDTO.isPetInStock());
			pet.setPetTemperament(petsDTO.getPetTemperament());
			pet.setPetOrigin(petsDTO.getPetOrigin());
			pet.setPetLifespan(petsDTO.getPetLifespan());
			pet.setPetPrice(petsDTO.getPetPrice());
			pet.setPetQuantity(petsDTO.getPetQuantity());
			pet.setPetSoldQuantity(petsDTO.getPetSoldQuantity());
			pet.setUpdatedAt(new Date().toString());
			petsRepository.save(pet);
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePetInfo(int storeId, int petId) {
		Pets pet = petsRepository.findByPetIdAndStoreId(storeId, petId);
		StoreInfo store = storeInfoRepository.findByStoreId(storeId);
		if (pet != null) {
			storageService.delete(Integer.toString(store.getUsers().getUserId()), pet.getPetImgUrl());
			petsRepository.delete(pet);
			return true;
		}
		return false;
	}

	@Override
	public Pets getPetInfoById(int petId) {
		return petsRepository.findByPetsId(petId);
	}

	@Override
	public List<Pets> getAllPetsList(int userId) {
		return petsRepository.findAll();
	}

	@Override
	public List<Pets> getAllPetsListBySearch(int userId, String searchKey) {
		return petsRepository.searchPets(searchKey);
	}

	@Override
	public List<Pets> getAllPetsBySearch(int userId, String searchKey) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
