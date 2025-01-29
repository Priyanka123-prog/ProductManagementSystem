package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ProductControllers {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product){
		return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllProduct(){
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id){
		return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id){
		return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
	}
	
	@PutMapping("/editProduct")
	public ResponseEntity<?> editProduct(@RequestBody Product product){
		return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
	}
	
	@PutMapping("/editProduct/{id}")
	public ResponseEntity<?> editProducts(@RequestBody Product product,@PathVariable int id){
		return new ResponseEntity<>(productService.editProduct(product,id),HttpStatus.CREATED);
	}
	
	

}
