package ssafy0809;
// D3 6730. 장애물 경주 난이도
import java.util.Scanner;

public class hw03_p6730 {
	static int[] ans = new int[101];
	static int[] block = new int[101];
	static int T, N, max, min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			for (int i = 1; i <= N; i++) {
				block[i] = sc.nextInt();
			}
			ans[1] = block[1];
			max = 0;
			min = 0;
			for (int i = 2; i <= N; i++) {
				ans[i] = block[i] - block[i-1];
				if(ans[i]>max)	max = ans[i];
				if(ans[i]<min)	min = ans[i];
			}
			if(min<0)	min*=-1;
			System.out.println("#" + t + " " + max + " " + min);
		}
	}

}
