package com.Algorithems.CloudKitchen;

public class Dish extends Category {
   
	private double price; 
	
	public Dish() {
		this.price = 0.0;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}