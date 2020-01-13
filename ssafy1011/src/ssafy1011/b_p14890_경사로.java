package ssafy1011;

import java.util.Scanner;

public class b_p14890_경사로 {
	static int N, L, ans;
	static int[][] map;
	static boolean[] used;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			checkH(i);
		}
		for (int i = 0; i < N; i++) {
			checkV(i);
		}
		
		System.out.println(ans);
	}
	
	static void checkH(int i) {
		used = new boolean[N];
		int dist = 0;
		int prev = map[i][0];
		for (int j = 0; j < N; j++) {
			if(map[i][j]-prev <-1 || map[i][j]-prev > 1)
				return;
			else if(map[i][j]==prev)
				dist++;
			else if(map[i][j]-prev == 1) {
				if(dist<L)
					return;
				for (int k = 1; k <= L; k++) {
					if(used[j-k])
						return;
					used[j-k] = true;
				}
				dist = 1;
			}
			else if(map[i][j]-prev == -1) {
				dist = 1;
			}
			prev = map[i][j];
		}
		
		dist = 0;
		
		for (int j = N-1; j >= 0; j--) {
			if(map[i][j]-prev <-1 || map[i][j]-prev > 1)
				return;
			else if(map[i][j]==prev)
				dist++;
			else if(map[i][j]-prev == 1) {
				if(dist<L)
					return;
				for (int k = 1; k <= L; k++) {
					if(used[j+k])
						return;
					used[j+k] = true;
				}
				dist = 1;
			}
			else if(map[i][j]-prev == -1) {
				dist = 1;
			}
			prev = map[i][j];
		}
		ans++;
	}
	
	static void checkV(int j) {
		used = new boolean[N];
		int dist = 0;
		int prev = map[0][j];
		for (int i = 0; i < N; i++) {
			if(map[i][j]-prev <-1 || map[i][j]-prev > 1)
				return;
			else if(map[i][j]==prev)
				dist++;
			else if(map[i][j]-prev == 1) {
				if(dist<L)
					return;
				for (int k = 1; k <= L; k++) {
					if(used[i-k])
						return;
					used[i-k] = true;
				}
				dist = 1;
			}
			else if(map[i][j]-prev == -1) {
				dist = 1;
			}
			prev = map[i][j];
		}
		
		dist = 0;
		
		for (int i = N-1; i >= 0; i--) {
			if(map[i][j]-prev <-1 || map[i][j]-prev > 1)
				return;
			else if(map[i][j]==prev)
				dist++;
			else if(map[i][j]-prev == 1) {
				if(dist<L)
					return;
				for (int k = 1; k <= L; k++) {
					if(used[i+k])
						return;
					used[i+k] = true;
				}
				dist = 1;
			}
			else if(map[i][j]-prev == -1) {
				dist = 1;
			}
			prev = map[i][j];
		}
		ans++;
	}
}
