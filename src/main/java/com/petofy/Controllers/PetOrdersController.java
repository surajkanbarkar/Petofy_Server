package com.petofy.Controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petofy.DTO.PetOrderDTO;
import com.petofy.DTO.Response;
import com.petofy.Model.PetOrders;
import com.petofy.Services.PetOrdersService;

@CrossOrigin("*")
@RestController
@RequestMapping("/pet_orders")
public class PetOrdersController {

	@Autowired
	private PetOrdersService petOrdersService;
	
	@PostMapping("/add/{userId}")
	private ResponseEntity<?> createPetOrder(@RequestBody PetOrderDTO petOrderDTO, @PathVariable("userId") int userId){
		boolean result = petOrdersService.addOrder(userId, petOrderDTO);
		if (result) return Response.success(result, "Pet order placed");
		return Response.error(result, "Something went wrong");
	}
	@GetMapping("/{userId}/{orderId}")
	private ResponseEntity<?> getPetOrder(@PathVariable("userId") int userId, @PathVariable("orderId") int orderId){
		PetOrders result = petOrdersService.petOrder(userId, orderId);
		if (result != null) return Response.success(result, "");
		return Response.error(result, "Something went wrong");
	}
	@DeleteMapping("/delete/{userId}/{orderId}")
	private ResponseEntity<?> deletePetOrder(@PathVariable("userId") int userId, @PathVariable("orderId") int orderId){
		boolean result = petOrdersService.deletePetOrder(userId, orderId);
		if (result) return Response.success(result, "Order deleted successfully!");
		return Response.error(result, "Something went wrong");
	}
	@GetMapping("/all_orders/{userId}")
	private ResponseEntity<?> getPetOrdersByUserId(@PathVariable("userId") int userId){
		List<PetOrders> result = petOrdersService.getPetOrdersByUserId(userId);
		if (!result.isEmpty()) return Response.success(result, "");
		return Response.error(result, "No records found");
	}
}
