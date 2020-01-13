package day0730;

import java.util.Scanner;
import java.util.Stack;

public class ws03_p1224_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int len = sc.nextInt();
			String input = sc.next();
			
			String postfix = "";
			
			Stack<Character> op_stack = new Stack<>();
			for (int i = 0; i < len; i++) {
				char ch = input.charAt(i);	//중위표기식에서 한글자 떼어내서
				
				if(ch>='0' && ch<='9') {	//중위표기식에서의 숫자는 바로 후위표기에 갖다 붙이기
					postfix += ch;
				}
				else if(ch==')') {	//닫히는 괄호인 경우
					char tmp;	//스택에서 열리는 괄호가 나올때까지 계속 pop해서 postfix에 붙이기
					while((tmp=op_stack.pop())!='(') {
						postfix += tmp;
					}
				}
				else if(ch=='(') {	//열리는 괄호는 일단 무조건 스택에 들어감
					op_stack.push(ch);
				}
				else {	//연산자인 경우
					while(!op_stack.isEmpty() && getPriority(op_stack.peek())>=getPriority(ch)) {
						postfix += op_stack.pop();
					}
					op_stack.push(ch);
				}
			}
			while(!op_stack.isEmpty()) {
				postfix += op_stack.pop();
			}
			///////////////////////////////////////////////
			//계산하기
			Stack<Integer> num_stack = new Stack<>();
			
			for (int i = 0; i < postfix.length(); i++) {
				char ch = postfix.charAt(i);
				
				if(ch>='0' && ch<='9') { //계산할때 후위표기식의 숫자는 무조건 스택에 푸시!
					num_stack.push(ch-'0');
				}
				else {	//후위표기식에서 숫자 아니었으면 무조건 연산자!
					int n1 = num_stack.pop();
					int n2 = num_stack.pop();
					
					switch(ch) {
					case '+':
						num_stack.push(n1+n2);
						break;
					case '*':
						num_stack.push(n1*n2);
						break;
					}
				}
				System.out.println("#" + t + " " + num_stack.pop());
			}
		}
	}
	
	static int getPriority(char op) {	//연산자의 우선순위를 정하기위한 함수
		if(op=='*' || op=='/')
			return 2;
		else if(op=='+' || op=='-')
			return 1;
		else if(op=='(')
			return 0;
		else
			return -1;
	}
}