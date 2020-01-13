package day0716;

import java.util.Arrays;
import java.util.Scanner;

public class p1208 {
	static void sel_sort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] width = new int[100];
		int tmp = 0, ans = 0;
		
		for(int t=1; t<=10; t++) {
			int dump = sc.nextInt();
			
			for(int i=0; i<100; i++) {
				width[i] = sc.nextInt();
			}
			
			for(int i=0; i<dump; i++) {
				sel_sort(width);
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
