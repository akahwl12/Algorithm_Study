package day0730;

import java.util.Scanner;
import java.util.Stack;



public class hw01_jungol_p1809 {
	static int N, idx=0, pop_cnt=0;
	static int[] towels = new int[500000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			if(stack.isEmpty()) {
				towels[i] = 0;
				stack.push(num);
				continue;
			}
			
		}
	}
}
