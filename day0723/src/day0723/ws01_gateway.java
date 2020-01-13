package day0723;

import java.util.Scanner;

public class ws01_gateway {
	
	static int[] map = new int[300002];
	static int T, N, D, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			D = sc.nextInt();
			map[0] = map[N+1] = 1;
			
			for (int i = 1; i <= N; i++) {
				map[i] = sc.nextInt();
			}
			
			int i=1, cnt=0, ans=0;
			while(i<=N) {
				if(map[i]==1) {
					cnt=0;
				}
				if(map[i]==0) {
					cnt++;
				}
				if(cnt==D) {
					cnt=0;
					ans++;
				}
				i++;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
