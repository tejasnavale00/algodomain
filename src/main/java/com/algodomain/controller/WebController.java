package com.algodomain.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.algodomain.dao.ProductCategoryDao;
import com.algodomain.dao.ProductDao;
import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;
import com.algodomain.obj.Charges;
import com.algodomain.obj.Productobj;



@RestController

public class WebController {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductCategoryDao productcategorydao;

	@GetMapping("/")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("index");

		return mv;
	}
	
	@RequestMapping("/getproduct/{Id}")
	public Productobj getProductById(@PathVariable int Id) {
	
		Product exproduct=productDao.getProductById(Id);

		ProductCategory cat= productcategorydao.getCategoryByName(exproduct.getProductcategory());
		
		Charges ch=new Charges();
		
		if(exproduct!=null)
		{
		
			
		ch.setGst(cat.getGst(), cat.getDiscount(), exproduct.getBasePrice());
		ch.setDelivery(cat.getDelivery());
		
		}
		Productobj product=new Productobj(exproduct, ch);
		product.setDiscount(cat.getDiscount());
		product.setFinalprice();
		
	
		return product;
	}
	
	
	@RequestMapping("/getproducts")
	public List<Product> getProducts() {
	
		List<Product> exproduct=productDao.getProducts();
		
	
		return exproduct;
	}
	
	@PostMapping("/product")
	public String postProduct(@RequestBody Product product) {
		
		ProductCategory cat= productcategorydao.getCategoryByName(product.getProductcategory());
		
		if(cat != null)
		{
			productDao.setproduct(product);
			return "Product inserted successfully";
		}
		
		else
		{
			return "Something went wrong, try again...";
		}
		
	}
	
	
	@PutMapping("/product")
	public String putProduct(@RequestBody Product product) {
		
		Product exproduct=productDao.getProductById(product.getProductId());
		
		if(exproduct != null)
		{
			productDao.setproduct(product);
			return "Product updated successfully";
		}
		
		else
		{
			return "Something went wrong, try again...";
		}
		
	}
	
	
	@DeleteMapping("/product/{Id}")
	public String deleteProduct(@PathVariable int Id) {
		
		Product exproduct=productDao.getProductById(Id);
		
		if(exproduct != null)
		{
			productDao.deleteproduct(exproduct);
			return "Product deleted successfully";
		}
		
		else
		{
			return "Something went wrong, try again...";
		}
		
	}
	
	
	//===========For Category=====================
	
	
	
	@RequestMapping("/getcategory/{category}")
	public ProductCategory getCategoryById(@PathVariable String category) {

		ProductCategory cat= productcategorydao.getCategoryByName(category);
		
		if(cat!=null)
		{
			return cat;
		
		}		
	
		return null;
	}
	
	@RequestMapping("/getcategories")
	public List<ProductCategory> getCategories() {

		List<ProductCategory> cat= productcategorydao.getCategories();
		
		if(cat!=null)
		{
			return cat;
		
		}		
	
		return null;
	}
	
	
	@PostMapping("/category")
	public String postCategory(@RequestBody ProductCategory productcategory) {
		
		
		if(productcategory != null)
		{
			productcategorydao.setproductcategory(productcategory);
			return "Product category inserted successfully";
		}
		
		else
		{
			return "Something went wrong, try again...";
		}
		
	}
	
	
	@PutMapping("/category")
	public String putCategory(@RequestBody ProductCategory productcategory) {
		
		
		if(productcategory != null)
		{
			productcategorydao.setproductcategory(productcategory);
			return "Product category updated successfully";
		}
		
		else
		{
			return "Something went wrong, try again...";
		}
		
	}
	
	@DeleteMapping("/category/{category}")
	public String deleteCategory(@PathVariable String category) {
		
		ProductCategory cat= productcategorydao.getCategoryByName(category);
		
		if(cat != null)
		{
			productcategorydao.deleteproductcategory(cat);
			return "Product category delete successfully";
		}
		
		else
		{
			return "Something went wrong, try again...";
		}
		
	}
	

}
