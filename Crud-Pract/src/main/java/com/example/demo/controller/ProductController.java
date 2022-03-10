package com.example.demo.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductSrvice;

@RestController
@RequestMapping("/prod")
public class ProductController {
	
	@Autowired
	private ProductSrvice service;

	
//	@PostMapping("/addProduct")
//	public ResponseEntity<Product> addproduct(@RequestBody Product product){
//		return new ResponseEntity<Product>(service.saveProduct(product),HttpStatus.CREATED);
//	}
	
	@RequestMapping(value="/addProduct" , method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addproduct(@RequestBody Product product){
		return new ResponseEntity<Product>(service.saveProduct(product),HttpStatus.CREATED);
	}
	
	@PostMapping("/addProducts")
	public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products){
		return new ResponseEntity<List<Product>>(service.saveProducts(products),HttpStatus.CREATED);
	}
	

	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct(Product product){
		return new ResponseEntity<List<Product>>(service.getProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/productById/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable int id){
		return new ResponseEntity<Product>(service.getProductById(id),HttpStatus.OK);
	}
	
	@GetMapping("/product/{name}")
	public ResponseEntity<Product> findProductByName(@PathVariable String name) {
		return new ResponseEntity<Product>(service.getProductByName(name),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(service.updateProduct(product),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		return new ResponseEntity<String>(service.deleteProduct(id),HttpStatus.ACCEPTED);
	}
	
	
//	@PostMapping("/addProduct")
//	public Product addProduct(@RequestBody Product product) {
//		return service.saveProduct(product);
//	}
	
//	@PostMapping("/addProducts")
//	public List<Product> addProducts(@RequestBody List<Product> products) {
//		return service.saveProducts(products);
//	}
	
	
//	@GetMapping("/products")
//	public List<Product> getAllProducts(){
//		return service.getProducts();
//	}
	
//	@GetMapping("/productById/{id}")
//	public Product findProductById(@PathVariable int id) {
//		return service.getProductById(id);
//	}
	
//	@GetMapping("/product/{name}")
//	public Product findProductByName(@PathVariable String name) {
//		return service.getProductByName(name);
//	}
	
//	@PutMapping("/update")
//	public Product updateProduct(@RequestBody Product product) {
//		return service.updateProduct(product);
//	}
	
//	@DeleteMapping("/delete/{id}")
//	public String deleteProduct(@PathVariable int id){
//		return service.deleteProduct(id);
//	}
	
	
	

}
