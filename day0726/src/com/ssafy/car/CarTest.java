package com.ssafy.car;

import java.util.Arrays;

public class CarTest {
	public static void main(String[] args) {
		// 싱글톤 : 클래스 객체를 여러번 생성해도 하나의 객체의 인스턴스만 보내준다.
		CarMgr cm = CarMgr.getInstance();
		CarMgr cm2 = CarMgr.getInstance();
		
		cm.add(new Truck("01", "A-트럭", 1300, 4));
		cm.add(new Bus("02", "A-버스", 1000, 25));
		cm.add(new Truck("03", "B-트럭", 2000, 2));
		cm.add(new Bus("04", "B-버스", 2500, 30));
		cm.add(new Bus("05", "C-버스", 800, 15));
		cm.add(new Bus("06", "C-트럭", 1800, 3));
		cm.add(new Bus("07", "D-트럭", 1700, 20));
		cm.add(new Bus("08", "D-버스", 3000, 24));
		cm.add(new Bus("09", "E-버스", 2800, 20));
		cm.add(new Bus("10", "E-트럭", 900, 2)); 
		cm.print(cm.search());

		System.out.println("파라메터로 전달된 번화와 같은 차량정보를 리턴");
		cm.print(cm.search("04"));
		
		System.out.println("파라메터로 전달된 가격보다 작은 차량 정보들을 리턴");
		cm.print(cm.search(2000));
		
		System.out.println("파라메터로 전달된 번호의 차량을 검색하여 가격을 수정(void)");
		System.out.println("변경전");
		cm.print(cm.search("03"));
		cm.update("03", 9999);
		System.out.println("변경후");
		cm.print(cm.search("03"));
		
		System.out.println("파라메터로 전달된 번호의 차량을 삭제(void)");
		System.out.println("삭제전");
		cm.print(cm.search());
		cm.delete("05");
		System.out.println("삭제후");
		cm.print(cm.search());
		
		System.out.println("배열에 저장된 차량 대수를 리턴");
		System.out.println("저장된 정보 갯수 : " + cm.size());
		
		System.out.println("배열에 저장된 차량의 금액 합계");
		System.out.println("금액 합계 : " + cm.totalPrice());
	}
}
