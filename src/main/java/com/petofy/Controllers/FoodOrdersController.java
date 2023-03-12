package com.petofy.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petofy.DTO.FoodOrderDTO;
import com.petofy.Services.FoodOrdersService;

@CrossOrigin("*")
@RestController
@RequestMapping("/food_orders")
public class FoodOrdersController {

	@Autowired
	private FoodOrdersService foodOrdersService;

	@GetMapping("/all/{userId}")
	public ResponseEntity<?> getAllFoodOrders(@PathVariable("userId") int userId) {
		return ResponseEntity.ok(foodOrdersService.getAllFoodOrders(userId));

	}

	@PostMapping("/food_orders")
	public ResponseEntity<?> addFoodOrders(@RequestBody FoodOrderDTO foodOrder) {
		return ResponseEntity.ok(foodOrdersService.addFoodOrder(foodOrder));
	}

	@DeleteMapping("/food_orders")
	public ResponseEntity<?> cancelFoodOrders(@RequestBody FoodOrderDTO foodOrder) {
		return ResponseEntity.ok(foodOrdersService.deleteFoodOrder(foodOrder.getUserId(), foodOrder.getFoodId()));
	}

	@GetMapping("/userID?={userId}/OrderId?={orderId}")
	public ResponseEntity<?> getFoodByUserIdAndOrderId(@PathVariable("userId") int userId,
			@PathVariable("orderId") int orderId) {
		return ResponseEntity.ok(foodOrdersService.foodOrder(userId, orderId));
	}
}
