package day0730;

import java.util.Scanner;
import java.util.Stack;

public class ws03_p1224 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			char[] ans = new char[N];
			String s = sc.next();
			int idx = 0;
			
			for (int i = 0; i < s.length(); i++) {
				char data = s.charAt(i);
				if(Character.isDigit(data)) {
					ans[idx++] = data;
				}
				else if(data=='(') {
					stack.push(data);
				}
				else if(data==')') {
					char out = stack.pop();
					while(out!='(') {
						ans[idx++] = out;
						out = stack.pop();
					}
				}
				else if(data=='+' && (stack.isEmpty() || stack.peek()=='(')) {
					stack.push(data);
				}
				else if(data=='*' && (stack.isEmpty() || stack.peek()!='*')) {
					stack.push(data);
				}
				else {
					ans[idx++] = stack.pop();
					i--;
				}
			}
			while(!stack.isEmpty()) {
				ans[idx++] = stack.pop();
			}
			//////////////////////////////////////////////
			//계산하기//
			Stack<Integer> result = new Stack<>();
			for (int i = 0; i < idx; i++) {
				if (Character.isDigit(ans[i])) {
					result.push(Integer.parseInt(ans[i]+""));
				}
				else if(!Character.isDigit(ans[i])) {
					int a = result.pop();
					int b = result.pop();
					if(ans[i]=='+') {
						result.push(b+a);
					}
					else if(ans[i]=='*') {
						result.push(b*a);
					}
					continue;
				}
			}
			System.out.println("#" + t + " " + result.peek());
		}
	}
}