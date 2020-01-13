package com.ssafy.car;

public class Car {
	protected String num;
	protected String model;
	protected int price;
	
	public Car() {
		this("", "", 0);
	}
	public Car(String num, String model, int price) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "차량번호 = " + num + ", 모델명 = " + model + ", 가격 = " + price;
	}
	
	
	
	
}
