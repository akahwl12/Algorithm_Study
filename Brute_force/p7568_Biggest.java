package Brute_force;

import java.util.*;

public class p7568_Biggest {

	public static void main(String[] args) {
		int N, X, Y;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int[][] men = new int[N][3];
		
		for(int i=0; i<N; i++) {
			men[i][0] = sc.nextInt();
			men[i][1] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(men[i][0]<men[j][0] && men[i][1]<men[j][1]) {
					men[i][2]++;
				}
				else if(men[i][0]>men[j][0] && men[i][1]>men[j][1]) {
					men[j][2]++;
				}
			}
		}
		for(int i=0; i<N; i++) {
			System.out.println(men[i][2]+1);
		}
	}
}
