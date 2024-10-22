package api.client.resilience;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/client/api")
public class ClientController {
	
	@Autowired
	RestTemplate restTemplate;
	public final static String CLIENT_SERVICE = "hello-service-client";

	@GetMapping
	@CircuitBreaker(name=CLIENT_SERVICE, fallbackMethod = "callOnFail")
	public String getAllProducts(){
		String url = "http://localhost:9009/rest/service/est";
		String list = restTemplate.getForObject(url,String.class);
		return list;
	}
	
	public String callOnFail(Exception e) {
		return "message from callOnFail().....";
	}

}