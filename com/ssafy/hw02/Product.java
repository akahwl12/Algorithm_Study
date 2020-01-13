package com.ssafy.hw02;

import java.io.Serializable;

public class Product implements Serializable {
	protected String isbn;
	protected String name;
	protected int price;
	protected int quantity;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String isbn, String name, int price, int quantity) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return isbn + "| " + name + "| " + price + "| " + quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
