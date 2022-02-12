package com.restcrud.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.restcrud.demo.entity.User;

public interface UserRepository extends JpaRepository <User, Long>{
	
	Void save(Optional<User> userToUpdate);
	
}
