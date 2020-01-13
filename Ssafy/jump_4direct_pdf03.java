package Ssafy;

import java.util.Scanner;

public class jump_4direct_pdf03 {
	
	static int T, X, Y, N, traps, money;
	static boolean isTrap;
	static int[][] map;
	static int[] startX;
	static int[] startY;
	static int[] cnt;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			X = sc.nextInt();
			Y = sc.nextInt();
			N = sc.nextInt();
			money = (-1000) * N;
			
			map = new int[X+1][Y+1];
			for (int i = 1; i <= X; i++) {
				for (int j = 1; j <= Y; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			startX = new int[N];
			startY = new int[N];
			cnt = new int[N];
			for (int i = 0; i < N; i++) {
				startX[i] = sc.nextInt();
				startY[i] = sc.nextInt();
				cnt[i] = sc.nextInt();
			}
			
			traps = sc.nextInt();
			for (int i = 0; i < traps; i++) {
				int tx = sc.nextInt();
				int ty = sc.nextInt();
				map[tx][ty] = 0;
			}
			
			for (int i = 0; i < N; i++) {
				int x = startX[i];
				int y = startY[i];
				isTrap = false;
				
				for (int j = 0; j < cnt[i]; j++) {
					int dir = (map[x][y] / 10) - 1;
					int jump = map[x][y] % 10;
					x = x + (dx[dir] * jump);
					y = y + (dy[dir] * jump);
					if(x<=0 || x>X || y<=0 || y>Y || map[x][y]==0) {
						x = 0;
						y = 0;
						isTrap = true;
						break;
					}
				}
				if(!isTrap) {
					money += map[x][y] * 100;
				}
			}
			System.out.println("#" + t + " " + money);
		}
	}
}