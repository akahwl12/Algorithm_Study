package Dynamic_Programming;

//���ݱ��� �Ծ��� �� ���� �ִ��� dp[i]�� �����ؾ��Ѵ�. 
//	�ݷ� 
//	8
//	7 7 0 5 7 7 0 3

import java.util.*;

public class p2156_Wine {

	public static void main(String[] args) {
		int N, maxx=0;
		int[] cup = new int[10001];
		int[] dp = new int[10001];
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			cup[i] = sc.nextInt();
		}
		
		dp[1] = cup[1];
		dp[2] = cup[1] + cup[2];
		maxx = dp[2];
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-3] + cup[i-1] + cup[i], dp[i-2] + cup[i]);
			dp[i] = Math.max(dp[i], maxx);	//���ݱ��� �Ծ��� �� ���� �ִ��� dp[i]�� ����.
			if(maxx<dp[i])	maxx = dp[i];
		}

		System.out.println(maxx);

	}

}
