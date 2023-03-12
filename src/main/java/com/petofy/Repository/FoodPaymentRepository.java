package com.petofy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petofy.Model.FoodPayment;

@Repository
public interface FoodPaymentRepository extends JpaRepository<FoodPayment, Integer> {

	FoodPayment findByFoodPaymentTransactionId(String transId);

	@Query(value = "select * from petofy.food_payment where userId =:userId order by foodPaymentDatetime", nativeQuery = true)
	List<FoodPayment> findAllPaymentsByUserId(int userId);

	@Query(nativeQuery = true, value = "select * from petofy.food_payment where storeId =:storeId order by foodPaymentDatetime")
	List<FoodPayment> findAllPaymentsByStoreId(int storeId);
	

}
