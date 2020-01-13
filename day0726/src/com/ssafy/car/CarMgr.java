package com.ssafy.car;

public class CarMgr extends Car{
	private static CarMgr carMgr = new CarMgr();
	private CarMgr() {};
	public static CarMgr getInstance() {
		return carMgr;
	}
	
	private Car[] cars = new Car[100];
	private int index = 0;
	
//	�������� ����Ʈ
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
	
//	�Ķ���ͷ� ���޵� ���� ������ �迭�� �����Ѵ�.
	public void add(Car c) {
		if(index>0 && index<=100)
			cars[index++] = c;
	}
	
//	���� ����� ��� ���� ������ �����Ѵ�.
	public Car[] search() {
		Car[] tmp = new Car[100];
		int idx = 0;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null)
				tmp[idx++] = cars[i];
		}
		return tmp;
	}
	
//	�Ķ���ͷ� ���޵� ��ȣ�� ���� ���� ������ �����Ѵ�.
	public Car search(String num) {
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null && cars[i].getNum().equals(num))
				return cars[i];
		}
		return null;
	}
	
//	�Ķ���ͷ� ���޵� ���ݺ��� ���� ���� �������� �����Ѵ�.
	public Car[] search(int price) {
		Car[] tmp = new Car[100];
		int idx = 0;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null && cars[i].getPrice() <= price)
				tmp[idx++] = cars[i];
		}
		return tmp;
	}
	
//	�Ķ���ͷ� ���޵� ��ȣ�� ������ �˻��Ͽ� ������ �����Ѵ�.
	public void update(String num, int price) {
		boolean check = false;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null && cars[i].getNum().equals(num)) {
				cars[i].setPrice(price);
				check = true;
			}
		}
		if(!check)
			System.out.println("�ش� ������ �����ϴ�.");
	}
	
//	�Ķ���ͷ� ���޵� ��ȣ�� ������ �����Ѵ�.
	public void delete(String num) {
		boolean check = false;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null && cars[i].getNum().equals(num)) {
				cars[i] = null;
				check = true;
			}
		}
		if(!check)
			System.out.println("�ش� ������ �����ϴ�.");
	}
	
//	�迭�� ����� ���� ����� �����Ѵ�.
	public int size() {
		int cnt=0;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null)
				cnt++;
		}
		return cnt;
	}
	
//	�迭�� ����� ������ �ݾ� �հ踦 ����Ͽ� �����Ѵ�.
	public int totalPrice() {
		int tot=0;
		for (int i = 0; i < cars.length; i++) {
			if(cars[i]!=null)
				tot+=cars[i].getPrice();
		}
		return tot;
	}
}
