package com.simplilearn.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.simplilearn.webservice.entity.Product;

@RestController
@RequestMapping("/api/consumer")

public class ProductConsumerController {

	String url = "http://localhost:3000/api/products/";

	@GetMapping("/products/{id}")
	public Product fetchProduct(@PathVariable("id") long id) {
		// use rest template
		RestTemplate restTemplate = new RestTemplate();
		
		// consume url endpoint
		ResponseEntity<Product> product = restTemplate.getForEntity(url + id, Product.class);
		return product.getBody();
	}
	
	@PutMapping("/products/")
	public String  updateProduct(@RequestBody Product product) {
		// use rest template
		RestTemplate restTemplate = new RestTemplate();
		
		// consume url for put
		restTemplate.put(url ,product);
		return "Product is updated sucessfully !";
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable("id") long id) {
		// use rest template
		RestTemplate restTemplate = new RestTemplate();
		
		// consume url endpoint
		restTemplate.delete(url+id);
		return "Product is deleted sucessfully !";
	}
}
