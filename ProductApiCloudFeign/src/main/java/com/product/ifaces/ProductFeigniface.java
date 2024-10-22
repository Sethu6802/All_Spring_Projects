package com.product.ifaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.product.model.Product;

@FeignClient(value = "feignClient", url = "http://localhost:9009/product/api")
public interface ProductFeigniface {
	
	@GetMapping("/info")
	public List<Product> getAllProducts();

}
