package Brute_force;

import java.util.*;

public class p1038_Diminish_Number {

	public static void main(String[] args) {
		int N, cnt=0;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		String[][] num = new String[7][10];
		String[][] num2 = new String[7][10];
		
		for(int i=0; i<7; i++) {
			Arrays.fill(num[i], "");
		}
		
		int dp[] = new int[N+1];
		
		for(int i=0; i<10; i++) {
			num[1][i] = Integer.toString(i);
			dp[i] = i;
			cnt++;
		}
		
		for(int i=2; i<7; i++) {if(cnt >= N+1)	break;
			for(int j=1; j<10; j++) {if(cnt >= N+1)	break;
				for(int k=1; k<=j;k++) {if(cnt >= N+1)	break;
					for(int m=0; m<num[i-1][j-1].split(",").length; m++) {
						num[i][j] += j+num[i-1][j-k].split(",")[m] + ",";
						System.out.println("i:" + i+",j:"+j+"  "+num[i][j]);
					}
				}
				for(int m=0; m<num[i][j].split(",").length; m++) {if(cnt >= N+1)	break;
					dp[cnt] = Integer.parseInt(num[i][j].split(",")[num[i][j].split(",").length-m-1]);
					cnt++;
				}
			}
		}
		System.out.print(dp[N]);
	}

}
