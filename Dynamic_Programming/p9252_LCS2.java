package Dynamic_Programming;

import java.util.Scanner;

public class p9252_LCS2 {

	public static void main(String[] args) {
		String str1, str2, str3="";
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
		
		int i = size1-1, j = size2-1;
		while(i>0&&j>0) {
			if(dp[i][j] == dp[i][j-1])
				j--;
			else {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					str3 += str2.charAt(j-1);
					i--;
					j--;
				}
				else {
					i--;
				}
			}
		}
		
		System.out.println(dp[size1-1][size2-1]);
		for(int k=str3.length()-1; k>=0; k--) {
			System.out.print(str3.charAt(k));
		}

	}
}
