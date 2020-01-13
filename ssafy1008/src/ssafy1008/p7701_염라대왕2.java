package ssafy1008;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class p7701_염라대왕2 {
	static int T, N;
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			list.clear();
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				String input = sc.next();
				if(!list.contains(input))
					list.add(input);
			}
			
			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length() > o2.length())
						return 1;
					else if(o1.length() < o2.length())
						return -1;
					else
						return o1.compareTo(o2);
				}
			});
			
			System.out.println("#"+tc);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
