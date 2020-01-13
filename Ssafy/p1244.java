package Ssafy;

import java.util.ArrayList;
import java.util.Scanner;

public class p1244 {
	static int max, max_idx, data, T, cnt;
	static boolean isSame;
	static StringBuffer sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			isSame = false;
			max = -1;
			list.clear();
			StringBuffer sb = new StringBuffer(sc.next());
			for (int i = 0; i < sb.length(); i++) {
				data = Integer.parseInt(""+sb.charAt(i));
				list.add(data);
				if(data>=max) {
					if(data==max) {
						isSame = true;
					}
					max = data;
					max_idx = i;
				}
			}
			cnt = sc.nextInt();
			
			for (int i = 0; i<cnt; i++) {
				if(i<list.size()) {
					if(list.get(i)!=max) {
						int num1 = list.get(i);
							
						list.add(i, max);
						list.remove(i+1);
						list.add(max_idx, num1);
						list.remove(max_idx+1);
					}
					else {
						cnt++;
					}
				
					if(i!=cnt-1) {	//마지막 회차때는 최대값 검사 안해도됨.
						max = -1;
						for (int j = i+1; j<list.size(); j++) {
							data = list.get(j);
							if(data>=max) {
								max = data;
								max_idx = j;
							}
						}
					}
				}
				else if(!isSame){
					int last = list.size()-1;
					int tmp = list.get(last);
					list.set(last, list.get(last-1));
					list.set(last-1, tmp);
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}
}
