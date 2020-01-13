package com.ssafy.car;

import java.util.Arrays;

public class CarTest {
	public static void main(String[] args) {
		// �̱��� : Ŭ���� ��ü�� ������ �����ص� �ϳ��� ��ü�� �ν��Ͻ��� �����ش�.
		CarMgr cm = CarMgr.getInstance();
		CarMgr cm2 = CarMgr.getInstance();
		
		cm.add(new Truck("01", "A-Ʈ��", 1300, 4));
		cm.add(new Bus("02", "A-����", 1000, 25));
		cm.add(new Truck("03", "B-Ʈ��", 2000, 2));
		cm.add(new Bus("04", "B-����", 2500, 30));
		cm.add(new Bus("05", "C-����", 800, 15));
		cm.add(new Bus("06", "C-Ʈ��", 1800, 3));
		cm.add(new Bus("07", "D-Ʈ��", 1700, 20));
		cm.add(new Bus("08", "D-����", 3000, 24));
		cm.add(new Bus("09", "E-����", 2800, 20));
		cm.add(new Bus("10", "E-Ʈ��", 900, 2)); 
		cm.print(cm.search());

		System.out.println("�Ķ���ͷ� ���޵� ��ȭ�� ���� ���������� ����");
		cm.print(cm.search("04"));
		
		System.out.println("�Ķ���ͷ� ���޵� ���ݺ��� ���� ���� �������� ����");
		cm.print(cm.search(2000));
		
		System.out.println("�Ķ���ͷ� ���޵� ��ȣ�� ������ �˻��Ͽ� ������ ����(void)");
		System.out.println("������");
		cm.print(cm.search("03"));
		cm.update("03", 9999);
		System.out.println("������");
		cm.print(cm.search("03"));
		
		System.out.println("�Ķ���ͷ� ���޵� ��ȣ�� ������ ����(void)");
		System.out.println("������");
		cm.print(cm.search());
		cm.delete("05");
		System.out.println("������");
		cm.print(cm.search());
		
		System.out.println("�迭�� ����� ���� ����� ����");
		System.out.println("����� ���� ���� : " + cm.size());
		
		System.out.println("�迭�� ����� ������ �ݾ� �հ�");
		System.out.println("�ݾ� �հ� : " + cm.totalPrice());
	}
}
