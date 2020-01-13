package Ssafy;

import java.util.Scanner;
import java.util.Stack;

public class hw01_p1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			Stack<Character> stack = new Stack<>();
			int ans = 0;
			int N = sc.nextInt();
			String s = sc.next();
			for (int i = 0; i < N; i++) {
				char ch = s.charAt(i);
				if(ch=='[' || ch=='(' || ch=='<' || ch=='{')
					stack.push(ch);
				else if(ch==')' && stack.pop()=='(')
					continue;
				else if(ch=='}' && stack.pop()=='{')
					continue;
				else if(ch=='>' && stack.pop()=='<')
					continue;
				else if(ch==']' && stack.pop()=='[')
					continue;
				else {
					break;
				}
			}
			if(stack.isEmpty())
				ans=1;
			System.out.println("#" + t + " " + ans);
		}
	}
}
