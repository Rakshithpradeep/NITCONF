package com.nite2.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nite2.model.User;



@Repository
public interface UserRepository extends CrudRepository<User,String>{
	
	User findUserByUsername(String username);
	
	Optional<User> findById(String username);
	
	

}