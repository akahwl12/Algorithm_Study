package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class p8191 {
	static int T, N, ans, idx;
	static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = idx = 0;
			list.clear();
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			
			while(!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i)==(idx+1)) {
						idx++;
					}
				}
				ans++;
			}
			System.out.println("#"+ t + " "  + (ans));
		}
	}
	
	
}
