package ssafy1007;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class p1249_보급로 {
	static int T, N, ans;
	static int[][] map;
	static int[][] memory;
	static LinkedList<Point> queue = new LinkedList<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			memory = new int[N][N];
			
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				String input = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input.charAt(j)+"");
				}
				Arrays.fill(memory[i], Integer.MAX_VALUE);
			}
			
			queue.add(new Point(0, 0));
			bfs();
			
//			dfs(new Point(0, 0), 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x;
			int y = now.y;
			
			if(x==N-1 && y==N-1) {
				ans = memory[x][y];
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N && memory[nx][ny]>memory[x][y]+map[nx][ny]) {
					memory[nx][ny] = map[x][y] + map[nx][ny];
					queue.add(new Point(nx, ny));
				}
			}
		}
	}
	
	static void dfs(Point now, int dist) {
		int x = now.x;
		int y = now.y;
		memory[x][y] = dist + map[x][y];
		
		if(x==N-1 && y==N-1) {
			ans = Math.min(ans, dist);
			return;
		}
			
		if(dist>=ans)
			return;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<=nx && nx<N && 0<=ny && ny<N && memory[nx][ny]>memory[x][y]+map[nx][ny]) {
				dfs(new Point(nx, ny), memory[x][y]);
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
