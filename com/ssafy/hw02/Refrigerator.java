package com.ssafy.hw02;

import java.io.Serializable;

public class Refrigerator extends Product implements Serializable {

	private double liter;
	
	public Refrigerator() {
		
	}

	public Refrigerator(String isbn, String name, int price, int quantity, double liter) {
		super(isbn, name, price, quantity);
		this.liter = liter;
	}

	@Override
	public String toString() {
		return super.toString() + "| " + liter;
	}

	public double getLiter() {
		return liter;
	}

	public void setLiter(double liter) {
		this.liter = liter;
	}
	
}
