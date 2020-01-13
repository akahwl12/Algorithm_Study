package samsung_software;

import java.util.*;

public class p3282_knapsack {

	public static void main(String[] args) {
		int T, N, K;
		int[] V = new int[1001];
		int[] C = new int[1001];
		int[] dp = new int[1001];
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			for(int j=1; j<=N; j++) {
				V[j] = sc.nextInt();
				C[V[j]] = sc.nextInt();
			}
			
			for(int j=1; j<=N; j++) {
				for(int k=V[j]; k<=K; k++) {
						dp[k] = Math.max(dp[k-1], C[V[j]] + C[k-V[j]]);
						System.out.print("(V[j]: "+ V[j] + ", k: " + k + ") dp[k] : " + dp[k] + "/ ");
				}
				System.out.println();
			}
			
			for(int j=0; j<K; j++) {
				System.out.print(dp[j] + " ");
			}
			
			System.out.println(dp[K]);
		}
	}
}
