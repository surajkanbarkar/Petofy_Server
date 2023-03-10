package com.petofy.Services;

import java.util.List;

import com.petofy.DTO.PetOrderDTO;
import com.petofy.Model.PetOrders;

public interface PetOrdersService {
	boolean addOrder(int userId, PetOrderDTO petOrdersDto);
	boolean deletePetOrder(int userId, int orderId);
	PetOrders petOrder(int userId, int orderId);
	List<PetOrders> getPetOrdersByStoreId(int userId);
	List<PetOrders> getPetOrdersByUserId(int userId);
	List<PetOrders> getAllPetOrders(int userId);
	//boolean deletePetOrder(int userId, int petId);
}
