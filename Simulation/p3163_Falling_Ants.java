package Simulation;

import java.util.*;

public class p3163_Falling_Ants {

	public static void main(String[] args) {
		int T, N, L, K, idx, ID, cnt=0;
		int[] Bar = new int[5000000];
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			N = sc.nextInt(); //개미의 수
			L = sc.nextInt(); //막대의 길이
			K = sc.nextInt(); //k번째로 떨어지는 개미
			
			for(int j=0; j<N; j++) {
				idx = sc.nextInt();
				ID = sc.nextInt();
				
				Bar[idx] = ID;
			}
			while(cnt==3) {
				
			}
			
			
		}
	}

}
