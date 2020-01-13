package ssafy1008;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p7701_염라대왕 {
	static int T, N;
	static Set<String> tree = new TreeSet<>();
	static String[] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			tree.clear();
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				tree.add(sc.next());
			}
			
			ans = tree.toArray(new String[tree.size()]);
			Arrays.sort(ans, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.length() - o2.length();
				}
			});
			
			System.out.println("#"+tc);
			for (int i = 0; i < ans.length; i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
