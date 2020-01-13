package com.ssafy.car;

public class CarMgr extends Car{
	private static CarMgr carMgr = new CarMgr();
	private CarMgr() {};
	public static CarMgr getInstance() {
		return carMgr;
	}
	
	private Car[] cars = new Car[100];
	private int index = 0;
	
//	차량정보 프린트
	public void print(Car[] c) {
		for (int i = 0; i < c.length; i++) {
			if(c[i]!=null)
				System.out.println(c[i].toString());
		}
		System.out.println();
	}
	
	public void print(Car c) {
		System.out.println(c.toString());
		System.out.println();
	}
	
//	파라메터로 전달된 차량 정보를 배열에 저장한다.
	public void add(Car c) {
		if(index>0 && index<=100)
			cars[index++] = c;
	}
	
//	현재 저장된 모든 차량 정보를 리턴한다.
	public Car[] search() {
		Car[] tmp = new Car[100];
		int idx = 0;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null)
				tmp[idx++] = cars[i];
		}
		return tmp;
	}
	
//	파라메터로 전달된 번호와 같은 차량 정보를 리턴한다.
	public Car search(String num) {
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null && cars[i].getNum().equals(num))
				return cars[i];
		}
		return null;
	}
	
//	파라메터로 전달된 가격보다 작은 차량 정보들을 리턴한다.
	public Car[] search(int price) {
		Car[] tmp = new Car[100];
		int idx = 0;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null && cars[i].getPrice() <= price)
				tmp[idx++] = cars[i];
		}
		return tmp;
	}
	
//	파라메터로 전달된 번호의 차량을 검색하여 가격을 수정한다.
	public void update(String num, int price) {
		boolean check = false;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null && cars[i].getNum().equals(num)) {
				cars[i].setPrice(price);
				check = true;
			}
		}
		if(!check)
			System.out.println("해당 차량이 없습니다.");
	}
	
//	파라메터로 전달된 번호의 차량을 삭제한다.
	public void delete(String num) {
		boolean check = false;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null && cars[i].getNum().equals(num)) {
				cars[i] = null;
				check = true;
			}
		}
		if(!check)
			System.out.println("해당 차량이 없습니다.");
	}
	
//	배열에 저장된 차량 대수를 리턴한다.
	public int size() {
		int cnt=0;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null)
				cnt++;
		}
		return cnt;
	}
	
//	배열에 저장된 차량의 금액 합계를 계산하여 리턴한다.
	public int totalPrice() {
		int tot=0;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null)
				tot+=cars[i].getPrice();
		}
		return tot;
	}
}
