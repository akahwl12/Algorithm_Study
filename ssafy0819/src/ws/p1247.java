package ws;

import java.util.ArrayList;
import java.util.Scanner;

public class p1247 {
	static int TC, N, ans;
	static Point start, end;
	static ArrayList<Point> map = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			map.clear();
			ans = Integer.MAX_VALUE;
			N = sc.nextInt();
			visited = new boolean[N];
			start = new Point(sc.nextInt(), sc.nextInt());
			end = new Point(sc.nextInt(), sc.nextInt());
			for (int i = 0; i < N; i++) {
				map.add(new Point(sc.nextInt(), sc.nextInt()));
			}
			
			for (int i = 0; i < N; i++) {
				dfs(0, start, i, 0);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void dfs(int depth, Point prev, int now, int sum) {
		if(visited[now])	return;
		if(sum >= ans)	return;
		
		sum += Math.abs(map.get(now).x-prev.x) + Math.abs(map.get(now).y-prev.y);
		
		if(depth==N-1) {
			sum += Math.abs(map.get(now).x-end.x) + Math.abs(map.get(now).y-end.y);
			if(ans>sum)
				ans = sum;
			return;
		}
		for (int i = 0; i < N; i++) {
			visited[now] = true;
			dfs(depth+1, map.get(now), i, sum);
			visited[now] = false;
		}
	}
}