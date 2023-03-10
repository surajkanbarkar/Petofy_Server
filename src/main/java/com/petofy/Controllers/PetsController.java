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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.petofy.DTO.PetsDTO;
import com.petofy.DTO.Response;
import com.petofy.Model.Pets;
import com.petofy.Services.PetsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/pets")
public class PetsController {
	
	@Autowired
	private PetsService petsService;
	
	@PostMapping("/add/{userId}/{storeId}") 
	private ResponseEntity<?> addPetInfo(@PathVariable("userId") int userid, @PathVariable("storeId") int storeid, 
			@RequestParam String petOrigin,@RequestParam String petBreedGroup, @RequestParam String petHeight,
			@RequestParam String petWeight,@RequestParam String petLifespan, @RequestParam String petBreed,
			@RequestParam String petTemperament,@RequestParam String petApartmentFriendly, @RequestParam String petPrice,
			@RequestParam int petQuantity, @RequestParam("file") MultipartFile file){
		
		PetsDTO petsDTO = new PetsDTO();
		petsDTO.setPetOrigin(petOrigin); petsDTO.setPetBreed(petBreed);petsDTO.setPetBreedGroup(petBreedGroup);
		petsDTO.setPetHeight(petHeight); petsDTO.setPetWeight(petWeight); petsDTO.setPetLifespan(petLifespan);
		petsDTO.setPetTemperament(petTemperament); petsDTO.setPetApartmentFriendly(petApartmentFriendly);
		petsDTO.setPetPrice(petPrice); petsDTO.setPetQuantity(petQuantity);petsDTO.setFile(file);
		
		boolean result = petsService.addPet(petsDTO, userid, storeid);
		if (result) return Response.success(result, "Pet Information added successfully");
		return Response.error(result, "Something went wrong");
	}
	
	@PutMapping("/update")
	private ResponseEntity<?> updatePetInfo(@RequestBody PetsDTO petsDTO){
		boolean result = petsService.updatePet(petsDTO);
		if (result) return Response.success(result, "Pet Information updated successfully");
		return Response.error(result, "Something went wrong");
	}
	
	@DeleteMapping("/delete/{storeId}/{petId}")
	private ResponseEntity<?> updatePetInfo(@PathVariable("storeId") int storeId, @PathVariable("petId") int petId){
		boolean result = petsService.deletePetInfo(storeId, petId);
		if (result) return Response.success(result, "Pet Information deleted successfully");
		return Response.error(result, "Something went wrong");
	}
	
	@GetMapping("/{petId}")
	private ResponseEntity<?> getPetById(@PathVariable("petId") int petId){
		Pets result = petsService.getPetInfoById(petId);
		if (result != null) return Response.success(result, "");
		return Response.error(result, "Records not found");
	}
	
	@GetMapping("/all_pets/{userId}")
	private ResponseEntity<?> allPets(@PathVariable("userId") int userId){
		List<Pets> result = petsService.getAllPetsList(userId);
		if (!result.isEmpty()) return Response.success(result, "");
		return Response.error(result, "Records not found");
	}
	@GetMapping("/search/{userId}")
	private ResponseEntity<?> allPetsBySearch(@PathVariable("userId") int userId, @RequestParam("key") String key){
		List<Pets> result = petsService.getAllPetsListBySearch(userId, key);
		if (!result.isEmpty()) return Response.success(result, "");
		return Response.error(result, "Records not found");
	}
}
