package ssafy1007;

import java.util.ArrayList;
import java.util.Scanner;

public class p8191_만화책정렬하기 {
	
	static int T, N, now, ans;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ans = now = 0;
			list.clear();
			list.add(0);
			N = sc.nextInt();
			
			
			for (int i = 0; i < N; i++) {
				now = sc.nextInt();
				
				for (int j = 0; j < list.size(); j++) {
					
				}
				
			}
			
			System.out.println("#" + tc + " " + (ans+1));
		}
	}
}
