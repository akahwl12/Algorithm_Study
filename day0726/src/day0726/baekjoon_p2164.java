package day0726;

import java.util.LinkedList;
import java.util.Scanner;

public class baekjoon_p2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		while(list.size()>1) {
			list.pop();
			int num = list.get(0);
			list.pop();
			list.add(num);
		}
		System.out.println(list.get(0));
		
	}
}