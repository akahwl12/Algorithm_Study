package dfs_bfs;

import java.util.*;

/*
 * 통신범위 원의 반지름을 이용하여 접하는 좌표들끼리 연결하여 dfs, bfs하는 문제
 */
public class p10216_CountCircleGroups {

	static int T, N, R, cnt=-1;
	
	public static void dfs(int x, ArrayList<Integer>[] sX, int[][] map, boolean[] visited) {
		if(visited[x])	return;
		visited[x] = true;
		
		for(int i=0; i<sX[x].size(); i++) {
			int nx = sX[x].get(i);
			
			if(!visited[nx])
				map[nx][3] = cnt;
				dfs(nx, sX, map, visited);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		int[] res = new int[T];
		
		for(int t=0; t<T; t++) {
			res[t]=0;
			cnt=-1;
			N = sc.nextInt();

			int[][] map = new int[N][4];
			boolean[] visited = new boolean[N];
			ArrayList<Integer>[] sX = new ArrayList[N];
			
			for(int i=0; i<N; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
				R = sc.nextInt();
				map[i][2] = R;
				sX[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					int x = map[i][0] - map[j][0];
					int y = map[i][1] - map[j][1];
					int r = map[i][2] + map[j][2];
					if(x*x + y*y <= r*r) {
						sX[i].add(j);		sX[j].add(i);
					}
				}
			}
			for(int i=0; i<N; i++) {
				dfs(i, sX, map, visited);
			}
			
			for(int i=0; i<N; i++) {
				if(map[i][3] == 0) {
					res[t]++;
				}
			}
			
			for(int i=0; i<N; i++) {
				map[i][0] = 0;
				map[i][1] = 0;
				map[i][2] = 0;
				map[i][3] = 0;
				sX[i].clear();
				visited[i] = false;
			}
			
		}
		for(int t=0; t<T; t++) {
			System.out.println(res[t]);
		}
	}
}