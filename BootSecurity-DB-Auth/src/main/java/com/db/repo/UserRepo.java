package com.db.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.model.MyUser;

@Repository
public interface UserRepo extends JpaRepository<MyUser, Long>{

	Optional<MyUser> findByUsername(String username);
	
}