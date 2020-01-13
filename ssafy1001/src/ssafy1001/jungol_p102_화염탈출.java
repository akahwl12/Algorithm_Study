package ssafy1001;

import java.util.LinkedList;
import java.util.Scanner;

public class jungol_p102_화염탈출 {
	static int R, C, cnt;
	static String ans = "impossible"; //KAKTUS
	static boolean find;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static char[][] map;
	static boolean[][] visited;
	static Point start, end;
	static LinkedList<Point> queue = new LinkedList<>();
	
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
				if(map[i][j]=='D')
					end = new Point(i, j);
				else if(map[i][j]=='S') {
					start = new Point(i, j);
				}
				else if(map[i][j]=='*') {
					queue.add(new Point(i, j));
				}
			}
		}
		queue.add(0, start);
		
		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			cnt++;
			int size = queue.size();
			for (int c = 0; c < size; c++) {
				Point now = queue.poll();
				
				visited[now.x][now.y]= true; 
				
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					
					if(0<=nx && nx<R && 0<=ny && ny<C && map[nx][ny]!='X') {
						if(map[now.x][now.y]=='*' && map[nx][ny]=='D')
							continue;
						if(map[now.x][now.y]=='*' && map[nx][ny]=='S'&& visited[nx][ny]) {}
						else if(visited[nx][ny])
							continue;
						if(map[nx][ny]=='D') {
							ans = Integer.toString(cnt);
							find = true;
							break;
						}
						
						visited[nx][ny] = true;
						map[nx][ny] = map[now.x][now.y];
						
						queue.add(new Point(nx, ny));
					}
				}
				if(find)
					break;
			}
			if(find)
				break;
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
