package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/product/api")
public class productController {

    Logger logger = Logger.getLogger("productController.class");

    @Autowired
    productService service;

//    ArrayList<Product> productList = new ArrayList<>();

//    {
//        productList.add(new Product(101, "Nike", "Shoe", 15, 10000));
//        productList.add(new Product(102, "Marshall", "Speaker", 2, 400000));
//        productList.add(new Product(103, "Rolex", "Watch", 20, 50000));
//        productList.add(new Product(104, "Adidas", "Shoe", 13, 3440));
//    }


    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Product>> getById(@PathVariable int id) {

        Optional<Product> optional = service.displayById(id);
        return ResponseEntity.status(200).body(optional);
    }


    @GetMapping(value = "/brand/{brand}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getByBrand(@PathVariable String brand) {

        List<Product> product = service.displayByBrand(brand);
        return ResponseEntity.status(200).body(product);

    }


    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        //logger.info("Entered Post Method " + product + "Successfully\n");
        Product newProduct = service.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);

    }


    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> productInfo() {

        return ResponseEntity.status(HttpStatus.OK).body(service.displayAll());

    }


	/*
	 * @PutMapping(value = "/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
	 * 
	 * Product newProduct = service.update(product); if(newProduct != null){ Product
	 * temp = newProduct;
	 * 
	 * temp.setBrand(product.getBrand()); temp.setDesc(product.getDesc());
	 * temp.setQty(product.getQty()); temp.setPrice(product.getPrice()); }
	 * 
	 * // int index = productList.indexOf(temp); // productList.remove(index); //
	 * productList.add(temp);
	 * 
	 * return ResponseEntity.status(200).body(newProduct); }
	 */
}