package Dynamic_Programming;

import java.util.*;

public class p2579_upstair {

	static int n;
	static int[] map = new int[301];
	static int[] dp = new int[301];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			map[i] = sc.nextInt();
		}
		
		dp[0]=0;
		dp[1] = map[1];
		dp[2] = map[1] + map[2];
		dp[3] = Math.max(map[1] + map[3], map[2] + map[3]);
		
		for(int i=4; i<=n; i++) {
			dp[i] = Math.max(dp[i-2] + map[i], map[i] + map[i-1] + dp[i-3]);
		}
		
		System.out.println(dp[n]);
	}
}