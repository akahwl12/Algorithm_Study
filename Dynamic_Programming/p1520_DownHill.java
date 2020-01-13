package Dynamic_Programming;

import java.util.*;

public class p1520_DownHill {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int M, N, cnt=0;
	static int[][] map = new int[501][501];
	static boolean[][] visit = new boolean[501][501];
	static Queue<Integer> qX = new LinkedList<>();
	static Queue<Integer> qY = new LinkedList<>();
	
	
	public static void bfs() {
		while(!qX.isEmpty() && !qY.isEmpty()) {
			int x = qX.poll();
			int y = qY.poll();
			visit[x][y] = true;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || nx>M-1 || ny<0 || ny>N-1)	continue;
				else {
					if(map[x][y]>map[nx][ny] && !visit[nx][ny]) {
						qX.offer(nx);
						qY.offer(ny);
						if(nx==M-1 && ny==N-1) {
							cnt++;
						}
					}
					else if(map[x][y]>map[nx][ny] && visit[nx][ny]) {
						cnt++;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		qX.offer(0);
		qY.offer(0);
		bfs();
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j]) {
					System.out.print("+");
				}
				else {
					System.out.print("-");
				}
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
			
		System.out.println(cnt);
	}
}
