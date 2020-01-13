package Ssafy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class hw01_p1233 {
	static int N, isAble;
	static char data;
	static StringTokenizer st;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			isAble = 1;
			N = Integer.parseInt(sc.nextLine());
			
			for (int i = 0; i < N; i++) {
				String input = sc.nextLine();
				st = new StringTokenizer(input);
				st.nextToken();
				data = st.nextToken().charAt(0);
				int countChild = st.countTokens();
				if((('0'<=data && data<='9') && countChild>0)	// 숫자인데 자식이 있을때
						|| (!('0'<=data && data<='9') && countChild==0)) {	// 연산자인데 자식이 없을때
					isAble = 0;	// 연산 불가
				}
			}
			
			System.out.println("#" + t + " " + isAble);
		}
	}
}
