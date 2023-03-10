package com.petofy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petofy.Model.FoodPayment;


@Repository
public interface FoodPaymentRepository extends JpaRepository<FoodPayment, Integer>{

}
