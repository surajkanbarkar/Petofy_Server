package com.petofy.Services;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petofy.DTO.PetOrderDTO;
import com.petofy.DTO.UserRoles;
import com.petofy.Model.PetOrders;
import com.petofy.Model.Pets;
import com.petofy.Model.Users;
import com.petofy.Repository.PetOrdersRepository;
import com.petofy.Repository.PetsRepository;
import com.petofy.Repository.UsersRepository;

@Transactional
@Service
public class PetOrdersServiceImpl implements PetOrdersService{

	@Autowired
	private UsersRepository usersRepository;
	
//	@Autowired
//	private StoreInfoRepository storeInfoRepository;
	
	@Autowired
	private PetOrdersRepository petOrdersRepository; 
	
	@Autowired
	private PetsRepository petsRepository;
	
	@Override
	public boolean addOrder(int userId, PetOrderDTO petOrdersDto) {
		Users user = usersRepository.findByUserId(userId);
		Pets pet = petsRepository.findByPetsId(petOrdersDto.getPetsId());
		if (user != null && pet != null && user.getUserRole().equals(UserRoles.CUSTOMER.name())) {
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(currentDate);
	        // Add 6 days to the calendar
	        calendar.add(Calendar.DAY_OF_YEAR, 6);
	        
			PetOrders petOrders = new PetOrders();
			petOrders.setOrderInsertedDatetime(currentDate.toString());
			petOrders.setExpectedOrderDeliveryDatetime(calendar.getTime().toString());
			petOrders.setOrderStatus(true);
			petOrders.setOrderUpdatedAt(currentDate.toString());
			petOrders.setPets(pet);
			petOrders.setUser(user);
			petOrdersRepository.save(petOrders);
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePetOrder(int userId, int orderId) {
		Users user = usersRepository.findByUserId(userId);
		PetOrders petOrder = petOrdersRepository.getOrdersByOrderIdAndUserId(orderId, userId);
		if (user != null && petOrder != null && user.getUserRole().equals(UserRoles.CUSTOMER.name())) {
			petOrdersRepository.deleteByPetsOrderId(orderId);
			return true;
		}
		return false;
	}

	@Override
	public PetOrders petOrder(int userId, int orderId) {
		Users user = usersRepository.findByUserId(userId);
		if (user != null) {
			return petOrdersRepository.findByPetsOrderId(orderId);
		}
		
		return null;
	}

	@Override
	public List<PetOrders> getPetOrdersByStoreId(int userId) {
		Users user = usersRepository.findByUserId(userId);
		if (user != null) {
			return petOrdersRepository.findOrdersByUserId(userId);
		}
		return null;
	}

	@Override
	public List<PetOrders> getPetOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PetOrders> getAllPetOrders(int userId) {
		
		return null;
	}
}
