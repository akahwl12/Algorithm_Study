package practice;
import java.util.Scanner;

public class Main {
	static Scanner sc;
	static int[][] map;
	static int[][] mem;
	static boolean[][] visited;
	static int Y, X;
	static int ans = 0;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		map = new int[Y][X];
		mem = new int[Y][X];
		visited = new boolean[Y][X];
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				mem[i][j] = -1;
			}
		}
		mem[0][0] = 1;
		System.out.println(dp(Y - 1, X - 1));
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				System.out.print(mem[i][j]+" ");
			}
			System.out.println();
		}
	}

	static int dp(int y, int x) {
		if (mem[y][x] == -1) {
			int sum = 0;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < X && ny >= 0 && ny < Y && map[y][x] < map[ny][nx]) {
					sum += dp(ny, nx);
				}
			}
			mem[y][x] = sum;
		}
		return mem[y][x];
	}
}