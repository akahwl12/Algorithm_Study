package ws;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class baekjoon_p1931 {
	static int N, ans;
	static ArrayList<Time> times = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			times.add(new Time(s,e));
		}
		times.sort(new Comparator<Time>() {
			@Override
			public int compare(Time o1, Time o2) {
				if(o1.end>o2.end) {
					return 1;
				}
				else if(o1.end<o2.end) {
					return -1;
				}
				else {
					if(o1.start>o2.start)
						return 1;
					else
						return -1;
				}
			}
		});
		
		Time t = new Time(-1, -1);
		for (int i = 0; i < times.size(); i++) {
			if(times.get(i).start>=t.end) {
				t = times.get(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	static class Time {
		int start;
		int end;
		Time(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}
}
