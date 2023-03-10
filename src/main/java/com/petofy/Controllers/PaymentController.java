package com.petofy.Controllers;

import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petofy.DTO.PetsPaymentDTO;
import com.petofy.DTO.Response;
import com.petofy.Model.PetsPayment;
import com.petofy.Services.PetsPaymentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/pets_payment")
public class PaymentController {
	
	@Autowired
	private PetsPaymentService petsPaymentService;
	
	@PostMapping("/buy")
	private ResponseEntity<?> buyPet(@RequestBody PetsPaymentDTO petsPaymentDTO){
		boolean result = petsPaymentService.createTransaction(petsPaymentDTO);
		if (result) return Response.success(result, "Payment successfull!"); 
		return Response.error(result, "Payment failed");
	}
	
	@GetMapping("/{userId}/{transId}")
	private ResponseEntity<?> getPaymentStatus(@PathVariable("userId") int userId, @PathVariable("transId") String transId){
		PetsPayment result = petsPaymentService.getAllPetsPaymentStatus(userId, transId);
		if (result != null) {
			return Response.success(result, null);
		}
		return Response.error(result, null);
	}
	@GetMapping("/user/{userId}")
	private ResponseEntity<?> getAllPaymentsForUser(@PathVariable("userId") int userId){
		List<PetsPayment> result = petsPaymentService.getAllPetsPaymentsByUserId(userId);
		if (!result.isEmpty()) {
			return Response.success(result, "");
		}
		return Response.error(result, "No records found");
	}
	@GetMapping("/store/{storeId}")
	private ResponseEntity<?> getAllPaymentsForStore(@PathVariable("storeId") int storeId){
		List<PetsPayment> result = petsPaymentService.getAllPetsPaymentsByStoreId(storeId);
		if (!result.isEmpty()) {
			return Response.success(result, "");
		}
		return Response.error(result, "No records found");
	}
	
	@PutMapping("/update")
	private ResponseEntity<?> updateTransStatus(@RequestBody HashMap<String, Object> map){
		boolean result = petsPaymentService.updateTransactionStatus(map);
		if (result) {
			return Response.success(result, "Payment status updated successfully");
		}
		return Response.error(result, "Error while updating payment status");
	}
}
