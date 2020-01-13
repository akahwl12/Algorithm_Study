package ssafy0930;

import java.util.Scanner;

public class b_p2630_색종이만들기 {
	static int N, cnt, blue, white;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		check(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void check(int x, int y, int size) {
		if(size==0)
			return;
		
		cnt = 0;
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(map[i][j]==1)
					cnt++;
			}
		}

		if(cnt == size*size) {
			blue++;
			return;
		}
		else if(cnt == 0) {
			white++;
			return;
		}
		
		check(x, y, size/2);
		check(x+(size/2), y, size/2);
		check(x, y+(size/2), size/2);
		check(x+(size/2), y+(size/2), size/2);
	}
}
