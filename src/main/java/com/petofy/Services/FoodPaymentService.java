package com.petofy.Services;

import java.util.List;
import java.util.Map;

import com.petofy.DTO.FoodPaymentDTO;
import com.petofy.Model.FoodPayment;

public interface FoodPaymentService {
	Map<String, String> createTransaction(FoodPaymentDTO foodPaymentDTO);

	FoodPayment getAllFoodPaymentStatus(String transId);

	List<FoodPayment> getAllfoodPaymentsByUserId(int userId);

	List<FoodPayment> getAllfoodPaymentsByStoreId(int storeId);

	Map<String, String> updateTransactionStatus(FoodPaymentDTO foodPaymentDTO);
}
