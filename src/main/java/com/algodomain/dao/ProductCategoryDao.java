package com.algodomain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;
import com.algodomain.repository.ProductCategoryRepository;


@Service
public class ProductCategoryDao {
	
	@Autowired
	ProductCategoryRepository repo;
	
	public ProductCategory getCategoryByName(String name)
	{
		return repo.getCategoryByName(name);
	}

	public List<ProductCategory> getCategories()
	{
		
		return repo.getCategories();
	}
	
	public ProductCategory setproductcategory(ProductCategory productcategory)
	{
		return repo.save(productcategory);
	}
	
	public void deleteproductcategory(ProductCategory productcategory)
	{
		repo.delete(productcategory);
	}
	

}
