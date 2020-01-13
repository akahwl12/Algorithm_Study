package Ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hw02_p1225 {
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			int password = queue.peek();
			int cnt = 0;
			while(password != 0) {
				int num = queue.poll();
				cnt = cnt%5 + 1;
				password = num-cnt;
				if(password<0) {
					password = 0;
				}
				queue.add(password);
			}
			System.out.print("#" + t);
			while(!queue.isEmpty()) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
		}
	}
}