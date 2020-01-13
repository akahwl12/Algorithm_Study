package com.ssafy.movie;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		MovieMgr mm = MovieMgr.getInstance();
		
		Scanner sc = mm.sc;
		
		int option = -1;
		mm.add(new Movie("�����", "����ȣ", 5, "������", "����ؼ� ���."));
		mm.add(new Movie("���̿�ŷ", "���̿�", 3, "��ť", "����"));
		mm.add(new Movie("�˶��", "����", 5, "��Ÿ��", "������ ��ź��"));
		mm.add(new Movie("�����̴���", "����", 2, "��Ÿ��", "���� ���"));
		while(option!=0) {
			System.out.println("<<< ��ȭ ���� ���α׷� >>>");
			System.out.println("1. ��ȭ ���� �Է�");
			System.out.println("2. ��ȭ ���� ��ü �˻�");
			System.out.println("3. ��ȭ�� �˻�");
			System.out.println("4. ��ȭ �帣�� �˻�");
			System.out.println("5. ��ȭ ���� ����");
			System.out.println("0. ����");
			System.out.println("���ϴ� ��ȣ�� �����ϼ��� ==> ");
			option = sc.nextInt();
			sc.nextLine();
			
			switch (option) {
				case 0:
					break;
				case 1:
					System.out.println("���� ���� ���� �帣 ��� ������ �Է����ּ���");
					mm.add(mm.setInfo());
					break;
				case 2:
					mm.print(mm.search());
					break;
				case 3:
					System.out.println("ã�� ��ȭ�� ������ �Է����ּ��� : ");
					mm.print(mm.search(sc.next()));
					break;
				case 4:
					System.out.println("ã�� ��ȭ �帣�� �Է����ּ��� : ");
					mm.print(mm.searchGenre(sc.next()));
					break;
				case 5:
					System.out.println("������ ��ȭ ������ �Է����ּ���");
					mm.delete(sc.next());
					break;
				default:
					System.err.println("�Է¹��� �ʰ�!! �ٽ� �Է����ּ���!!");
					break;
			}
			
		}
	}
}
