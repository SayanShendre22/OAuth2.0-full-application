package com.res.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.res.server.service.ProductService;
import com.res.server.service.model.Product;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin("*")
public class MyController {
	
	@Autowired
	private ProductService productService;
	
	//create product
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.add(product);
	}
	
	// get peoducts
	@GetMapping
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}
	
	
	//delete
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable String id) {
		productService.delete(id);
	}
	
	
	
}
