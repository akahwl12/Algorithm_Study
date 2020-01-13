package day0730;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon_p1874 {
	
	static int idx=0;
	static boolean isOk = true;
	static int[] result = new int[100000];
	static int[] ans = new int[100000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<>();
		int N = sc.nextInt();
		StringBuffer operations = new StringBuffer();
		
		for (int i = 0; i < N; i++) {
			result[i] = sc.nextInt();
		}
		
		int now = 1;
		for (int i = 0; i < N; i++) {
			if(now <= result[i]) {
				while(now<=result[i]) {
					stack.push(now++);
					operations.append('+');
				}
				ans[idx++] = stack.pop();
				operations.append('-');
			}
			else if(ans[idx-1] > result[i]) {
				while(!stack.isEmpty() && stack.peek()>=result[i]) {
					ans[idx++] = stack.pop();
					operations.append('-');
				}
			}
		}
		
		for (int i = 0; i < N; i++) {	//두 수열이 같은지 검사
			if(ans[i]!=result[i]) {
				isOk = false;
				break;
			}
		}
		
		
		if(isOk) {
			for (int i = 0; i < operations.length(); i++) {
				System.out.println(operations.charAt(i));
			}
		}
		if(!isOk) {
			System.out.println("NO");
		}
	}
}
