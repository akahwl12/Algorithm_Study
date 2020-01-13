package practice;

import java.util.LinkedList;
import java.util.Scanner;

public class b_p1520_내리막길_dfs {
	static int M, N, ans, cnt=1;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static LinkedList<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[M][N];
		dp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		queue.add(new Point(0, 0));
		
		bfs();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
//		System.out.println(dp[0][0]);
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			dp[now.x][now.y]++;
			
			if(now.x==M-1 && now.y==N-1)
				continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(0<=nx && nx<M && 0<=ny && ny<N && map[now.x][now.y] > map[nx][ny]) {
					queue.add(new Point(nx, ny));
				}
			}
		}
	}
	
	static void dfs(Point now) {
		dp[now.x][now.y]++;
		
		if(now.x==M-1 && now.y==N-1)
			return;
		
		for (int i = 0; i < 4; i++) {
			int nx = now.x + dx[i];
			int ny = now.y + dy[i];
			if(0<=nx && nx<M && 0<=ny && ny<N && map[now.x][now.y] > map[nx][ny]) {
				dfs(new Point(nx, ny));
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
}
