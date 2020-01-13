package test01_queue;

public class Test05 {
	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();
		
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		System.out.println(queue.size());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}
}
