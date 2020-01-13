package day0723;

import java.util.Scanner;

public class ws02_problem_title {
	public static void main(String[] args) {
		int T, N, ans;
		String str;
		char[] titles = new char[101];
		int[] alpha = new int[26];
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				str = sc.next();
				titles[i] = str.charAt(0);
			}
			for (int i = 0; i < N; i++) {
				int idx = titles[i] - 'A';
				alpha[idx]++;
			}
			
			for (int i = 0; i < alpha.length; i++) {
				if(alpha[i]!=0) {
					ans++;
				}
				else break;
			}
			
			for (int i = 0; i < alpha.length; i++) {
				System.out.print((char)('A'+i));
				System.out.print(alpha[i] + " ");
				alpha[i] = 0;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
