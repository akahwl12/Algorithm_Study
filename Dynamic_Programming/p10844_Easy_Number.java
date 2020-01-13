package Dynamic_Programming;

import java.util.*;

public class p10844_Easy_Number {

	public static void main(String[] args) {
		int n;
		long sum=0;
		long[][] dp = new long [101][10];
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		dp[1][0] = 0;
		for(int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0)		dp[i][j] = dp[i-1][j+1];
				else if(j==9)	dp[i][j] = dp[i-1][j-1];
				else			dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
				
				dp[i][j] %= 1000000000;
			}
		}
		
		for(int i=0; i<=9; i++) {
			sum += dp[n][i];
		}
		System.out.println(String.valueOf(sum%1000000000));
	}

}
