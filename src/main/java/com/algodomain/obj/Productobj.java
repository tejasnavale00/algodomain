package com.algodomain.obj;

import com.algodomain.entity.Product;

public class Productobj {
	
	private int productId;
	private String name;
	private String productType;
	private String category;
	private float basePrice;
	private float discount;
	
	Charges charges;
	
	private float finalprice;

	public Productobj(Product product, Charges charges) {
		super();
		this.productId = product.getProductId();
		this.name = product.getName();
		this.productType = product.getProductType();
		this.category = product.getProductcategory();
		this.basePrice = product.getBasePrice();
		this.charges = charges;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = ((basePrice*discount)/100);
	}

	public float getFinalprice() {
		return finalprice;
	}

	public void setFinalprice() {
		
		
		this.finalprice = ((basePrice-discount)+charges.getGst()+charges.getDelivery());

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public Charges getCharges() {
		return charges;
	}

	public void setCharges(Charges charges) {
		this.charges = charges;
	}

}
