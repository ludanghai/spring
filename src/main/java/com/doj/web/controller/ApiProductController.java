package com.doj.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doj.web.model.Product;
import com.doj.web.service.ProductService;

@RestController
//@Controller
public class ApiProductController {
	@Autowired
	ProductService productService;
	

	@RequestMapping("/productsConext")
//	public List<Product> findAllProducts() {
//		List<Product> listProducts = productService.findAll();
//		return listProducts;
//	}
	
	public Product[] findAllProducts() {
		List<Product> listProducts = productService.findAll();
		return listProducts.toArray(new Product[listProducts.size()]);
	}
}
