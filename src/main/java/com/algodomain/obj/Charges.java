package com.algodomain.obj;

import com.algodomain.entity.ProductCategory;

public class Charges {
	
	private float gst;
	private float delivery;



	public Charges() {
		super();
	}
	public Charges(float baseprice, ProductCategory productcategory) {
		super();
		this.gst = productcategory.getGst();
		this.delivery = productcategory.getDelivery();
	}

	public float getGst() {
		return gst;
	}
	public void setGst(float gst, float discount, float baseprice) {
			
		float temp = ((baseprice*discount)/100);
		
		this.gst= (((baseprice-temp)*gst)/100);
	}
	public float getDelivery() {
		return delivery;
	}
	public void setDelivery(float delivery) {
		this.delivery = delivery;
	}
	

}
