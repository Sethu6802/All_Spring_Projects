package com.product.security.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.product.security.model.Product;
import com.product.security.service.MyUser;

@Repository
public interface UserRepo extends JpaRepository<Product, Long>{

	Optional<MyUser> findByUsername(String username);
	
}