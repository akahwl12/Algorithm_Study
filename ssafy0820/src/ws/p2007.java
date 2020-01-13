package ws;

import java.util.Scanner;

public class p2007 {
	static int TC, ans;
	static String str;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			sb.delete(0, sb.length());
			str = sc.next();
			for (int i = 0; i < 30; i++) {
				sb.append(str.charAt(i));
				if(i!=0 && str.indexOf(str.charAt(i))==0 && str.indexOf(sb.substring(0, sb.length()-1),i)==sb.length()-1) {
					ans = i;
					break;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
