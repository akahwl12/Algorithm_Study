package day0726;

import java.util.Scanner;

public class baekjoon_p2979 {
	public static void main(String[] args) {
		int[] time = new int[101];
		int A, B, C, in, out, ans=0, max=0;
		
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		for (int i = 0; i < 3; i++) {
			in = sc.nextInt();
			out = sc.nextInt();
			if(max<out)	max = out;
					
			for (int j = in; j < out; j++) {
				time[j]++;
			}
			
			
		}
		for (int i = 1; i < max; i++) {
			if(time[i]==1)	ans+=time[i]*A;
			else if(time[i]==2)	ans+=time[i]*B;
			else if(time[i]==3)	ans+=time[i]*C;
		}
		System.out.println(ans);
	}
}
