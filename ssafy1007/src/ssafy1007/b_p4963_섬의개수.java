package ssafy1007;

import java.util.ArrayList;
import java.util.Scanner;

public class b_p4963_섬의개수 {
	
	static int W, H, ans;
	static int dx[] = {1, 0, -1, 0, 1, 1, -1, -1};
	static int dy[] = {0, 1, 0, -1, 1, -1, 1, -1};
	static boolean[][] map;
	static ArrayList<Point> start = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			W = sc.nextInt();
			H = sc.nextInt();
			
			if(W==0 && H==0)
				break;
			
			ans = 0;
			start.clear();
			map = new boolean[H][W];
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					int input = sc.nextInt();
					if(input==0)
						map[i][j] = true;
					else 
						start.add(new Point(i, j));
				}
			}
			
			for (int i = 0; i < start.size(); i++) {
				int x = start.get(i).x;
				int y = start.get(i).y;
				
				if(!map[x][y]) {
					ans++;
					dfs(start.get(i));
				}
			}
			
			System.out.println(ans);
		}
	}
	
	static void dfs(Point now) {
		int x = now.x;
		int y = now.y;
		
		map[x][y] = true;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<H && 0<=ny && ny<W && !map[nx][ny]) {
				dfs(new Point(nx, ny));
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
