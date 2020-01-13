package Dynamic_Programming;

import java.util.*;

public class p2293_Coin1 {

	public static void main(String[] args) {
		int [] dp = new int[10001];
		int [] coin = new int[101];
		int n, k;
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			coin[i] = sc.nextInt();
		}
		
		dp[0] = 1; 
		for (int i = 0; i < n; i++) { 
			for (int j = coin[i]; j <= k; j++) { 
				dp[j] = dp[j] + dp[j - coin[i]]; 
			} 
		}

		System.out.println(dp[k]);
		
	}

}
