package Brute_force;

import java.util.*;

public class p1065_Hansu {

	public static void main(String[] args) {
		String numS = new String();
		int N, cnt;
		int[] number = new int[4];
		boolean isHansu;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		cnt = N;
		
		for(int i=100; i<=N; i++) {
			numS = Integer.toString(i);
			
			for(int j=0; j<numS.length(); j++) {
				number[j] = Integer.parseInt(numS.split("")[j]);
			}
			
			isHansu = true;
			int first = number[0];
			int second = number[1];
			int gap = first - second;
			
			for(int j=0; j<numS.length()-1; j++) {
				int gap2 = number[j] - number[j+1];
				if(gap != gap2) {
					isHansu = false;
					break;
				}
			}
			if(!isHansu)	cnt--;
		}
		
		
		System.out.println(cnt);
	}
}
