package com.doj.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doj.web.model.Product;
import com.doj.web.service.ProductService;

//@RestController
@Controller
public class ProductController {
	@Autowired
	ProductService productService;

//	@RequestMapping("/")
//	public String home() {
//		return "index";
//	}

	@RequestMapping("/products")
	public String findAllProducts(Model model) {
		List<Product> listProducts = productService.findAll();
		model.addAttribute("listProducts", listProducts);
		return "products";
	}

	@RequestMapping("/productDetails")
	public String findProducts(@RequestParam("id") int id, Model model) {
		Product product = productService.findProductById(id);
		model.addAttribute("product", product);
		return "productDetails";
	}

	@RequestMapping("/editProduct")
	public String editProduct(@RequestParam("id") int id, Model model) {
		String productName = "anhbang";
		productService.update(productName, id);

		List<Product> listProducts = productService.findAll();
		model.addAttribute("listProducts", listProducts);
		return "products";
	}
}
