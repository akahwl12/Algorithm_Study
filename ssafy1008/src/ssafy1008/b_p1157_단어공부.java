package ssafy1008;

import java.util.Scanner;

public class b_p1157_단어공부 {
	static String input;
	static char ans;
	static int cnt;
	static int[] alpha = new int[26];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		input = sc.next();
		
		input = input.toUpperCase();
		
		for (int i = 0; i < input.length(); i++) {
			alpha[input.charAt(i)-'A']++;
		}
		
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i]==0)
				continue;
			if(alpha[i]>cnt) {
				ans = (char)(i+'A');
				cnt = alpha[i];
			}
			else if(alpha[i]==cnt)
				ans = '?';
		}
		
		System.out.println(ans);
	}
}
