package ssafy1015;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class b_p16234_인구이동 {
	
	static int N, L, R, tmp, cnt, ans;
	static int[][] map;
	static boolean[][] visited;
	static LinkedList<Point> queue = new LinkedList<>();
	static ArrayList<Point> list = new ArrayList<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						cnt++;
						queue.add(new Point(i, j));
						list.clear();
						tmp = 0;
						bfs();
						for (int k = 0; k < list.size(); k++) {
							Point move = list.get(k);
							map[move.x][move.y]= tmp / list.size(); 
						}
					}
				}
			}
			if(cnt==N*N)
				break;
			ans++;
		}
		
		System.out.println(ans);
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x;
			int y = now.y;
			
			visited[x][y] = true;
			list.add(now);
			tmp += map[x][y];
			
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny]) {
					if(L<=Math.abs(map[nx][ny]-map[x][y]) && Math.abs(map[nx][ny]-map[x][y])<=R) {
						visited[nx][ny] = true;
						queue.add(new Point(nx, ny));
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