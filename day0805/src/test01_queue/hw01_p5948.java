package test01_queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hw01_p5948 {
	static final int MAX = 7;
	static int T, sum, cnt, ans;
	static int[] num = new int[7];
	static PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {	//Treeset 사용가능 : 중복을 허용하지 않고, 데이터가 입력되면 정렬되서 들어간다.
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
		
	});
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			queue.clear();
			for (int i = 0; i < 7; i++) {
				num[i] = sc.nextInt();
			}
			
			for (int i = 0; i < (1<<num.length); i++) {
				sum = 0;
				cnt=0;
				for (int j = 0; j < num.length; j++) {
					if(((1<<j) & i)!= 0) {
						sum += num[j];
						cnt++;
					}
				}
				if(cnt==3)	queue.add(sum);
			}
			
			for (int i = 0; i < 5; i++) {
				ans = queue.poll();
				while(ans==queue.peek()) {
					ans = queue.poll();
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
