package com.product.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.ifaces.ProductFeigniface;
import com.product.model.Product;

@RestController
@RequestMapping("/client")
public class FeignClient {

	@Autowired
	private ProductFeigniface feignClient;
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return feignClient.getAllProducts();
	}
}
