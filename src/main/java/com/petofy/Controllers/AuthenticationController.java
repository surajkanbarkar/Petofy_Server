package com.petofy.Controllers;

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

import com.petofy.DTO.Response;
import com.petofy.DTO.UserAuth;
import com.petofy.DTO.UsersDTO;
import com.petofy.Model.Users;
import com.petofy.Services.AuthenticationService;
import com.petofy.Services.FilesStorageService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	//@RequestMapping(path = "/signup", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	//@Valid @ModelAttribute UsersDTO usersDTO
	@PostMapping("/signup")
	private ResponseEntity<?> signUp(
			@RequestParam String firstName, @RequestParam String lastName,@RequestParam String mobNo,
			@RequestParam String address, @RequestParam String email,@RequestParam String password,
			@RequestParam String userRole, @RequestParam MultipartFile file
			) {
		try {
			UsersDTO usersDTO = new UsersDTO();
			usersDTO.setFirstName(firstName);usersDTO.setLastName(lastName); usersDTO.setMobNo(mobNo);
			usersDTO.setAddress(address);usersDTO.setEmail(email);usersDTO.setPassword(password);
			usersDTO.setUserRole(userRole);usersDTO.setFile(file);
			boolean result = authenticationService.addUser(usersDTO);
			if(result) {
				return Response.success(result, "User registered successfully!");
			}
			return Response.error(result, "User already exists with this email id");
		}catch (Exception e) {
		      //message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
		      return Response.error(false, "not able to upload file");
		}
	}
	
	@PostMapping("/file/upload")
	  public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") int userId) {
	    try {
	      if (authenticationService.uploadGovId(userId, file)) 
	    	  return Response.success(file.getOriginalFilename(), "File uploaded successfully!");
	      
	      else
	    	  return Response.error(true, "Could not upload the file, please check your file size");  
	    } catch (Exception e) {
	    	return Response.error(true, "Could not upload the file, please check your file size");
	    }
	  }
	
	@PutMapping("/forgotpassword")
	  public ResponseEntity<?> forgotPassword(@RequestParam String emailId, @RequestParam String password, @RequestParam String confirmPass) {
		String result = authenticationService.forgotPassword(emailId, password, confirmPass);
	      if (result.equals("Password changed successfully")) 
	    	  return Response.success(true, result);
	      else
	    	  return Response.error(false, result);  
	  }
	@DeleteMapping("/file/delete/{userId}/{filename}")
	public ResponseEntity<?> deleteFile(@PathVariable int userId, @PathVariable String filename) {
		try {
		      if (authenticationService.deleteGovId(userId, filename)) {
		        return Response.success(true, "file deleted successfully!");
		      }
		      return Response.error(false, "The file does not exist!");
		    } catch (Exception e) {
		      return Response.success(false, "could not able to delete file");
		    }
	 }
	
	@PostMapping("/signin")
	private ResponseEntity<?> signIn(@RequestBody UserAuth userAuth) {
		Users result = authenticationService.verifyLogin(userAuth);
		if(result != null) {
			return Response.success(result, "Signed in successfully!");
		}
		return Response.error(result, "Not a valid credentials or contact admin");
	}
	@PutMapping("/update_profile")
	private ResponseEntity<?> updateProfile(@RequestBody Users user) {
		boolean result = authenticationService.updateUserDetails(user);
		if(result) {
			return Response.success(result, "Profile updated successfully!");
		}
		return Response.error(result, "Someting went wrong");
	}
	
	@GetMapping("/get_profile/{userId}")
	private ResponseEntity<?> getProfile(@PathVariable String userId) {
		
		Users result = authenticationService.getUserByUserId(Integer.parseInt(userId));
		if(result != null) {
			return Response.success(result, "Profile details fetched!");
		}
		return Response.error(result, "Someting went wrong");
	}
}