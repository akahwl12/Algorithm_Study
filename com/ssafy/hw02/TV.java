package com.ssafy.hw02;

import java.io.Serializable;

public class TV extends Product implements Serializable {

	private double inch;
	
	public TV() {
		
	}

	public TV(String isbn, String name, int price, int quantity, double inch) {
		super(isbn, name, price, quantity);
		this.inch = inch;
	}

	@Override
	public String toString() {
		return super.toString() + "| " + inch;
	}

	public double getInch() {
		return inch;
	}

	public void setInch(double inch) {
		this.inch = inch;
	}
	
}
