package day0726;

import java.util.Scanner;

public class baekjoon_p1094 {
	public static void main(String[] args) {
		int ans=0;
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		
		while(X>0) {
			if(X%2==1) ans++;
			X/=2;
		}
		System.out.println(ans);
	}
}
