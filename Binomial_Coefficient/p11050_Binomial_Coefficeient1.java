package Binomial_Coefficient;

import java.util.*;

public class p11050_Binomial_Coefficeient1 {

	static double f;
	
	public static double BC(double a, double b) {
		if(a==b || b==0) {
			return 1;
		}
		return BC(a-1, b-1) + BC(a-1, b);
	}
	
	public static void main(String[] args) {
		int M, N;

		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		f = BC(M, N);
		
		System.out.println((int)(f%10007));
	}
}