package com.petofy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petofy.Model.Pets;

@Repository
public interface PetsRepository extends JpaRepository<Pets, Integer>{
	Pets getByPetsId(int petId);
	Pets findByPetsId(int petId);
	List<Pets> findByPetBreed(String breed);
	List<Pets> findByPetPrice(Double price);
	List<Pets> findByPetInStock(boolean inStock);
	
	@Query(nativeQuery = true,
			value = "select * from petofy.pets where storeId = :storeId and petsId = :petId")
	Pets findByPetIdAndStoreId(int storeId, int petId);
	@Query(nativeQuery = true,
			value = "SELECT * FROM petofy.pets WHERE petBreed like %:text% or petBreedGroup like %:text% or petHeight like %:text% or petWeight like %:text% or petLifespan like %:text% or petTemperament like %:text% or petApartmentFriendly like %:text%")
	List<Pets> searchPets(String text);
}
