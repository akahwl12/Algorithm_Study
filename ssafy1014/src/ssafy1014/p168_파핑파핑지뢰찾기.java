package ssafy1014;

import java.util.LinkedList;
import java.util.Scanner;

public class p168_파핑파핑지뢰찾기 {
	static int T, N, ans, total_dot;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
	static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
	static boolean[][] visited;
	static LinkedList<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			ans = 0;
			N = sc.nextInt();
			map = new char[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String input = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j);
					if(map[i][j]=='.')
						total_dot++;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') {
						ans++;
						queue.add(new Point(i, j));
						bfs();
						for (int a = 0; a < N; a++) {
							for (int b = 0; b < N; b++) {
								System.out.print(map[a][b] + " ");
							}
							System.out.println();
						}
						System.out.println();
					}
				}
			}
			
			System.out.println(ans);
		}
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x;
			int y = now.y;
			
			map[x][y] = '-';
			
			if(check(x, y)) {
				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny]) {
						map[nx][ny] = '-';
						visited[nx][ny] = true;
						queue.add(new Point(nx, ny));
					}
				}
			}
			
		}
	}
	
	static boolean check(int x, int y) { // 8방향의 점을 카운팅
		boolean isOk= true;
		int dot = 0;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				if(map[nx][ny]!='.' && map[nx][ny]!='-')
					isOk = false;
				else if(map[nx][ny]=='.')
					dot++;
			}
		}
		
		if(isOk) {
			total_dot-=dot;
		}
		
		return isOk;
	}
	
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
