package com.ssafy.hw;

public class Refrigerator extends Product{

	private int L;

	public Refrigerator(String i, String n, int p, int c, int l) {
		super(i, n, p, c);
		this.L = l;
	}
	
	public int getL() {
		return L;
	}
	
	public void setL(int l) {
		L = l;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", 용량 = " + L;
	}
	
	
}
