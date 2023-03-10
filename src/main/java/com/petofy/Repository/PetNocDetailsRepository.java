package com.petofy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petofy.Model.PetNocDetails;


@Repository
public interface PetNocDetailsRepository extends JpaRepository<PetNocDetails, Integer>{
	@Query(nativeQuery = true,
			value = "select * from petofy.pet_noc_details where petsId = :petId and userId = :userId")
	PetNocDetails findByPetsIdUserId(int petId, int userId);
	PetNocDetails findByPetNocDetailsId(int nocId);
	@Query(nativeQuery = true,
			value = "select * from petofy.pet_noc_details where userId = :userId")
	List<PetNocDetails> findByUserId(int userId);
}
