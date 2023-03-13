package com.petofy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.petofy.Model.FoodOrders;

@Repository
public interface FoodOrdersRepository extends JpaRepository<FoodOrders, Integer> {

	@Query(nativeQuery = true, value = "select * from petofy.food_orders where foodOrderId =:orderId and userId =:userId")
	FoodOrders getFoodOrderByFoodOrderIdAndUser(@Param("orderId") int orderId, @Param("userId") int userId);

	@Query(nativeQuery = true, value = "delete from petofy.food_orders where foodOrderId =:orderId and userId = :userId")
	void deleteOrdersByOrderIdAndUserId(@Param("orderId") int orderId, @Param("userId") int userId);

	FoodOrders findByFoodOrderId(int orderId);

	@Query(nativeQuery = true, value = "select * from petofy.food_orders where userId =:userId order by foodOrderDatetime, foodOrderStatus desc")
	List<FoodOrders> findOrdersByUserId(int userId);

}
