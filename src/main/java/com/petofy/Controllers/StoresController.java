package com.petofy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petofy.DTO.Response;
import com.petofy.DTO.StoreInfoDTO;
import com.petofy.Model.StoreInfo;
import com.petofy.Services.StoreInfoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/store")
public class StoresController {
	
	@Autowired
	private StoreInfoService storeInfoService;
	
	@PostMapping("/add")
	private ResponseEntity<?> addStore(@RequestBody StoreInfoDTO storeInfoDTO){
		try {
			boolean result = storeInfoService.addStoreInfo(storeInfoDTO);
			if (result) return Response.success(result, "Store added successfully!");
			return Response.error(result, "Invalid user or store name already exists");
		}catch (Exception e) {
			return Response.error(false, "User store info not exists");
		}
		
	}
	@PutMapping("/update")
	private ResponseEntity<?> updateStore(@RequestBody StoreInfoDTO storeInfoDTO ){
		boolean result = storeInfoService.updateStoreInfo(storeInfoDTO);
		if (result) return Response.success(result, "Store updated successfully!");
		return Response.error(result, "Please check your inputs");
	}
	@DeleteMapping("/delete/{userId}/{storeId}")
	private ResponseEntity<?> deleteStore(@PathVariable("userId") int userId, @PathVariable("storeId") int storeId){
		boolean result = storeInfoService.deleteStoreInfo(userId, storeId);
		if (result) return Response.success(result, "Store deleted successfully!");
		return Response.error(result, "Something went wrong");
	}
	@GetMapping("/get_all_stores/{userId}")
	private ResponseEntity<?> allStores(@PathVariable("userId") int userId){
		List<StoreInfo> result = storeInfoService.getAllStoresList(userId);
		if (!result.isEmpty()) return Response.success(result, "");
		return Response.error(result, "Something went wrong");
	}
	@GetMapping("/get_store/{userId}")
	private ResponseEntity<?> getStore(@PathVariable("userId") int userId){
		StoreInfo result = storeInfoService.getStoreInfoById(userId);
		if (result != null) return Response.success(result, "");
		return Response.error(result, "Something went wrong");
	}
}
