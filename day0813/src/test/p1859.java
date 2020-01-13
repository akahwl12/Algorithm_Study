package test;

import java.util.Scanner;

public class p1859 {
	
	static int T, N;
	static int[] days;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			days = new int[N];
			for (int i = 0; i < N; i++) {
				days[i] = sc.nextInt();
			}
			
		}
	}
}
