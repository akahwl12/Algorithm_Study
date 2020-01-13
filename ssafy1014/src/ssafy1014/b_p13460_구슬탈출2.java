package ssafy1014;

import java.util.Scanner;

public class b_p13460_구슬탈출2 {
	
	static char[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visit;
	static int N, M, ans=Integer.MAX_VALUE;
	static Point red, blue, end;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(i);
				if(map[i][j]=='R')
					red = new Point(i, j);
				else if(map[i][j]=='B')
					blue = new Point(i, j);
				else if(map[i][j]=='O')
					end = new Point(i, j);
			}
		}
		
	}
	
	static void dfs(Point r, Point b, int cnt) {
		int rx = r.x;	int ry = r.y;
		int bx = b.x;	int by = b.y;
		
		if(visit[rx][ry])
			return;
		
		visit[rx][ry] = true;
		
		for (int i = 0; i < 4; i++) {
			int nrx = rx + dx[i];	int nry = ry + dy[i];
			int nbx = bx + dx[i];	int nby = by + dy[i];
			
			if(1<=nrx && nrx<N-2 && 1<=nry && nry<N-2 && 1<=nbx && nbx<N-2 && 1<=nby && nby<N-2 && !visit[nrx][nry]) {
				cnt++;
				if(map[nrx][nry]=='O') {
					while(1<=nbx && nbx<N-2 && 1<=nby && nby<N-2) {
						
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
