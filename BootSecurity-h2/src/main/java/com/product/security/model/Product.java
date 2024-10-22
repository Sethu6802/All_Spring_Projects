package com.product.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private long prodId;

	private String brand;
	
	private String desc;
  
	private int qty;
  
	private int price;
  
  
}