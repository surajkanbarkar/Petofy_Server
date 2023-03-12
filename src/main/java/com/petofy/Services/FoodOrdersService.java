package com.petofy.Services;

import java.util.List;
import java.util.Map;

import com.petofy.DTO.FoodOrderDTO;
import com.petofy.Model.FoodOrders;

public interface FoodOrdersService {
	Map<String, String> addFoodOrder(FoodOrderDTO foodOrder);

	Map<String, String> deleteFoodOrder(int userId, int orderId);

	FoodOrders foodOrder(int userId, int orderId);

	List<FoodOrders> getFoodOrderByUserId(int userId);

	List<FoodOrders> getAllFoodOrders(int userId);
}
