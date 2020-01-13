package test01_queue;

import java.util.LinkedList;
import java.util.Queue;

public class ws02_마이쮸 {
	static class Person{
		int num;
		int cnt;
		
		Person(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	static Queue<Person> queue = new LinkedList<>();
	public static void main(String[] args) {
		int number = 1, sum = 0;
		queue.add(new Person(number, 0));
		Person now = null;
		while(sum<13) {
			now = queue.poll();
			sum += now.cnt;
			queue.add(new Person(now.num, now.cnt+1));
			queue.add(new Person(++number, 0));
		}
		System.out.println("마지막 마이쮸를 받은 사람 : " +now.num);
	}
}
