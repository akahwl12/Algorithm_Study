package day0729;

import java.util.Scanner;
import java.util.Stack;

public class ws01_p5432_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int rst = 0;
			String s = sc.next();
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='(')
					stack.push(s.charAt(i));
				if(s.charAt(i)==')') {
					stack.pop();
					rst+=stack.size();
					System.out.println(rst + ":  + " + stack.size());
				}
			}
//			System.out.println("#" + t + " " + rst);
		}
	}
}
