package Ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_p17244 {
	static int N, M, ans = Integer.MAX_VALUE, min, umb, cnt=0;
	static Point start, end;
	static char[][] map;
	static int[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static Queue<Point> queue = new LinkedList<>();
	static ArrayList<Point> X_idx = new ArrayList<>();
	static boolean used[];
	static int perm_rst[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		map = new char[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='S') {
					start = new Point(i, j);
					queue.add(start);
				}
				if(map[i][j]=='X') {
					X_idx.add(new Point(i, j));
				}
				if(map[i][j]=='E') {
					end = new Point(i, j);
				}
			}
		}
		umb = X_idx.size();
		used = new boolean[umb];
		perm_rst = new int[umb];
		perm();
		
		System.out.println(ans);
	}
	
	static void perm() {
		for (int i = 0; i < umb; i++) {
			if(!used[i]) {
				used[i] = true;
				perm_rst[cnt++] = i;
				perm();
				used[i] = false;
				cnt--;
			}
		}
		if(cnt==umb) {
			for (int i = 0; i < umb; i++) {
				bfs(X_idx.get(perm_rst[i]));
			}
			bfs(end);

			ans = Math.min(ans, min);
			min = 0;
			queue.clear();
			queue.add(start);
		}
	}
	
	static void bfs(Point goal) {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x;
			int y = now.y;
			
			if(goal.x == x && goal.y ==y) {
				min += visited[x][y];
				visited = new int[N][M];
				queue.clear();
				queue.add(now);
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M && visited[nx][ny]==0 && map[nx][ny]!='#') {
					visited[nx][ny] = visited[x][y]+1;
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
