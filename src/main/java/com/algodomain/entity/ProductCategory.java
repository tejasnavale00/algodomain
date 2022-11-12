package com.algodomain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class ProductCategory {
	
	@Id
	@Column(name="productcategory")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String productcategory;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="gst")
	private int gst;
	
	@Column(name="delivery")
	private int delivery;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> productobj;

	public ProductCategory(String category, int discount, int gst, int delivery) {
		super();
		//this.id = id;
		this.productcategory = category;
		this.discount = discount;
		this.gst = gst;
		this.delivery = delivery;
	}
	
	
	

public ProductCategory() {
		super();
	}


	public String getProductCategory() {
		return productcategory;
	}

	public void setProductCategory(String category) {
		this.productcategory = category;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getGst() {
		return gst;
	}

	public void setGst(int gst) {
		this.gst = gst;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}

	public List<Product> getProductobj() {
		return productobj;
	}

	public void setProductobj(List<Product> productobj) {
		this.productobj = productobj;
	}

	@Override
	public String toString() {
		return "ProductCategory [productcategory=" + productcategory + ", discount=" + discount + ", gst=" + gst
				+ ", delivery=" + delivery + ", productobj=" + productobj + "]";
	}
	

}
