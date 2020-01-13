package dfs_bfs;
//
import java.util.*;

public class p7576_tomato1_bfs {
	
	static int M, N, result=0, minn = 100001;
	static int dx[] = {1, 0, -1, 0}; 
	static int dy[] = {0, 1, 0, -1};
	static int [][] box = new int[1001][1001];
	static boolean [][] visit = new boolean [1001][1001];
	static Queue<Integer> tomatoX = new LinkedList();
	static Queue<Integer> tomatoY = new LinkedList();
	
	public static int bfs() {
		int x, y;
		int nx, ny;
		
		while(!tomatoX.isEmpty() && !tomatoY.isEmpty()) {
			x = tomatoX.poll();
			y = tomatoY.poll();
			visit[x][y] = true;
			for(int i=0; i<4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || nx > M-1 || ny < 0 || ny > N-1) continue;
				else {
					if(box[nx][ny]!=-1 && box[nx][ny]!=1 && !visit[nx][ny])  {
						tomatoX.offer(nx);
						tomatoY.offer(ny);
						if(box[nx][ny] == box[x][y]+1) {
							return box[nx][ny];
						}
						box[nx][ny] = box[x][y]+1;
						result = box[nx][ny]-1;
						visit[nx][ny] = true;
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
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				box[j][i] = sc.nextInt();
				if(box[j][i]==1) {
					tomatoX.offer(j);	
					tomatoY.offer(i);
				}
			}
		}
		
		minn = bfs();

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[j][i]==0)
					minn=-1;
			}
		}
		
		System.out.println(minn);

	}
}
