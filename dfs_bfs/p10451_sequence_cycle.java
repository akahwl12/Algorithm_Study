package dfs_bfs;

import java.util.*;

public class p10451_sequence_cycle {

	static int cnt = 1;
	static int[] map = new int[1001];
	static boolean[] visit = new boolean[1001];
	
	public static void dfs(int a) {
		if(visit[a]) return;
		visit[a] = true;
		if(!visit[map[a]]) {
			dfs(map[a]);
		}
		
		map[a] = cnt;
	}
	
	public static void main(String[] args) {
		int T, N;

		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			N = sc.nextInt();
			for(int i=1; i<=N; i++) {
				map[i] = sc.nextInt();
				if(!visit[i]) {
					dfs(i);
					cnt++;
				}
			}
			for(int i=1; i<=N; i++) {
				System.out.print(map[i]);
			}
			System.out.println();
		}
	}

}
