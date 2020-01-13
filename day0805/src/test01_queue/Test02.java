package test01_queue;

public class Test02 {
	static class CircularQueue {
		private int[] data  = new int[5];
		private int front = 0, rear = 0;
		
		boolean isEmpty() {
			boolean isE = false;
			if(front == rear) {
				isE = true;
			}
			return isE;
		}
		
		boolean isFull() {
			boolean isF = false;
			if((rear+1)%data.length == front) {
				isF = true;
			}
			return isF;
		}
		void enQueue(int d) throws Exception {
			if(isFull()) {
				throw new Exception("큐 꽉참!");
			}
			rear = (rear+1) % data.length;
			data[rear] = d;
		}
		
		int deQueue() throws Exception {
			if(isEmpty()) {
				throw new Exception("큐 비어있음!");
			}
			front = (front+1) % data.length;
			return data[front];
		}
	}
	
	public static void main(String[] args) throws Exception {
		CircularQueue queue = new CircularQueue();
		
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
		
		System.out.println(queue.deQueue());
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}
	
}