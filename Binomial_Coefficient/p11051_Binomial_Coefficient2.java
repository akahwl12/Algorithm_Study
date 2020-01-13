package Binomial_Coefficient;

import java.util.*;

public class p11051_Binomial_Coefficient2 {

	static long [][] arr = new long[1001][1001];
	
	public static long BC(int a, int b) {
		if(arr[a][b] > 0) {
			return arr[a][b];
		}
		
		if(a==b || b==0) {
			return arr[a][b] = 1;
		}
		
		return arr[a][b] = BC(a-1, b-1) + BC(a-1, b);
	}
	
	public static void main(String[] args) {
		int M, N;
		

		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		BC(M, N);
		
		System.out.println((arr[M][N]%10007));
	}
}