package ssafy1001;

import java.util.LinkedList;
import java.util.Scanner;

public class b_p3109_빵집 {
	static int R, C, ans;
	static boolean find;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	static LinkedList<Point> queue = new LinkedList<>();
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			StringBuilder sb = new StringBuilder(sc.next());
			for (int j = 0; j < C; j++) {
				map[i][j] = sb.charAt(j);
				
				if(j==0) {
					queue.add(new Point(i, j));
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			find = false;
			dfs(new Point(i, 0));
		}
		
		System.out.println(ans);
	}
	
	static void dfs(Point now) {
		if(find)
			return;
		if(visited[now.x][now.y])
			return;
		
		visited[now.x][now.y]= true;
		
		if(now.y==C-1) {
			ans++;
			find = true;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = now.x + dx[i];
			int ny = now.y + dy[i];
			if(0<=nx && nx<R && 0<=ny && ny<C && map[nx][ny]!='x') {
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
