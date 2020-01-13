package ws;

import java.util.LinkedList;
import java.util.Scanner;

public class ws03_baekjoon_p1158 {
	static LinkedList<Integer> list = new LinkedList<>();
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {	//list에 1~N까지의 수 저장
			list.add(i);
		}
		
		int now = 0;
		System.out.print("<");
		while(list.size()!=0) {
			now = (now + (K-1)) % list.size();
			if(list.size()==1) {
				System.out.print(list.get(now));
			}
			else {
				System.out.print(list.get(now) + ", ");
			}
			list.remove(now);
		}
		System.out.println(">");
	}
}
