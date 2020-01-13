package ssafy1010;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b_p16236_아기상어 {
	static int N, size=2, eat, ans;
	static int[][] map;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static boolean[][] visited;
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	static LinkedList<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==9) {
					queue.add(new Point(i, j));
					map[i][j]=0;
				}
			}
		}
		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		if(!check())
			return;
		int cnt=0;
		while(!queue.isEmpty()) {
			int q_size = queue.size();
			for (int q = 0; q < q_size; q++) {
				Point now = queue.poll();
				
				int x = now.x;
				int y = now.y;
				
				if(map[x][y]!=0 && map[x][y]<size) {
					pq.add(new Point(x, y));
					
				}
				
				visited[x][y] = true;
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(0<=nx && nx<N && 0<=ny && ny<N && map[nx][ny]<=size && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new Point(nx, ny));
					}
				}
			}
			
			if(!pq.isEmpty()) {
				map[pq.peek().x][pq.peek().y] = 0;
				ans += cnt;
				cnt = -1;
				eat++;
				if(eat==size) {
					size++;
					eat = 0;
				}
				if(!check())
					return;
				queue.clear();
				queue.add(pq.peek());
				visited = new boolean[N][N];
				visited[pq.peek().x][pq.peek().y] = true;
				pq.clear();
			}
			
			cnt++;
		}
	}
	
	static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=0 && map[i][j]<size)
					return true;
			}
		}
		return false;
	}
	
	static class Point implements Comparable<Point>{
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if(this.x > o.x)
				return 1;
			else if(this.x < o.x)
				return -1;
			else {
				if(this.y > o.y)
					return 1;
				else if(this.y < o.y)
					return -1;
				else
					return 0;
			}
		}
	}
}
