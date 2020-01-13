package day0812;

import java.util.Scanner;

public class p1228_array {
	static int N, X, Y;	//N:암호문의 길이, X:삽입될위치, Y:삽입될 숫자 갯수
	static int[] pw = new int[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			for (int i = 0; i < 10; i++) {
				pw[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N-10; i++) {
				sc.nextInt();
			}
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				sc.next();
				X = sc.nextInt();
				Y = sc.nextInt();
				for (int j = X; j<10 && j<X+Y; j++) {
					pw[j] = sc.nextInt();
				}
				for (int j = 0; X<10 && X+Y>=10 && j<Y-(10-X); j++) {
					sc.nextInt();
				}
				if(X>=10) {
					for (int j = 0; j < Y; j++) {
						sc.next();
					}
				}
			}
			
			System.out.print("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + pw[i]);
			}
			System.out.println();
		}
	}
}
