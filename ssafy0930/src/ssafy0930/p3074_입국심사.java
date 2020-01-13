package ssafy0930;

import java.util.PriorityQueue;
import java.util.Scanner;

public class p3074_입국심사 {
	static int T, N, M;
	static Time ans;
	static PriorityQueue<Time> pq = new PriorityQueue<>();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			pq.clear();
			N = sc.nextInt();
			M = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				pq.add(new Time(sc.next(), 0));
			}
			
			for (int i = 0; i < M; i++) {
				Time nT = pq.poll();
				nT.cnt ++;
				pq.add(nT);
				ans = nT;
			}
			
			if(ans.cnt == 0)
				ans.cnt = 1;
			
			System.out.println("#" + tc + " " + (Integer.parseInt(ans.time) * ans.cnt));
		}
	}

	static class Time implements Comparable<Time>{
		String time;
		int cnt;
		
		Time(String t, int c) {
			time = t;
			cnt = c;
		}

		@Override
		public int compareTo(Time o) {
			return (Integer.parseInt(this.time)*this.cnt  + Integer.parseInt(this.time)) - (Integer.parseInt(o.time)*o.cnt  + Integer.parseInt(o.time));
		}
	}
}