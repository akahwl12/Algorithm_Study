package day0729;

import java.util.Scanner;

public class practice2_stack {
	static String str;
	static boolean ans=true;
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='(') {
				stack.push(str.charAt(i));
			}
			else if (str.charAt(i)==')') {
				if (stack.isEmpty() || stack.pop()!='(') {
					ans = false;
				}
			}
		}
		if(!stack.isEmpty())
			ans = false;
		System.out.println("검사 결과 : " + ans);
		
	}
}
