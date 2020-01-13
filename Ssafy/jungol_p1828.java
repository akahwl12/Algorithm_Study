package Ssafy;

import java.util.LinkedList;
import java.util.Scanner;

public class jungol_p1828 {
	static int N, start, end, ans, max, idx;
	static boolean canAdd;
	static LinkedList<Temp> refrige = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ans = N+1;
		for (int i = 0; i < N; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			
			Temp input = new Temp(start, end);
//			System.out.println(i + " : " + start + " , " + end);
			
			if(refrige.isEmpty()) {
				refrige.add(input);
			}
			else {
				idx = 0;
				canAdd = true;
				while(idx<refrige.size()) {
					Temp right, left;
					if(refrige.get(idx).end>input.end) {
						right = refrige.get(idx);
						left = input;
					}
					else {
						right = input;
						left = refrige.get(idx);
					}
//					System.out.println(idx + "-"+left.start + ":" + left.end + ":"+right.start + ":" + right.end);
					
					if(!input.equals(refrige.get(idx)) && left.end>right.start) {
						int s = Math.max(left.start, right.start);
						int e = Math.min(left.end, right.end);
						refrige.remove(idx);
						refrige.add(idx, new Temp(s, e));
//						System.out.println(s + " ~ " + e);
						input = refrige.get(idx);
						canAdd = false;
					}
					else {
						idx++;
					}
				}
				if(canAdd) {
					refrige.add(input);
				}
			}
		}
		System.out.println(refrige.size());
	}
	
	static class Temp {
		int start, end;
		
		Temp(int s, int e) {
			start = s;
			end = e;
		}
	}
}
