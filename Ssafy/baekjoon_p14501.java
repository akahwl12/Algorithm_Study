package Ssafy;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_p14501 {
	static int N, max=Integer.MIN_VALUE;
	static Work[] working;
	static boolean[] use;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		working = new Work[N+1];
		use = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			int d = sc.nextInt();
			int m = sc.nextInt();
			if(d+i>N+1) {	// 날짜가 넘어가면 
				m = 0;	// 벌 수 있는 돈 0원
			}
			working[i] = new Work(d, m);
		}
		for (int i = 1; i <= N; i++) {
			if(working[i].money!=0) {
				findMax(i, 0);
			}
		}
		System.out.println(max);
		return;
	}
	public static void findMax(int now, int sum) {
		if(now>N)	return;	// 현재 날짜가 N을 넘어가면 종료
		if(use[now]) return;
		use[now] = true;
		sum+=working[now].money;
		
		if(max<sum)
			max = sum;
		for (int i = now; i < working.length; i++) {
			findMax(now+working[i].days, sum);
		}
	}
	
	static class Work {
		int days, money;
		
		Work(int d, int m) {
			days = d;
			money = m;
		}
	}
}
