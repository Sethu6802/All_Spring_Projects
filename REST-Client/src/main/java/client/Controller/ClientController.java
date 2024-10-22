package client.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import client.Product.Model.Product;

@RestController
@RequestMapping("/client/api")
public class ClientController {
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getProducts")
	public List<Product> getAllProducts(){
		String url = "http://localhost:9011/fact/number/**";
		List<Product> list = restTemplate.getForObject(url,List.class);
		return list;
	}
	

}