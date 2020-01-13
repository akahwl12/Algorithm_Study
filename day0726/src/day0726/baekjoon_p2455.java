package day0726;

import java.util.Scanner;

public class baekjoon_p2455 {
	public static void main(String[] args) {
		int in, out;
		int max = 0, people = 0;;
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			out = sc.nextInt();
			people-=out;
			in = sc.nextInt();
			people+=in;
			if(max < people)
				max = people;
		}
		System.out.println(max);
	}
}
