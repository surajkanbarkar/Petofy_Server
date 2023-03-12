package com.petofy.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petofy.DTO.FoodOrderDTO;
import com.petofy.Model.FoodOrders;
import com.petofy.Model.FoodPayment;
import com.petofy.Model.PetsFood;
import com.petofy.Model.Users;
import com.petofy.Repository.FoodOrdersRepository;
import com.petofy.Repository.FoodPaymentRepository;
import com.petofy.Repository.PetsFoodRepository;
import com.petofy.Repository.UsersRepository;

@Service
public class FoodOrdersServiceImpl implements FoodOrdersService {

	final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");
	final static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("d/MM/yyyy");

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	private UsersRepository userRepo;

	@Autowired
	private FoodOrdersRepository foodOrdersRepo;

	@Autowired
	private FoodPaymentRepository foodPaymentRepo;

	@Autowired
	private PetsFoodRepository petsFoodRepo;

	@Override
	public Map<String, String> addFoodOrder(FoodOrderDTO foodOrder) {

		// get users
		Users persistUser = userRepo.findById(foodOrder.getUserId()).orElseThrow(() -> new RuntimeException("User Not found !"));

		// get food payment detail
		FoodPayment foodPay = foodPaymentRepo.findById(foodOrder.getFoodPaymentId())
				.orElseThrow(() -> new RuntimeException("Payment Details Not Found !"));

		// get pet foodId
		PetsFood petFood = petsFoodRepo.findById(foodOrder.getFoodId())
				.orElseThrow(() -> new RuntimeException("Pet food details not found !"));

		FoodOrders order = new FoodOrders();

		order.setUser(persistUser);
		order.setFoodPayment(foodPay);
		order.setPetsFood(petFood);
		order.setFoodOrderDatetime(LocalDateTime.now().format(CUSTOM_FORMATTER));
		order.setFoodExpectedOrderDeliveryDatetime(LocalDate
				.of(LocalDate.now().getDayOfMonth() + 5, LocalDate.now().getMonthValue(), LocalDate.now().getYear())
				.format(FORMAT));
		order.setFoodOrderStatus(true);

		foodOrdersRepo.save(order);
		respMap.put("message", "Food Order Successfully");

		return respMap;

	}

	@Override
	public Map<String, String> deleteFoodOrder(int userId, int orderId) {
		// get users
		userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User Not found !"));

		// get food order
		FoodOrders findById = foodOrdersRepo.findById(orderId)
				.orElseThrow(() -> new RuntimeException("Food Order Not found"));

		findById.setFoodOrderStatus(false);
		foodOrdersRepo.save(findById);

		respMap.put("message", "Order Cancelled !");
		return respMap;

	}

	@Override
	public FoodOrders foodOrder(int userId, int orderId) {
		return foodOrdersRepo.getFoodOrderByFoodOrderIdAndUser(orderId, userId);
	}

	@Override
	public List<FoodOrders> getFoodOrderByUserId(int userId) {
		return foodOrdersRepo.findOrdersByUserId(userId);
	}

	@Override
	public List<FoodOrders> getAllFoodOrders(int userId) {
		return foodOrdersRepo.findAll();
	}

}
