package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	public String deleteProduct(int id);
	public Product editProduct(Product product,int id);
}
