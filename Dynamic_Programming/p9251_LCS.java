package Dynamic_Programming;

import java.util.*;

public class p9251_LCS {

	public static void main(String[] args) {
		String str1, str2;
		int[][] dp = new int[1001][1001];
		
		Scanner sc  = new Scanner(System.in);
		
		str1 = sc.next();
		str2 = sc.next();
		
		int size1 = str1.length()+1;
		int size2 = str2.length()+1;
		
		for(int i=1; i<size1; i++) {
			for(int j=1; j<size2; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[size1-1][size2-1]);

	}
}
