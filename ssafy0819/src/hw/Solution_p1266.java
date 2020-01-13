package hw;
// [소수 완제품 확률]
// A 또는 V가 소수개의 제품을 완성할 확률
// => 1-(A랑 B 둘다 합성수개를 완성할 확률)
// => 1-((1-A가 소수개를 완성할 확률)*(1-B개가 소수개를 완성할 확률))
// => 1-((1-A가 2또는3또는5또는....개를 성공시킬 확률의합~~))

import java.util.Scanner;

public class Solution_p1266 {
	static int[] primeNum = {2,3,5,7,11,13,17};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			double p1 = sc.nextInt()/100.0;
			double p2 = sc.nextInt()/100.0;
			
			int n = 18;	// 총 시도 횟수중 소수개를 뽑는 경우 18C2, 18C3, 18C5, 18C7, 18C11, 18C13, 18C17
			
			double primeA = 0;	// A가 소수개를 성공시킬 확률
			double primeB = 0;	// B가 소수개를 성공시킬 확률
			for (int i = 0; i < primeNum.length; i++) {
				int r = primeNum[i];
				primeA += nCr(n,r,1)*Math.pow(p1, r)*Math.pow((1-p1),(n-r));
				primeB += nCr(n,r,1)*Math.pow(p2, r)*Math.pow((1-p2),(n-r));
			}
			double result = 1 - ((1-primeA) * (1-primeB));
			System.out.printf("#%d %.6f\n", tc, result);
		}
	}
	
	static double nCr(int n, int r, double result) {
		if(r==1) {
			return result*n;
		}
		
		result *= n;
		result /= r;
		
		return nCr(n-1, r-1, result);
	}
}
