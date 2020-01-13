package day0729;

public class Test01 {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		if(!stack.isEmpty())
//			System.out.println(stack.pop());
		
//		for (int i = 0; i < stack.size(); i++) {
//			System.out.println(stack.pop());	//for문에서 size()메소드를 계속해서 받아와서 size값이 변한다.(주의!!)
//		}
		
		int cnt = stack.size();
		for (int i = 0; i < cnt; i++) {
			System.out.println(stack.pop());
		}
	}
}
