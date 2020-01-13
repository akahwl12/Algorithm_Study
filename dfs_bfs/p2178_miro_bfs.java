package dfs_bfs;

import java.util.*;

public class p2178_miro_bfs {

	static int M, N;
	static String numm;
	static int[][] arr = new int[101][101];
	static int[][] visited = new int[101][101];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void bfs() {
		Queue<Integer> qX = new LinkedList();
		Queue<Integer> qY = new LinkedList();
		
		qX.offer(0);
		qY.offer(0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			numm = sc.next();
			for(int j=0; j<N; j++) {
				arr[j][i] = Integer.parseInt(numm.split("")[j]);
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(arr[j][i]);
			}
			System.out.println();
		}
		
	}

}
