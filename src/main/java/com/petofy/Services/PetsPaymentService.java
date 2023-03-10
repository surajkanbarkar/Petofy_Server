package com.petofy.Services;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.petofy.DTO.PetsPaymentDTO;
import com.petofy.Model.PetsPayment;

public interface PetsPaymentService {
	boolean createTransaction(PetsPaymentDTO petsPaymentDTO);
	PetsPayment getAllPetsPaymentStatus(int userId, String transId);
	boolean updateTransactionStatus(HashMap<String, Object> map);
	List<PetsPayment> getAllPetsPaymentsByUserId(int userId);
	List<PetsPayment> getAllPetsPaymentsByStoreId(int storeId);
	
}
