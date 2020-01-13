package day0723;

import java.util.Scanner;

public class ws03_salary_box {

	public static void main(String[] args) {
		int T, N, x;
		double p, ans=0;
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			ans = 0;
			for (int i = 0; i < N; i++) {
				p = sc.nextDouble();
				x = sc.nextInt();
				ans += p*x;
			}
			System.out.printf("#%d %.6f\n", t, ans);
		}
	}
}
