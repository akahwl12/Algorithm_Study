package ssafy1001;

import java.util.Scanner;

public class b_p6987_월드컵 {
	static int ans;
	static Team[] score = new Team[6];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 0; tc < 4; tc++) {
			for (int t = 0; t < 6; t++) {
				score[t].win = sc.nextInt();
				score[t].draw = sc.nextInt();
				score[t].lose = sc.nextInt();
				
				
				
			}
		}
	}
	
	static class Team {
		int win, draw, lose;
	}
}
