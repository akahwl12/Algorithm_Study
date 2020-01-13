package test01_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class beakjoon_p1966 {
	static class Print{
		int priority;
		int index;
		
		Print(int priority, int index) {
			this.priority = priority;
			this.index = index;
		}
	}
	static Queue<Print> queue = new LinkedList<>();
	static int T, N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			for (int i = 0; i < N; i++) {
				
			}
		}
	}
}
