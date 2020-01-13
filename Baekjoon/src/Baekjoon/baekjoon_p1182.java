package Baekjoon;

import java.util.Scanner;

public class baekjoon_p1182 {
	static int N, S, ans;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		dfs(0, 0, true);
		
		System.out.println(ans);
	}
	
//	public static void dfs(int idx, int sum, boolean doSum, boolean sumZero) {
//		if(idx >= N)
//			return;
//		
//		if(doSum) {
//			sum += num[idx];
//			sumZero = false;
//		}
//		
//		dfs(idx+1, sum, true, sumZero);
//		dfs(idx+1, sum, false, sumZero);
//		
//		if(idx==(N-1) && !sumZero && sum==S) {
//			ans++;
//		}
//	}
	
	public static void dfs(int idx, int sum, boolean sumZero) {
		if(idx==N && !sumZero && sum==S) {
			ans++;
			return;
		}
		if(idx >= N)
			return;
		// 더했어
		dfs(idx+1, sum+num[idx], false);
		// 안더했어
		dfs(idx+1, sum, sumZero);
	}
}
