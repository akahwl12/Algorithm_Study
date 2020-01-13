package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test02_BFS {
	static int V, E; // V:정점 개수, E:간선 개수
	static boolean[][] graph;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	
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
		
		queue.add(1);
		bfs();
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			visited[now] = true;
			
			for (int i = 1; i <= V; i++) {
				if(!visited[i] && graph[now][i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}
