package dfs_bfs;

import java.util.*;

public class p2606_virus_dfs {

	static int maxx, M, cnt=0;
	static ArrayList<Integer>[] ar = new ArrayList[101];
	static boolean[] visited = new boolean[101];
	
	public static void dfs(int start) {
		int y;
		cnt++;
		
		if(visited[start]) return;
		visited[start] = true;
		
		for(int i=0; i<ar[start].size(); i++) {
			y = ar[start].get(i);
			if(!visited[y])
				dfs(y);
		}
	}
	
	public static void main(String[] args) {
		int a, b;
		
		Scanner sc = new Scanner(System.in);
		
		maxx = sc.nextInt();
		M = sc.nextInt();
		
		for(int i=1; i<=maxx; i++) {
			ar[i] = new ArrayList();
		}
		
		for(int i=0; i<M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			ar[a].add(b);
			ar[b].add(a);
		}
		
		dfs(1);
		
		System.out.println(cnt-1);
	}
}