package test01_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ws01_p8104 {
	static int T, N, K;
	static int[][] group;
	static int ans[];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			System.out.println(N + ", " + K);
			
			group = new int[N][K];
			ans = new int[K];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < K; j++) {
					if(i%2==0) {
						group[i][j] = i*K + j + 1;
					}
					else {
						group[i][j] = (i+1)*K - j;
					}
				}
			}
			
			System.out.print("#" + t);
			for (int i = 0; i < K; i++) {
				for (int j = 0; j < N; j++) {
					ans[i] += group[j][i];
				}
				System.out.print(" " + ans[i]);
			}
			System.out.println();
		}
	}
}
