package ws;

import java.util.Scanner;

public class Solution_p1247 {
	static int N;
	static int ans;
	static int[][] point;	// x, y 좌표를 N+2개 저장할 배열
	static boolean[] visited;	// 순열 생성할 때 사용할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			
			point = new int[N+2][2];
			visited = new boolean[N+2];
			
			point[0][0] = sc.nextInt();	// 회사 x좌표
			point[0][1] = sc.nextInt(); // 회사 y좌표
			point[N+1][0] = sc.nextInt(); // 집 x좌표
			point[N+1][1] = sc.nextInt(); // 집 y좌표
			
			for (int i = 1; i <= N; i++) {
				point[i][0] = sc.nextInt(); // 고객의 x좌표
				point[i][1] = sc.nextInt(); // 고객의 y좌표
			}
			
			ans = Integer.MAX_VALUE;
			dfs(point[0][0], point[0][1], 0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void dfs(int prevX, int prevY, int cnt, int distance) {
		if(cnt==N) { // N개의 고객집을 선택해서 한가지 경우가 만들어졌음! 마지막 고객네서 내집까지 가는 거리 구하기
			distance += Math.abs(point[N+1][0]-prevX) + Math.abs(point[N+1][1]-prevY);
			if(ans > distance)
				ans = distance;
			return;
		}
		if(distance >= ans) { // 아직 N개의 선택을 안한 상태. 경우의수가 완성되지 않았지만!
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true; // 내가 사용할거니 내 이후 재귀한테 이거 빼고 선택하라고 알리는 용도
				int tmp = Math.abs(point[i][0]-prevX) + Math.abs(point[i][1]-prevY); // 이전 장소에서 지금 내가 선택한 i번째 집까지의 부분거리 
				dfs(point[i][0], point[i][1], cnt+1, distance + tmp);
				visited[i] = false;
			}
		}
	}
}