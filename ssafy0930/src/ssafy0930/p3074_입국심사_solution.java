package ssafy0930;

import java.util.Arrays;
import java.util.Scanner;

public class p3074_입국심사_solution {
	
	static int T, N, M;
	static int[] checker;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();	// 심사대 수
			M = sc.nextInt();	// 사람 수
			checker = new int[N];
			
			for (int i = 0; i < N; i++) {
				checker[i] = sc.nextInt();	// 각 심사대에서 걸리는 시간
			}
			
			Arrays.sort(checker);	// 심사 시간으로 정렬
			
			long ans = (long)checker[0] * M;	// 심사원 한명이 M명을 다 심사하는 시간. 이거보단 같거나 더 빨리 끝날 것
			long left=0, right=ans;
			
			while(left <= right) {
				long mid = (left+right)/2;
				long people = 0;
				
				for (int time : checker) {
					people += mid/time;	// ex) 심사하는데 3초 걸리는 심사대에서는 10초 동안 3명을 처리함.
				}
				
				if(people >= M) {	// mid 시간동안  checker들이 열심히 일하면 M명 이상 심사 가능한가 체크.
					if(ans > mid)
						ans = mid;
					right = mid - 1;
				} else {	// mid 만큼의 시간은 부족함.
					left = mid + 1;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}