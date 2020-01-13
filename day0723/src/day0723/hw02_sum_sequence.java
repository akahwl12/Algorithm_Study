package day0723;

import java.util.Scanner;

public class hw02_sum_sequence {
	
	static int T, N, K, ans;
	static int[] seq;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			seq = new int[N];
			for (int i = 0; i < N; i++) {
				seq[i] = sc.nextInt();
			}
			
			ans = 0;
			for (int i = 0; i < 1<<seq.length; i++) {
				int sum = 0;
				for (int j = 0; j < seq.length; j++) {
					if(((1<<j)&i) != 0) {
						sum += seq[j];
					}
				}
				if(sum==K)
					ans++;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
