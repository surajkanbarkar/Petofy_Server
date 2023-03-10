package com.petofy.Services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.petofy.DTO.UserAuth;
import com.petofy.DTO.UsersDTO;
import com.petofy.Model.Users;

@Service
public interface AuthenticationService {
	Users verifyLogin(UserAuth userAuth);
	boolean addUser(UsersDTO user) throws IOException;
	boolean updateUserDetails(Users user);
	boolean uploadGovId(int userId, MultipartFile file) throws IOException;
	boolean deleteGovId(int userId, String fileName) throws IOException;
	boolean grantUserAccess(int adminUserId, int userId, String userRole, boolean isUserValid);
	String forgotPassword(String emailId, String password, String confirmPass);
}