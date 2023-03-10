package com.petofy.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petofy.DTO.StoreInfoDTO;
import com.petofy.DTO.UserRoles;
import com.petofy.Model.StoreInfo;
import com.petofy.Model.Users;
import com.petofy.Repository.StoreInfoRepository;
import com.petofy.Repository.UsersRepository;

@Service
public class StoreInfoServiceImpl implements StoreInfoService{

	@Autowired
	private StoreInfoRepository storeInfoRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public boolean addStoreInfo(StoreInfoDTO storeInfoDTO) {
		Users user = usersRepository.findByUserId(storeInfoDTO.getUserId());
		if (user != null && user.getUserRole().equals(UserRoles.STOREOWNER.name())) {
			StoreInfo storeInfo = new StoreInfo();
			storeInfo.setStoreName(storeInfoDTO.getStoreName());
			storeInfo.setStoreAddress(storeInfoDTO.getStoreAddress());
			storeInfo.setStoreContact(storeInfoDTO.getStoreContact());
			storeInfo.setStoreType(storeInfoDTO.getStoreType());
			storeInfo.setInsertedAt(new Date().toString());
			storeInfo.setUpdatedAt(new Date().toString());
			storeInfo.setUsers(user);
			storeInfoRepository.save(storeInfo);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStoreInfo(StoreInfoDTO storeInfoDTO) {
		//StoreInfo storeInfo2 = storeInfoRepository.findByStoreId(storeInfoDTO.getStoreId());
		//Users user = usersRepository.findByUserId(storeInfoDTO.getUserId());
		StoreInfo storeInfo2 = storeInfoRepository.findStoreByUserIdAndStoreId(storeInfoDTO.getStoreId(), storeInfoDTO.getUserId());
		if (storeInfo2 != null) {
			storeInfo2.setStoreAddress(storeInfoDTO.getStoreAddress());
			storeInfo2.setStoreName(storeInfoDTO.getStoreName());
			storeInfo2.setStoreContact(storeInfoDTO.getStoreContact());
			storeInfo2.setStoreType(storeInfoDTO.getStoreType());
			storeInfo2.setUpdatedAt(new Date().toString());
			
			storeInfoRepository.save(storeInfo2);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStoreInfo(int userId, int storeId) {
		if (usersRepository.findByUserId(userId) != null) {
			StoreInfo storeInfo2 = storeInfoRepository.getByStoreId(storeId);
			if (storeInfo2 != null) {
				storeInfoRepository.delete(storeInfo2);
				return true;
			}
		}
		return false;
	}

	@Override
	public StoreInfo getStoreInfoById(int storeId) {
		StoreInfo storeInfo2 = storeInfoRepository.getByStoreId(storeId);
		if (storeInfo2 != null) {
			return storeInfo2;
		}
		return null;
	}

	@Override
	public List<StoreInfo> getAllStoresList(int userId) {
		if (usersRepository.findByUserId(userId) != null) {
			return storeInfoRepository.findAll();
		}
		return null;
	}

}
