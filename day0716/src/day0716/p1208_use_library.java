package day0716;

import java.util.Arrays;
import java.util.Scanner;

public class p1208_use_library {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] width = new int[100];
		int ans = 0;
		
		for(int t=1; t<=10; t++) {
			int dump = sc.nextInt();
			
			for(int i=0; i<100; i++) {
				width[i] = sc.nextInt();
			}
			
			for(int i=0; i<dump; i++) {
				Arrays.sort(width);
				width[99]--;
				width[0]++;
				if((width[99]-width[0]) <= 1)
					break;
			}
			ans = Math.max(width[99], width[98]) - Math.min(width[0], width[1]);
			
			System.out.println("#" + t + " " + ans);
			
		}
	}
}
