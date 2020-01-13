package test01_queue;

public class Test01 {
	static class MyQueue {
		private int[] data = new int[100];
		private int front=-1, rear=-1;
		
		void enQueue(int d) {
			rear = rear + 1;
			data[rear] = d;
		}
		
		int deQueue() {
			return data[++front];
		}
		
		boolean isEmpty() {
			boolean isE = false;
			if(front == rear) {
				isE = true;
			}
			return isE;
		}
		
		boolean isFull() {
			boolean isF = false;
			if(rear == data.length-1) {
				isF = true;
			}
			return isF;
		}
		
		int peek() {
			return data[front + 1];
		}
	}
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		int j = 0;
		while(!queue.isFull()) {
			queue.enQueue(++j);
		}
		if(queue.isFull())
			System.out.println("Full!");
		
		int i=0;
		while(!queue.isEmpty()) {
			System.out.print(++i + " : ");
			System.out.println(queue.deQueue());
		}
	}
}
