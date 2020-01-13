package Baekjoon;

import java.util.Scanner;

public class baekjoon_p2468 {
	static int N, min=100, max=1;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]>max)	max = map[i][j];
				if(map[i][j]<min)	min = map[i][j];
			}
		}
		
		for (int i = min; i < max; i++) {
			
		}
		
	}
}
