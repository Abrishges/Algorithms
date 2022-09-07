package com.Algorithems.CloudKitchen;

public class Option extends Category {
	
	private double price; 
	
	public Option() {
	    this.price = 0.0;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
