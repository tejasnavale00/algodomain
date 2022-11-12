package com.algodomain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algodomain.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value ="select * from product where product_id = :Id", nativeQuery=true)
	Product findProductById(@Param("Id")int Id);
	
	@Query(value ="select * from product", nativeQuery=true)
	List<Product> getProducts();
	
	
}
