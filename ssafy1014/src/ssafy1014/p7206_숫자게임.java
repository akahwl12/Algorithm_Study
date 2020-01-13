package ssafy1014;

import java.util.Arrays;
import java.util.Scanner;

public class p7206_숫자게임 {
	static int T, ans, cc;
	static StringBuilder input, tmp;
	static int[] comb_arr;
	static boolean[] used;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			ans = 0;
			cc = 1;
			input = new StringBuilder(sc.next());
			tmp = new StringBuilder(input);
			used = new boolean[input.length()-1];

			for (int i = 1; i < input.length(); i++) {
				comb_arr = new int[i];
				comb(0, 0, i, cc);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void count(int rst, int cc_cnt) {
		StringBuilder s = new StringBuilder();
		int idx = 0;
		
		for (int i = 0; i < tmp.length(); i++) {
			if(i==comb_arr[idx]+1) {
				rst = Integer.parseInt(s.toString()) * Integer.parseInt(tmp.charAt(i)+"");
				s.delete(0, s.length());
				if(idx<comb_arr.length-1)
					idx++;
			}
			else {
				s.append(tmp.charAt(i));
			}
		}
		tmp = new StringBuilder(rst);
		for (int i = 1; i < tmp.length(); i++) {
			comb_arr = new int[i];
			comb(0, 0, i, cc_cnt+1);
		}
		ans = Math.max(ans, cc_cnt);
	}
	
	static void comb(int target, int now, int cnt, int cc_cnt) {
		if(now==cnt) {
			System.out.println(Arrays.toString(comb_arr));
			count(1, cc_cnt);
			return;
		}
		if(target==tmp.length()-1)
			return;
		
		comb_arr[now] = target;
		comb(target+1, now+1, cnt, cc_cnt);
		comb(target+1, now, cnt, cc_cnt);
		ans = Math.max(ans, cc_cnt);
	}
}
