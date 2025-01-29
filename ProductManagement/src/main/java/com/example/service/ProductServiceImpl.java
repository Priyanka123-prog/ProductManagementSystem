package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.ProductRepo;
import com.example.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productrepo;
	@Override
	public Product saveProduct(Product product) {
		
		return productrepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productrepo.findAll();
	}

	@Override
	public Product getProductById(int id) {
		
		return productrepo.findById(id).get();
	}

	@Override
	public String deleteProduct(int id) {
		Product p=productrepo.findById(id).get();
		if(p!=null) {
			productrepo.delete(p);
			return "product deleted successfully";
		}
		return "something went wrong";
		
	}

	@Override
	public Product editProduct(Product p, int id) {
		Product oldproduct=productrepo.findById(id).get();
		oldproduct.setProductName(p.getProductName());
		oldproduct.setDescription(p.getDescription());
		oldproduct.setPrice(p.getPrice());
		oldproduct.setStatus(p.getStatus());
		return productrepo.save(oldproduct);
	}

}
