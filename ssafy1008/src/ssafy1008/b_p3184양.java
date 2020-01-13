package ssafy1008;

import java.util.LinkedList;
import java.util.Scanner;

public class b_p3184양 {
	static int R, C, v, o, sheep, wolf;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static LinkedList<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = sc.next();
			map[i] = input.toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visited[i][j]) {
					v = o = 0;
					queue.add(new Point(i, j));
					bfs();
					if(o>v)
						sheep += o;
					else
						wolf += v;
				}
			}
		}
		
		System.out.println(sheep + " " +  wolf);
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x;
			int y = now.y;
			
			if(map[x][y]=='v')
				v++;
			else if(map[x][y]=='o')
				o++;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<R && 0<=ny && ny<C && map[nx][ny]!='#' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Point(nx, ny));
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
