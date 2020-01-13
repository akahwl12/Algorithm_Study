package ws;

import java.util.Scanner;

public class p1940 {
	static int TC, N, command, speedUp, speed, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			speed = speedUp = ans = 0;
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				command = sc.nextInt();
				if(command!=0) {
					speedUp = sc.nextInt();
					if(command==1) {
						speed += speedUp;
					}
					else if(command==2) {
						speed-=speedUp;
						if(speed<0)
							speed = 0;
					}
				}
				ans += speed;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
