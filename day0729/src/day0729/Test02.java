package day0729;

import java.util.Stack;

public class Test02 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
	
		int cnt = stack.size();
		for (int i = 0; i < cnt; i++) {
			System.out.println(stack.pop());
		}
	}
}
