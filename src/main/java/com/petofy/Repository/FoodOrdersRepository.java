package com.petofy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petofy.Model.FoodOrders;


@Repository
public interface FoodOrdersRepository extends JpaRepository<FoodOrders, Integer>{

}
