package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productService {

    @Autowired
    private productRepo repo;

    public Product addProduct(Product newProduct){
        repo.save(newProduct);
        return newProduct;
    }

	public Optional<Product> displayById(long id) {
		
		return repo.findById(id);
	}

	public List<Product> displayByBrand(String brand) {
		
		return repo.findByBrand(brand);
	}

	public List<Product> displayAll() {
		
		return repo.findAll();
	}

	/*
	 * public Product update(Product product) {
	 * 
	 * return repo.updateTheProduct(product); };
	 */
}
