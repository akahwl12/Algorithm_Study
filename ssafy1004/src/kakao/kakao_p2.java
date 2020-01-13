package kakao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class kakao_p2 {
	static String p, temp="", answer="";
	static boolean complete;
	static int left, right;
	static char prev;
	static Queue<Character> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		p = sc.next();
		
		for (int i = 0; i < p.length(); i++) {
			queue.add(p.charAt(i));
		}
		
		if(isRight(p)) {
			answer = p;
			complete = true;
		}
		while(!complete && !queue.isEmpty()) {
			
			char c = queue.poll();
			
			if(c=='(')
				left++;
			else if(c==')')
				right++;
			if(left==1 && right==1 && prev=='(' && c ==')') {
				answer = answer + "()";
                p = p.substring(2);
                left = right = 0;
            }
			
			if(left==right) {
				for (int i = 0; i < left+right; i++) {
					if(p.charAt(i)=='(') {
						answer = answer + ')';
					}
					else if(p.charAt(i)==')') {
						answer = answer + '(';
					}
				}
				p = p.substring(left+right);
				left = right = 0;
			}
			prev = c;
		}
		System.out.println(answer);
	}
	
	public static boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < p.length(); i++) {
        	if(stack.isEmpty())
        		stack.add(p.charAt(i));
        	else if(stack.peek()=='(' && p.charAt(i)==')') {
        		stack.pop();
        	}
        	else {
        		stack.add(p.charAt(i));
        	}
		}
        
        return stack.isEmpty();
    }
}
