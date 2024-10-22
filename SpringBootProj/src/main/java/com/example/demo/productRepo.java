package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo extends JpaRepository<Product, Long>{

	List<Product> findByBrand(String brand);

	//Product updateTheProduct(Product product);
	
}

//public interface productRepo extends MongoRepository<Product, Long> {
//
//}
