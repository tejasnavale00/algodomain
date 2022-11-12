package com.algodomain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algodomain.entity.Product;
import com.algodomain.repository.ProductRepository;

@Service
public class ProductDao {
	
	@Autowired
	ProductRepository repo;
	
	
	public Product getProductById(int Id)
	{
		
		return repo.findProductById(Id);
	}
	
	public List<Product> getProducts()
	{
		
		return repo.getProducts();
	}
	
	public Product setproduct(Product product)
	{
		
		return repo.save(product);
	}
	
	public void deleteproduct(Product product)
	{
		
		 repo.delete(product);
	}

}
