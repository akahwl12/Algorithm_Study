package ssafy0809;

import java.util.Scanner;

public class h03_baekjoon_p14503 {
	
	static class Robot {
		int x;
		int y;
		int d;
	}
	
	static int N, M, ans;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] map;
	static boolean stop = false;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		Robot robot = new Robot();
		robot.x = sc.nextInt();
		robot.y = sc.nextInt();
		robot.d = sc.nextInt();
		
		cleaning(robot);
		System.out.println(ans);
	}
	
	public static void cleaning(Robot r) {
		if(stop)
			return;
		
		for (int i = 0; i < dx.length; i++) {
			
		}
		
		if(N<r.x+dx[(r.d+2)%4] && r.x+dx[(r.d+2)%4]<0 && M<r.y+dy[(r.d+2)%4] && r.y+dy[(r.d+2)%4]<0) {
			//범위밖일때
			stop = true;
			return;
		}
		
		
	}
}
