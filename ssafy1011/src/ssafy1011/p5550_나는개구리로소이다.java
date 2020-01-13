package ssafy1011;

import java.util.Scanner;

public class p5550_나는개구리로소이다 {
	static int[] croak;
	static int T, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			croak = new int[5];
			ans = 0;
			String input = sc.next();
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i)=='c')
					croak[0]++;
				else if(input.charAt(i)=='r') {
					if(croak[0]>croak[1])
						croak[1]++;
					else {
						ans = -1;
						break;
					}
				}
				else if(input.charAt(i)=='o') {
					if(croak[1]>croak[2])
						croak[2]++;
					else {
						ans = -1;
						break;
					}
				}
				else if(input.charAt(i)=='a') {
					if(croak[2]>croak[3])
						croak[3]++;
					else {
						ans = -1;
						break;
					}
				}
				else if(input.charAt(i)=='k') {
					if(croak[3]>croak[4]) {
						for (int j = 0; j < 4; j++) {
							croak[j]--;
						}
					}
					else {
						ans = -1;
						break;
					}
				}
				ans = Math.max(ans, croak[0]);
			}
			for (int i = 0; i < 5; i++) {
				if(croak[i]!=0) {
					ans = -1;
					break;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
