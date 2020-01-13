package Ssafy;

import java.util.Scanner;
import java.util.Stack;

class Tower {
	int height;
	int index;
	
	public Tower(int height, int index) {
		this.height = height;
		this.index = index;
	}
}

public class hw01_jungol_p1809 {
	static int N;
	static int[] towers = new int[500000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		Stack<Tower> stack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			int height = sc.nextInt();
			if(stack.isEmpty()) {
				towers[i] = 0;
				stack.push(new Tower(height, i));
			}
			else {
				while(!stack.isEmpty() && height > stack.peek().height) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					towers[i] = 0;
					stack.push(new Tower(height, i));
				}
				else {
					towers[i] = stack.peek().index;
					stack.push(new Tower(height, i));
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(towers[i] + " ");
		}
	}
}