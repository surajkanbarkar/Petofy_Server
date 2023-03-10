package com.petofy.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.petofy.DTO.PetNocDetailsDTO;
import com.petofy.DTO.Response;
import com.petofy.Model.PetNocDetails;
import com.petofy.Services.PetNocDetailsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/approvals")
public class PetApprovalsController {
	
	@Autowired
	PetNocDetailsService petsNocDetailsService;
	
	@PostMapping("/apply/noc")
	private ResponseEntity<?> createNocRequest(
			@RequestParam MultipartFile petPhoto, @RequestParam MultipartFile userSignature, @RequestParam int userId,
			@RequestParam int petId
			) throws IOException{
		String result = petsNocDetailsService.requestNoc(petPhoto, userSignature, userId, petId);
		if (result != null) {
			return Response.success(true, result);
		}
		return Response.error(false, result);
		
	}
	
	@DeleteMapping("/delete/noc/{userId}/{nocId}")
	private ResponseEntity<?> deleteNocRequest(@PathVariable int userId, @PathVariable int nocId){
		boolean result = petsNocDetailsService.deleteNoc(userId, nocId);
		if (result) return Response.success(true, "NOC request deleted successfully!");
		return Response.error(false, "Error while deleting NOC request");
	}
	
	@GetMapping("/{userId}/{nocId}")
	private ResponseEntity<?> getNoc(@PathVariable int userId, @PathVariable int nocId){
		PetNocDetails result = petsNocDetailsService.getNocById(userId, nocId);
		if (result != null)
			return Response.success(result, "");
		return Response.error(result, "No records found");
	}
	@GetMapping("/all_nocs/{userId}")
	private ResponseEntity<?> getAllNocByUserId(@PathVariable int userId){
		List<PetNocDetails> result = petsNocDetailsService.getAllNocsByUserId(userId);
		if (result != null)
			return Response.success(result, "");
		return Response.error(result, "No records found");
	}
	@GetMapping("/all_nocs/gov/{userId}")
	private ResponseEntity<?> getAllNocByGovUserId(@PathVariable int userId){
		List<PetNocDetails> result = petsNocDetailsService.getAllNocs(userId);
		if (result != null)
			return Response.success(result, "");
		return Response.error(result, "No records found");
	}
	@PutMapping("approve/noc")
	private ResponseEntity<?> approveNoc(
			@RequestParam int govUserId, @RequestParam int petUserId, @RequestParam boolean nocApproved,
			@RequestParam String nocApprovalNote, @RequestParam MultipartFile nocFile,
			@RequestParam boolean isUserNocDetailsValid, @RequestParam boolean isPetPhotosValid,
			@RequestParam boolean isSignatureValid, @RequestParam int nocId
			) throws IOException{
		String result = petsNocDetailsService.approveNoc(
				govUserId,petUserId, nocApproved, nocApprovalNote, nocFile, 
				isUserNocDetailsValid, isPetPhotosValid, isSignatureValid, nocId
				);
		if (result.equals("NOC approved"))
			return Response.success(result, "NOC approved");
		return Response.error(result, "No records found");
	}
}
