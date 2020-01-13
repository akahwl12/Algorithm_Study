package hw;

import java.util.LinkedList;
import java.util.Scanner;

public class hw01_p1228 {
	static LinkedList<Integer> list = new LinkedList<>();
	static int N, M, X, Y;	// N:원본 암호문의 길이, M:명령어의 갯수, X:명령어가 삽입될 위치, Y:삽입될 숫자의 갯수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			list.clear();
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				sc.next();	// '|' 먹어버리기
				X = sc.nextInt();
				Y = sc.nextInt();
				for (int j = 0; j < Y; j++) {
					list.add(X++, sc.nextInt());
				}
			}
			
			System.out.print("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}
}
