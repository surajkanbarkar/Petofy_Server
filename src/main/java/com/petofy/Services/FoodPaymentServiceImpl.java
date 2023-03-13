package com.petofy.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petofy.DTO.FoodPaymentDTO;
import com.petofy.Model.FoodPayment;
import com.petofy.Model.StoreInfo;
import com.petofy.Model.Users;
import com.petofy.Repository.FoodPaymentRepository;
import com.petofy.Repository.StoreInfoRepository;
import com.petofy.Repository.UsersRepository;

@Service
public class FoodPaymentServiceImpl implements FoodPaymentService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private StoreInfoRepository storeInfoRepository;

	@Autowired
	private FoodPaymentRepository foodPaymentRepo;

	Map<String, String> respMap = new HashMap<String, String>();

	@Override
	public Map<String, String> createTransaction(FoodPaymentDTO foodPaymentDTO) {
		Users userInfo = usersRepository.findById(foodPaymentDTO.getUserId())
				.orElseThrow(() -> new RuntimeException("User id not valid !"));
		StoreInfo foodStore = storeInfoRepository.findById(foodPaymentDTO.getUserId())
				.orElseThrow(() -> new RuntimeException("Store id not valid !"));

		FoodPayment foodPayment = new FoodPayment();
		foodPayment.setStoreInfo(foodStore);
		foodPayment.setUser(userInfo);
		foodPayment.setFoodPaymentAmount(foodPaymentDTO.getFoodPaymentAmount());
		foodPayment.setFoodPaymentDatetime(foodPaymentDTO.getFoodPaymentDatetime());
		foodPayment.setFoodPaymentStatus(foodPaymentDTO.isFoodPaymentStatus());
		foodPayment.setFoodPaymentMode(foodPaymentDTO.getFoodPaymentMode());
		foodPayment.setFoodPaymentTransactionId(foodPaymentDTO.getFoodPaymentTransactionId());

		foodPaymentRepo.save(foodPayment);

		respMap.put("message", "Food Payment Transaction done !");
		return respMap;

	}

	@Override
	public FoodPayment getAllFoodPaymentStatus(String transId) {
		return foodPaymentRepo.findByFoodPaymentTransactionId(transId);
	}

	@Override
	public Map<String, String> updateTransactionStatus(FoodPaymentDTO foodPaymentDTO) {
		FoodPayment foodPayment = foodPaymentRepo
				.findByFoodPaymentTransactionId(foodPaymentDTO.getFoodPaymentTransactionId());
		foodPayment.setFoodPaymentAmount(foodPaymentDTO.getFoodPaymentAmount());
		foodPayment.setFoodPaymentDatetime(foodPaymentDTO.getFoodPaymentDatetime());
		foodPayment.setFoodPaymentStatus(foodPaymentDTO.isFoodPaymentStatus());
		foodPayment.setFoodPaymentMode(foodPaymentDTO.getFoodPaymentMode());
		foodPayment.setFoodPaymentTransactionId(foodPaymentDTO.getFoodPaymentTransactionId());

		foodPaymentRepo.save(foodPayment);
		respMap.put("message", "Food Payment Transaction updated !");
		return respMap;
	}

	@Override
	public List<FoodPayment> getAllfoodPaymentsByUserId(int userId) {
		return foodPaymentRepo.findAllPaymentsByUserId(userId);
	}

	@Override
	public List<FoodPayment> getAllfoodPaymentsByStoreId(int storeId) {
		return foodPaymentRepo.findAllPaymentsByStoreId(storeId);
	}

}
