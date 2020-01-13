package dfs_bfs;

import java.util.*;

public class p1890_Jump {

	static int N;
	static int map[][] = new int[101][101];
	static Queue<Integer> qx = new LinkedList();
	static Queue<Integer> qy = new LinkedList();
	static int dx[] = {0, 0};
	static int dy[] = {0, 0};
	
	
	public static int bfs() {
		int x, y;
		int nx, ny;
		
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
			dx[0] = map[x][y];
			dy[1] = map[x][y];
			for(int i=0; i<2; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || nx > N-1 || ny < 0 || ny > N-1) continue;
				else {
					if(nx == N-1 && ny == N-1) {
						map[nx][ny] += 1;
						break;
					}
					qx.offer(nx);
					qy.offer(ny);
				}
			}
		}
		
		return map[N-1][N-1];
	}
	
	public static void main(String[] args) {
		int res;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[j][i] = sc.nextInt();
			}
		}
		
		qx.offer(0);
		qy.offer(0);
		
		res = bfs();

		System.out.println(res);
	}

}
