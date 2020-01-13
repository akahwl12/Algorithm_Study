package ws;

public class ws04_stack_test {
	public static void main(String[] args) {
		ws04_stack1 stack = new ws04_stack1();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println("peek : " + stack.peek());	//50이 나와야함
		stack.push(70);
		
		while(!stack.isEmpty()) {
			System.out.println("size : " + stack.size() + ", data : " + stack.pop());
		}
	}
}
