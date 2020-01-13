package test;

import java.util.Scanner;

public class p7510 {
	static int T, num, sum, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			cnt = 1;	// 자기 자신 포함
			num = sc.nextInt();
			for (int i = 1; i <= num/2+1 && num != 1; i++) {
				sum = 0;
				for (int j = i; j <= num/2+1; j++) {
					sum += j;
					if(sum==num) {
						cnt++;
					}
					else if(sum>num) {
						break;
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
