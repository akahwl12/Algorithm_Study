package test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ws01_ws02_Test {
	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<>();	// 순회 작업에 유리
//		LinkedList<Integer> list = new LinkedList<>();	// 삽입/삭제 작업에 유리
		ws01_MyLinkedList_self<Integer> list = new ws01_MyLinkedList_self<>();
		
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(1, 400);
		list.add(600);
		list.add(700);
		list.add(900);
		list.add(230);
		list.add(500);
		
		list.remove(2);
		
		System.out.println(list);
		System.out.println(list.size());
		
		insertionSort(list);
		System.out.println(list);
	}
	
	public static void insertionSort(ws01_MyLinkedList_self<Integer> list) {	//삽입 정렬
		for (int i = 0; i < list.size(); i++) {
			int j=0;
			while(list.get(j) < list.get(i)) {
				j++;
			}
			list.add(j, list.get(i));
			list.remove(i+1);
		}
	}
}
