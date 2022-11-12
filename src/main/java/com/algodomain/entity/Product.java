package com.algodomain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productId")
	private int productId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="productType")
	private String productType;
	
	@Column(name="basePrice")
	private float basePrice;
	
	@Column(name="productcategory")
	private String productcategory;	

	public Product() {
		super();
	}

	public Product(int productId, String name, String productType, String category, float basePrice) {
		super();
		this.productId = productId;
		this.name = name;
		this.productType = productType;
		this.basePrice = basePrice;
		this.productcategory=category;
	}

	public String getProductcategory() {
		return productcategory;
	}

	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", productType=" + productType + ", basePrice="
				+ basePrice + ", productcategory=" + productcategory + "]";
	}
	
	
}
