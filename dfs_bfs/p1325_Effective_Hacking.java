package dfs_bfs;

import java.util.*;

public class p1325_Effective_Hacking {

	static int maxx = -1;
	static Queue<Integer> q = new LinkedList();
	static ArrayList<Integer> arr[] = new ArrayList[10001];
	static int val[] = new int[10001];
	
	public static void bfs() {
		int x, y;
		while(!q.isEmpty()) {
			x = q.poll();
			for(int i=0; i<arr[x].size(); i++) {
				y = arr[x].get(i);
				if(!q.contains(y)) {
					q.offer(y);
				}
				for(int j=0; j<arr[y].size(); j++) {
					if(!arr[x].contains(arr[y].get(j))) {
						arr[x].add(arr[y].get(j));
					}
				}
				if(maxx<arr[x].size()) {
					maxx = arr[x].size();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int N, M, a, b;
		
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList();
		}
		
		for(int i=0; i<M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			arr[b].add(a);
			if(!q.contains(b)) {
				q.offer(b);
			}
		}
		
		bfs();
		
		for(int i=1; i<=N; i++) {
			val[i] = arr[i].size();
			if(val[i] == maxx) {
				System.out.print(i+" ");
			}
		}
	}
}
