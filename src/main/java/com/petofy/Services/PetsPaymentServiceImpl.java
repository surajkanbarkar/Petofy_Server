package com.petofy.Services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petofy.DTO.PetsPaymentDTO;
import com.petofy.DTO.UserRoles;
import com.petofy.Model.PetsPayment;
import com.petofy.Model.StoreInfo;
import com.petofy.Model.Users;
import com.petofy.Repository.PetsPaymentRepository;
import com.petofy.Repository.StoreInfoRepository;
import com.petofy.Repository.UsersRepository;

@Service
public class PetsPaymentServiceImpl implements PetsPaymentService{

	@Autowired
	private PetsPaymentRepository petsPaymentRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private StoreInfoRepository storeInfoRepository;
	
	@Override
	public boolean createTransaction(PetsPaymentDTO petsPaymentDTO) {
		Users user = usersRepository.findByUserId(petsPaymentDTO.getUserId());
		StoreInfo store = storeInfoRepository.getByStoreId(petsPaymentDTO.getStoreId());
		if (user != null && user.getUserRole().equals(UserRoles.CUSTOMER.name()) && store != null) {
			
			PetsPayment petsPayment = new PetsPayment();
			petsPayment.setPetsPaymentAmount(petsPaymentDTO.getPetsPaymentAmount());
			petsPayment.setPetsPaymentDatetime(new Date().toString());
			petsPayment.setPetsPaymentMode(petsPaymentDTO.getPetsPaymentMode());
			petsPayment.setPetsPaymentStatus("PENDING");
			petsPayment.setPetsPaymentTransactionId(UUID.randomUUID().toString());
			petsPayment.setStoreInfo(store);
			petsPayment.setUsers(user);
			petsPaymentRepository.save(petsPayment);
			return true;
		}
		return false;
	}

	@Override
	public PetsPayment getAllPetsPaymentStatus(int userId, String transId) {
		if (usersRepository.findByUserId(userId) != null) {
			return petsPaymentRepository.findByPetsPaymentTransactionId(transId);
		}
		return null;
	}

	@Override
	public boolean updateTransactionStatus(HashMap<String, Object> map) {
		Users user = usersRepository.findByUserId(Integer.parseInt(map.get("userId").toString()));
		if (user != null && user.getUserRole().equals(UserRoles.STOREOWNER.name())) {
			PetsPayment petsPayment= petsPaymentRepository.findByPetsPaymentTransactionId(map.get("transId").toString());
			petsPayment.setPetsPaymentStatus(map.get("transStatus").toString());
			petsPaymentRepository.save(petsPayment);
			return true;
		}
		return false;
	}

	@Override
	public List<PetsPayment> getAllPetsPaymentsByUserId(int userId) {
		return petsPaymentRepository.findAllPaymentsByUserId(userId);
	}

	@Override
	public List<PetsPayment> getAllPetsPaymentsByStoreId(int storeId) {
		return petsPaymentRepository.findAllPaymentsByStoreId(storeId);
	}

}
