package test;

import java.util.Scanner;

public class Test01_DFS {
	static int V, E; // V:정점 개수, E:간선 개수
	static boolean[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		graph = new boolean[V+1][V+1];
		visited = new boolean[V+1];
		for (int i = 0; i < E; i++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			graph[v][e] = true;
			graph[e][v] = true;
		}
		
		dfs(1);
	}
	
	static void dfs(int now) {
		if(visited[now])return;
		
		visited[now] = true;
		System.out.print(now + " ");
		
		for (int i = 1; i < graph[now].length; i++) {
			if(graph[now][i]) {
				dfs(i);
			}
		}
	}
}
