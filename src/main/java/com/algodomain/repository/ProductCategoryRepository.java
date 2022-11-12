package com.algodomain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

	@Query(value ="select * from product_category where productcategory= :name", nativeQuery=true)
	ProductCategory getCategoryByName(@Param("name")String name);
	
	@Query(value ="select * from product_category", nativeQuery=true)
	List<ProductCategory> getCategories();
	
	
}
