package com.petofy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petofy.Model.StoreInfo;

@Repository
public interface StoreInfoRepository extends JpaRepository<StoreInfo, Integer>{
	
	StoreInfo getByStoreId(int storeId);
	StoreInfo findByStoreId(int storeId);
	List<StoreInfo> findByStoreName(String storeName);
	@Query(nativeQuery = true,
			value = "Select * from storeinfo where storeId = :storeId and userId = :userId")
	StoreInfo findStoreByUserIdAndStoreId(int storeId, int userId);
}
