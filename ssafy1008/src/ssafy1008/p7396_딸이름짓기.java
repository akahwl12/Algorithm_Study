package ssafy1008;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class p7396_딸이름짓기 {
	static int T, N, M;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static String ans;
	static String[][] memo;
	static boolean[][] visited;
	static char[][] map;
	static LinkedList<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ans = "z";
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new char[N][M];
			memo = new String[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				String input = sc.next();
				map[i] = input.toCharArray();
				Arrays.fill(memo[i], "");
			}
			memo[0][0] = map[0][0]+"";
			
			queue.add(new Point(0, 0));
			bfs();
			
			System.out.println("#" + tc + " " + memo[N-1][M-1]);
		}
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x;
			int y = now.y;
			
			if(x==N-1 && y==M-1)
				return;
			
			visited[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					System.out.println(memo[nx][ny] + " : " + memo[x][y] + map[nx][ny]);
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new Point(nx, ny));
						memo[nx][ny] = memo[x][y] + map[nx][ny];
					}
					else if(visited[nx][ny]) {
						if(memo[nx][ny].compareTo(memo[x][y] + map[nx][ny])>0)
							memo[nx][ny] = memo[x][y] + map[nx][ny];
					}
				}
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
