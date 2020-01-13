package practice;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class p1859 {
	static int T, N, cnt, sum, ans, tmp;
	static List<Integer> list = new ArrayList<>();
	static List<Integer> max_list = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			list.clear();
			max_list.clear();
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				int data = sc.nextInt();
				list.add(data);
			}
			max_list = list;
			Collections.sort(max_list);
			System.out.println(list);
			System.out.println(max_list);
		}
	}
}
