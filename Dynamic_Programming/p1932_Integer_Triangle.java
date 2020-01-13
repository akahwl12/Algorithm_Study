package Dynamic_Programming;

import java.util.*;

public class p1932_Integer_Triangle {

	static int n, maxx=0;
	static int[][] map = new int[501][501];
	static int[][] dp = new int[501][501];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				map[i][j] = sc.nextInt();
				
				if(i==1 && j==1)	dp[i][j] = map[i][j];
				else if(j==1)		dp[i][j] = dp[i-1][j] + map[i][j];
				else if(j==i)		dp[i][j] = dp[i-1][j-1] + map[i][j];
				else				dp[i][j] = Math.max(dp[i-1][j] + map[i][j], dp[i-1][j-1] + map[i][j]);
				
				if(maxx<dp[i][j])	maxx = dp[i][j];
			}
		}
	
		System.out.println(maxx);
	}
}
