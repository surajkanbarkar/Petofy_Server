package com.petofy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petofy.DTO.PetsPaymentDTO;
import com.petofy.Model.PetsPayment;

@Repository
public interface PetsPaymentRepository extends JpaRepository<PetsPayment, Integer>{
	
	PetsPayment findByPetsPaymentTransactionId(String transId);
	@Query(nativeQuery = true,
			value = "select * from petofy.pets_payment where userId = :userId order by petsPaymentDatetime")
	List<PetsPayment> findAllPaymentsByUserId(int userId);
	@Query(nativeQuery = true,
			value = "select * from petofy.pets_payment where storeId = :storeId order by petsPaymentDatetime")
	List<PetsPayment> findAllPaymentsByStoreId(int storeId);
}
