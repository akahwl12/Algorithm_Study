package ssafy1007;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b_p17472_다리만들기2 {
	static int N, M, ans, cnt=0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<Edge> mst = new ArrayList<>();; 
	static int[] disjoint;
	static LinkedList<Point> queue = new LinkedList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					queue.add(new Point(i, j));
					cnt++;
					bfs();
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0)
					makeLine(new Point(i, j));
			}
		}
		
		kruskal();
		
		if(mst.size()!=cnt-1)
			System.out.println("-1");
		else {
			for (int i = 0; i < mst.size(); i++) {
				ans += mst.get(i).weight;
			}
			System.out.println(ans);
		}
	}
	
	static void kruskal() {
		if(pq.isEmpty())
			return;
		
		disjoint = new int[cnt+1];
		
		for (int i = 1; i <= cnt; i++) {
			disjoint[i] = i;
		}
		
		while(mst.size() < (cnt-1) && !pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				mst.add(edge);
			}
		}
	}
	
	static int find(int n) {
		if(disjoint[n] == n)
			return n;
		disjoint[n] = find(disjoint[n]);
		return disjoint[n];
	}
	
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2)
			disjoint[p1] = p2;
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			map[now.x][now.y] = cnt;
			visited[now.x][now.y] = true;
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M && map[nx][ny]==1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Point(nx, ny));
				}
			}
		}
	}
	
	static void makeLine(Point now) {
		int x = now.x;
		int y = now.y;
		
		for (int i = 0; i < 4; i++) {
			int dist = 0;
			int nx = x + dx[i];
			int ny = y + dy[i];
			while(0<=nx && nx<N && 0<=ny && ny<M && map[nx][ny]==0) {
				nx = nx + dx[i];
				ny = ny + dy[i];
				dist++;
			}
			if(0<=nx && nx<N && 0<=ny && ny<M && dist>1 && map[now.x][now.y]!=map[nx][ny]) {
				pq.add(new Edge(map[x][y], map[nx][ny], dist));
			}
		}
	}
	
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;
		
		Edge(int s, int e, int w) {
			start = s;
			end = e;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
