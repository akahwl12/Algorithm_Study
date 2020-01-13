package ssafy0809;

import java.util.Scanner;

public class hw05_baekjoon_p2231 {
	static int number;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		number = sc.nextInt();
		
		for (int i = 1; i <= number; i++) {
			if(i==number) {
				System.out.println(0);
				break;
			}
			int sum = i;
			String n = Integer.toString(i);
			for (int j = 0; j < n.length(); j++) {
				sum += Integer.parseInt(n.charAt(j)+"");
			}
			if(sum == number) {
				System.out.println(i);
				break;
			}
		}
	}
}
