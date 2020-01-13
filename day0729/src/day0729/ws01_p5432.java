package day0729;

import java.util.Scanner;
import java.util.Stack;

public class ws01_p5432 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int rst = 0, cnt = 0;
			stack.clear();
			String s = sc.next();
			for (int i = 0; i < s.length(); i++) {
				stack.push(s.charAt(i));
			}
			char prev = '\0';
			while(!stack.isEmpty()) {
				char data = stack.pop();
				if(data ==')') {
					rst++;
					cnt++;
				}
				else if(data == '(') {
					if(prev==')') {
						rst--;
						cnt--;
						rst+=cnt;
					}
					else if(prev=='(') {
						cnt--;
					}
				}
				prev = data;
			}
			System.out.println("#" + t + " " + rst);
		}
	}
}