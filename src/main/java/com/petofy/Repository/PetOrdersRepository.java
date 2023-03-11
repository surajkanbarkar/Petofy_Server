package com.petofy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petofy.Model.PetOrders;


@Repository
public interface PetOrdersRepository extends JpaRepository<PetOrders, Integer>{
	@Query(nativeQuery = true,
			value = "select * from petofy.pet_orders where petsOrderId = :orderId and userId = :userId")
	PetOrders getOrdersByOrderIdAndUserId(int orderId, int userId);
	@Query(nativeQuery = true,
			value = "delete from petofy.pet_orders where petsOrderId = :orderId and userId = :userId")
	void deleteOrdersByOrderIdAndUserId(int orderId, int userId);
	void deleteByPetsOrderId(int orderId);
	PetOrders findByPetsOrderId(int orderId);
//	@Query(nativeQuery = true,
//			value = "select * from petofy.pet_orders where userId = :userId order by orderUpdatedAt, orderStatus desc")
//	List<PetOrders> findOrdersByUserId(int userId);
	@Query(nativeQuery = true,
			value = "select * from petofy.pets_payment pp inner join petofy.pet_orders po on po.userId = pp.userId where pp.userId = :userId order by orderUpdatedAt, orderStatus desc")
	List<PetOrders> findOrdersByUserId(int userId);
	
}
