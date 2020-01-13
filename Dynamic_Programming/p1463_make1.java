package Dynamic_Programming;

import java.util.*;

public class p1463_make1 {
	
	public static void main(String[] args) {
		int n;
		int[] dp = new int[1000001];
		
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		
		dp[1] = 0;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%3==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			else if(i%2==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
		}
		
		System.out.println(dp[n]);
	}

}
