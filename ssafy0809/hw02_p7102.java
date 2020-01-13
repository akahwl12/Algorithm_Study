package ssafy0809;

import java.util.Scanner;

// D3 7102. 준홍이의 카드놀이
public class hw02_p7102 {
	static int T, N, M, max, ans;
	static int[] sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			sum = new int[N+M+1];
			max = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					sum[i+j]++;
					if(max < sum[i+j]) {
						max = sum[i+j];
					}
				}
			}
			
			System.out.print("#" + t);
			for (int i = 2; i <= N+M; i++) {
				if(sum[i] == max) {
					System.out.print(" " + i);
				}
			}
			System.out.println();
		}
	}
}
