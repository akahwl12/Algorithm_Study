package Ssafy;

import java.util.Scanner;

public class p8676_동현한결아이돌 {
    static int T, ans;
    static String input;
    static String S = "SAMSUNG";
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
        	ans = 0;
            input = sc.next();
             
            find(0, 0);
            
            System.out.println("#" + tc + " " + ans);
        }
    }
     
    static void find(int now, int cnt) {
    	ans %= 1000000007;
    	if(S.length() == cnt) {
    		ans++;
    		return;
    	}
    	if(input.length() == now)
    		return;
        
        if(input.charAt(now) == S.charAt(cnt)) {
        	find(now+1, cnt+1);
        }
        find(now+1, cnt);
    }
}
