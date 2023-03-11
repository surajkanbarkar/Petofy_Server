package com.petofy.Services;

import java.util.List;

import com.petofy.DTO.StoreInfoDTO;
import com.petofy.Model.StoreInfo;

public interface StoreInfoService {
	boolean addStoreInfo(StoreInfoDTO storeInfoDTO);
	boolean updateStoreInfo(StoreInfoDTO storeInfoDTO);
	boolean deleteStoreInfo(int userId, int storeId);
	StoreInfo getStoreInfoById(int userId);
	List<StoreInfo> getAllStoresList(int userId);
}
