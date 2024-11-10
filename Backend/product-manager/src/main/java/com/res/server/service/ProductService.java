package com.res.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.res.server.service.model.Product;

@Service
public class ProductService {
	
	
	//create
	private List<Product> list = new ArrayList<>();
	
	
	public ProductService() {
		list.add(new Product(UUID.randomUUID().toString(),
				"Demo Product 1",
				"This is demo product",
				909.99
				));
				
	}
	
	
	
	public Product add(Product product) {
		
		product.setProductId(UUID.randomUUID().toString());
		
		list.add(product);
		
		return product;
	}

	//get all
	public List<Product> getAllProducts(){
		return list;
	}
	
	//delete
	public void delete(String id)
	{
		list.removeIf(p->p.getProductId().equals(id));
	}
	
	
	
	
}
