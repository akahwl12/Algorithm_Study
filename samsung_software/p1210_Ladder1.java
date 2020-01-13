package samsung_software;

import java.util.*;

public class p1210_Ladder1 {

	static int result, count=0;
	static int[][] map = new int[100][100];
	static boolean[][] visited = new boolean[100][100];
	static int dx[] = {-1, 1, 0}; 
	static int dy[] = {0, 0, -1};
	
	public static int dfs(int x, int y) {
		int nx, ny;
		
		visited[x][y] = true;
		if(y==0)	return x;
		for(int i=0; i<3; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx < 0 || nx > 99 || ny < 0 || ny > 99)	continue;
			else {
				if(map[nx][ny]==1 && !visited[nx][ny])  {
					map[nx][ny] = map[x][y]+1;
					if(ny==0 && count==0) {
						result = nx;
						count++;
					}
					dfs(nx, ny);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int T, res=-1;
		int sx=0, sy=0;
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			count = 0;
			T = sc.nextInt();
			for(int j=0; j<100; j++) {
				for(int k=0; k<100; k++) {
					map[k][j] = sc.nextInt();
					visited[k][j] = false;
					if(map[k][j]==2) {
						sx = k;
						sy = j;
					}
				}
			}
			res = dfs(sx, sy);
			
			System.out.println("#" + T + " " + res);
		}	
	}
}
