package com.petofy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.petofy.Model.PetsFood;


@Repository
public interface PetsFoodRepository extends JpaRepository<PetsFood, Integer>{

}
