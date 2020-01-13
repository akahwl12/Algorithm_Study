package day0722;

import java.util.Random;

public class practice01 {
	public static void main(String[] args) {
		int[][] arr;
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int sum, ans=0, cnt=0;
		
		Random rd = new Random();
		
		arr = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = rd.nextInt(25) + 1;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				sum = 0;
				cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nextX = i + dx[k];
					int nextY = j + dy[k];
					
					if(nextX>=0 && nextX<5 && nextY>=0 && nextY<5) {
						sum += Math.abs(arr[nextX][nextY] - arr[i][j]);
						cnt++;
					}
				}
				System.out.println(arr[i][j] + "ÀÇ ÀÌ¿ôÇÑ °ªÀÇ Â÷ÀÌ : " + sum + "\t/\tÀÌ¿ôÇÑ ¿ä¼ÒÀÇ °¹¼ö : " + cnt);
				ans += sum;
			}
		}
		System.out.println("ÃÑÇÕ : " + ans);
	}
}
