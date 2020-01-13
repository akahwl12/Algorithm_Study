package day0722;

import java.util.Scanner;
import java.util.Stack;

public class ws01_ladder01 {
	
	static final int MAX = 101;
	static int[][] map = new int[MAX][MAX];
	static int[][] visited = new int[MAX][MAX];
	static Stack<Integer> X = new Stack();
	static Stack<Integer> Y = new Stack();
	static int[] dx = {-1, 0, 0};
	static int[] dy = {0, 1, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			X.clear();
			Y.clear();
			sc.nextInt();
			for (int i = 0; i < MAX-1; i++) {
				for (int j = 0; j < MAX-1; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) {
						X.push(i);
						Y.push(j);
					}
				}
			}
			int qx=0, qy=0;
			while(!X.isEmpty()) {
				int x = X.pop();
				int y = Y.pop();
				qx = x;
				qy = y;
				visited[x][y] = 1;
				for (int i = 0; i < 3; i++) {
					int nextX = x + dx[i];
					int nextY = y + dy[i];
					if(nextX>=0 && nextX<MAX-1 && nextY>=0 && nextY<MAX-1) {
						if(map[nextX][nextY]==1 && visited[nextX][nextY]!=1) {
							X.push(nextX);
							Y.push(nextY);
						}
					}
				}
				if(x == 0)
					break;
			}
			System.out.println("#" + t + " " + qy);
			
			for (int i = 0; i < MAX-1; i++) {
				for (int j = 0; j < MAX-1; j++) {
					visited[i][j] = 0;
				}
			}
		}
	}
}
