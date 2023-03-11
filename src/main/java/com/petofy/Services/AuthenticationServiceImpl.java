package com.petofy.Services;

import java.io.IOException;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.petofy.DTO.UserAuth;
import com.petofy.DTO.UserRoles;
import com.petofy.DTO.UsersDTO;
import com.petofy.Model.Users;
import com.petofy.Repository.UsersRepository;


@Transactional
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private static final PasswordEncoder BCRYPT = new BCryptPasswordEncoder();
    
    @Autowired
    private UsersRepository usersRepository;
    
    @Autowired
	private FilesStorageService storageService;
	
    
	@Override
	public Users verifyLogin(UserAuth userAuth) {
		Users user = usersRepository.getByEmail(userAuth.getEmail());
		if (user != null)
			if (user.isUserValid())
				if (BCRYPT.matches(userAuth.getPassword(), user.getPassword())) {
					user.setLoggedIn(true);
					usersRepository.save(user);
					//user.setPassword(null);
					return user;
				}
		return null;
	}
	
	@Override
	public boolean addUser(UsersDTO userDTO) throws IOException {
		if (usersRepository.findByEmail(userDTO.getEmail()).isEmpty()) {
			String encryptedPass = BCRYPT.encode(userDTO.getPassword());
			Users user = new Users();
			user.setAddress(userDTO.getAddress());
			user.setFirstName(userDTO.getFirstName());
			user.setLastName(userDTO.getLastName());
			user.setEmail(userDTO.getEmail());
			user.setMobNo(userDTO.getMobNo());
			user.setUserRole(userDTO.getUserRole());
			user.setPassword(encryptedPass);
			
			if (userDTO.getUserRole().equals(UserRoles.CUSTOMER.name()))
				user.setUserValid(true);
			else user.setUserValid(false);
			
			user.setUserRole(UserRoles.valueOf(userDTO.getUserRole()).name());
			user.setInsertedAt(new Date().toString());
			user.setUpdatedAt(new Date().toString());
			user.setLoggedIn(false);
			Users userObj = usersRepository.save(user);
			
			storageService.delete(Integer.toString(userObj.getUserId()), userDTO.getFile().getOriginalFilename());
			
			storageService.save(userDTO.getFile(), Integer.toString(userObj.getUserId()));
			Resource file = storageService.load(Integer.toString(userObj.getUserId()), userDTO.getFile().getOriginalFilename());
			userObj.setGovIdName(userDTO.getFile().getOriginalFilename());
			userObj.setGovIdurl(file.getURL().toString());
			if(usersRepository.save(userObj) != null)
				return true;
		}
		return false;		
	}

	@Override
	public boolean updateUserDetails(Users user) {
		Users userDetail = usersRepository.getByUserId(user.getUserId());
		if (userDetail != null) {
			userDetail.setAddress(user.getAddress());
			userDetail.setFirstName(user.getFirstName());
			userDetail.setLastName(user.getLastName());
			userDetail.setMobNo(user.getMobNo());
			userDetail.setUpdatedAt(new Date().toString());
			userDetail.setGovIdName(user.getGovIdName());
			userDetail.setGovIdurl(user.getGovIdurl());
			usersRepository.save(userDetail);
			return true;
		}
		return false;
	}

	@Override
	public boolean uploadGovId(int userId, MultipartFile file) throws IOException {
		Users userObj = usersRepository.findByUserId(userId);
		Resource uploadedFile;
		if (userObj != null) {
			boolean existed = storageService.delete(Integer.toString(userId), userObj.getGovIdName());
			storageService.save(file, Integer.toString(userId));
			uploadedFile = storageService.load(Integer.toString(userObj.getUserId()), file.getOriginalFilename());
			if (uploadedFile.exists())
			{		      		
				userObj.setGovIdName(uploadedFile.getFilename());
	      		userObj.setGovIdurl(uploadedFile.getURL().toString());
	      		usersRepository.save(userObj);
	      		return true;
	      	}
		}
		return false;
	}

	@Override
	public boolean deleteGovId(int userId, String fileName) throws IOException {
		Users userObj = usersRepository.findByUserId(userId);
		if (userObj != null) {
			boolean existed = storageService.delete(Integer.toString(userId), fileName);
			if (existed)
			{		      		
				userObj.setGovIdName(null);
	      		userObj.setGovIdurl(null);
	      		usersRepository.save(userObj);
	      		return true;
	      	}
		}
		return false;
	}

	@Override
	public boolean grantUserAccess(int adminUserId, int userId, String userRole, boolean isUserValid) {
		if (usersRepository.findByUserId(adminUserId).getUserRole().equals(UserRoles.ADMIN.name())) {
			Users userObj = usersRepository.findByUserId(userId);
			if (isUserValid) {
				userObj.setUserValid(true); userObj.setUserRole(UserRoles.valueOf(userRole).name());
			}
			else userObj.setUserValid(false);
			return true;
		}
		return false;
	}

	@Override
	public String forgotPassword(String emailId, String password, String confirmPass) {
		Users user = usersRepository.getByEmail(emailId);
		if (user != null)
			if (password.equals(confirmPass)) {
				user.setPassword(BCRYPT.encode(password));
				usersRepository.save(user);
				return "Password changed successfully";
			}
			else return "Passwords not matched";
		return "Invalid email";
	}

	@Override
	public Users getUserByUserId(int userId) {
		return usersRepository.getByUserId(userId);
	}

}
