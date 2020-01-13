package kakao;

import java.util.Scanner;
import java.util.Stack;

public class kakao_p1 {
	static int ans, count;
	static String s;
	static StringBuilder sb = new StringBuilder();
	static Stack<Alpha> stack = new Stack<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		s = sc.next();
		
		int len = s.length();
		
		ans = len;
		for (int i = 1; i <= len/2; i++) {
			count = 0;
			stack.clear();
			sb.delete(0, sb.length());
			for (int j = 0; j < len; j++) {
				sb.append(s.charAt(j));
				
				if((j+1)%i==0) {
					if(stack.isEmpty())
						stack.push(new Alpha(sb.toString(), 1));
					else if(!stack.peek().s.equals(sb.toString()))
						stack.push(new Alpha(sb.toString(), 1));
					else {
						Alpha top = stack.pop();
						top.cnt++;
						stack.push(top);
					}
					sb.delete(0, sb.length());
				}
			}
			count += len%i;
			while(!stack.isEmpty()) {
				Alpha out = stack.pop();
				if(out.cnt==1)
					count += i;
				else
					count += i+ ((""+out.cnt).length());
			}
			ans = Math.min(ans, count);
		}
		System.out.println(ans);
	}
	
	static class Alpha {
		String s;
		int cnt;
		
		Alpha(String s, int c) {
			this.s = s;
			this.cnt = c;
		}
	}
}
