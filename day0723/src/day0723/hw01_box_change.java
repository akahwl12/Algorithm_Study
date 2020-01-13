package day0723;

import java.util.Scanner;

public class hw01_box_change {

	static int T, N, Q, L, R;
	static int[] box;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			box = new int[N];
			
			Q = sc.nextInt();
			for (int i = 1; i <= Q; i++) {
				L = sc.nextInt();
				R = sc.nextInt();
				for (int j = L-1; j < R; j++) {
					box[j] = i;
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(box[i] + " ");
			}
			System.out.println();
		}
	}
}
