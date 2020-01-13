package Simulation;

import java.util.*;

public class p1057_Tournament {

	public static void main(String[] args) {
		int N, a, b;
		int low, mid, high;
		boolean boolA, boolB;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		
		low = 1;
		high = N;
		mid = ((high-low+1)/2);
		
		boolA = mid >= a;
		boolB = mid >= b;
		
		System.out.println((boolA && boolB) || (!boolA && !boolB));
	}

}
