package com.ssafy.hw;

public class Product {
	protected String isbn;
	protected String name;
	protected int price;
	protected int count;
	
	public Product(String i, String n, int p, int c) {
		this.isbn = i;
		this.name = n;
		this.price = p;
		this.count = c;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "제품 번호 = " + isbn + ", 제품명 = " + name + ", 가격 = " + price + ", 재고수량=" + count;
	}
}
