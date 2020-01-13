package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7569_tomato2_bfs {

	static int M, N, H, result=0, minn = 100001;
	static int dx[] = {1, 0, 0, -1, 0, 0}; 
	static int dy[] = {0, 1, 0, 0, -1, 0};
	static int dz[] = {0, 0, 1, 0, 0, -1};
	static int [][][] box = new int[101][101][101];
	static boolean [][][] visit = new boolean [101][101][101];
	static Queue<Integer> tomatoX = new LinkedList();
	static Queue<Integer> tomatoY = new LinkedList();
	static Queue<Integer> tomatoZ = new LinkedList();
	
	public static int bfs() {
		int x, y,z ;
		int nx, ny, nz;
		
		while(!tomatoX.isEmpty() && !tomatoY.isEmpty() && !tomatoZ.isEmpty()) {
			x = tomatoX.poll();
			y = tomatoY.poll();
			z = tomatoZ.poll();
			visit[z][x][y] = true;
			for(int i=0; i<6; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				nz = z + dz[i];
				if (nx < 0 || nx > M-1 || ny < 0 || ny > N-1 || nz < 0 || nz > H-1) continue;
				else {
					if(box[nz][nx][ny]!=-1 && box[nz][nx][ny]!=1 && !visit[nz][nx][ny])  {
						tomatoX.offer(nx);
						tomatoY.offer(ny);
						tomatoZ.offer(nz);
						if(box[nz][nx][ny] == box[z][x][y]+1) {
							return box[nz][nx][ny];
						}
						box[nz][nx][ny] = box[z][x][y]+1;
						result = box[nz][nx][ny]-1;
						visit[nz][nx][ny] = true;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		
		for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					box[k][j][i] = sc.nextInt();
					if(box[k][j][i]==1) {
						tomatoX.offer(j);	
						tomatoY.offer(i);
						tomatoZ.offer(k);
					}
				}
			}
		}
		
		minn = bfs();

		for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(box[k][j][i]==0)
						minn=-1;
				}
			}
		}
		System.out.println(minn);
	}
}
