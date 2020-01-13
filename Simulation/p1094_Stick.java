/*
 	입력받은 값을 2진수로 변경하여 1의 갯수를 구하는 문제
 */

package Simulation;

import java.util.*;

public class p1094_Stick {
	
	public static void main(String[] args) {
		int X, cnt=0;
		
		Scanner sc = new Scanner(System.in);
		
		X = sc.nextInt();
		
		while(X>=1) {
			if(X%2!=0) {
				cnt++;
				X/=2;
			}
			else {
				X/=2;
			}
		}
		
		System.out.println(cnt);
	}
}
