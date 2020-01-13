package test01_queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test03 {
	public static void main(String[] args) {
//		Queue<Integer> queue = new LinkedList<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			// 무명 클래스 내부
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		queue.add(115);	//enqueue
		queue.add(10);	//enqueue
		queue.add(100);	//enqueue
		
		while(!queue.isEmpty() ) {
			System.out.println(queue.poll());	//dequeue
		}
	}
}
