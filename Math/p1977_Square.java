package Math;

import java.util.*;

public class p1977_Square {

	public static void main(String[] args) {
		int M, N, summ=0;

		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		int rM = (int)Math.ceil(Math.sqrt(M));
		int rN = (int)Math.sqrt(N);
		
		for(int i=rM; i<=rN;i++) {
			summ += i*i;
		}
		if(summ!=0) {
			System.out.println(summ);
			System.out.println(rM*rM);
		}
		else {
			System.out.println("-1");
		}
		
	}
}
