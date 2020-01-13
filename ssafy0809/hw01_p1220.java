package ssafy0809;
//D3 1220. [S/W 문제해결 기본] 5일차 - Magnetic
import java.util.Scanner;

public class hw01_p1220 {
	static int N, ans, prev;
	static int[][] map;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			ans = 0;
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int j = 0; j < N; j++) {
				prev = 0;
				for (int i = 0; i < N; i++) {
					if(prev==1 && map[i][j]==2) {
						ans++;
					}
					if(map[i][j]==1) {
						prev = 1;
					}
					else if(map[i][j]==2) {
						prev = 2;
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
