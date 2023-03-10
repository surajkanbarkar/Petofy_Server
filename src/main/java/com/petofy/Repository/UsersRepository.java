package com.petofy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petofy.Model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	List<Users> findByEmail(String email);
	Users getByEmail(String email);
	Users getByUserId(int userId);
	Users findByUserId(int userId);
}
