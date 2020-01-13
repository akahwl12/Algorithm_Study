package day0730;
//후위표기법

import java.util.Scanner;
import java.util.Stack;

public class practice1_stack2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		Stack<Character> stack = new Stack<>();
		char[] ans = new char[100];
		int idx = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char data = s.charAt(i);
			if(Character.isAlphabetic(data) || Character.isDigit(data)) {
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
			else if((data=='+' || data=='-') && (stack.isEmpty() || stack.peek()=='(')) {
				stack.push(data);
			}
			else if((data=='*' || data=='/') && (stack.isEmpty() || stack.peek()!='*' && stack.peek()!='/')) {
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
		Stack<Double> result = new Stack<>();
		for (int i = 0; i < idx; i++) {
			if (Character.isDigit(ans[i])) {
				result.push(Double.parseDouble(ans[i]+""));
			}
			else if(!Character.isDigit(ans[i])) {
				double a = result.pop();
				double b = result.pop();
				if(ans[i]=='+') {
					result.push(b+a);
				}
				else if(ans[i]=='-') {
					result.push(b-a);
				}
				else if(ans[i]=='*') {
					result.push(b*a);
				}
				else if(ans[i]=='/') {
					result.push(b/a);
				}
				continue;
			}
		}
		
		
		for (int i = 0; i < idx; i++) {
			System.out.print(ans[i]);
		}
		System.out.println(" = " + result.peek());
	}
}
