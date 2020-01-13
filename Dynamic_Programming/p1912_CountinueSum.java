package Dynamic_Programming;

import java.util.*;

public class p1912_CountinueSum {

	public static void main(String[] args) {
		int N, maxx=-1001;
		int[] arr = new int[100001];
		int[] dp = new int[100001];
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			if(dp[i]>maxx)	maxx = dp[i];
		}
		
		System.out.println(maxx);
	}

}
