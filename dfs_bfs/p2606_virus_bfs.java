package dfs_bfs;

import java.util.*;

public class p2606_virus_bfs {
	static int maxx, M, y;
	static ArrayList<Integer> ar[] = new ArrayList[101];
	static boolean[] visited = new boolean[101];
	
	public static int bfs(int start) {
		int x, cnt=0;
		Queue<Integer> q = new LinkedList();
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			cnt++;
			x = q.poll();
			//System.out.println(x);
			for(int i=0; i<ar[x].size(); i++) {
				y = ar[x].get(i);
				if(!visited[y]) {
					q.offer(y);
					visited[y] = true;
				}
			}
		}
		return cnt-1;
	}
	
	public static void main(String[] args) {
		int a, b;
		
		Scanner sc = new Scanner(System.in);
		maxx = sc.nextInt();
		M = sc.nextInt();
		
		for(int i=1; i<=maxx; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			ar[a].add(b);
			ar[b].add(a);
		}
		
		System.out.println(bfs(1));
	}
}
