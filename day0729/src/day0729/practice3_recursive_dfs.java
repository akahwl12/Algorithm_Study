package day0729;

import java.util.Scanner;

// stack을 쓰는 대신에 재귀함수 형태로 작성하면서 같은 효과 내보기
public class practice3_recursive_dfs {
	static int N, E;
	static boolean[][] link;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	//정점의 갯수
		E = sc.nextInt();	//연결선의 갯수
		link = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			link[a][b] = true;
			link[b][a] = true;
		}
		dfs(1);	//1번 정점부터 방문 시작
	}
	
	static void dfs(int now) {
		if(!visited[now]) { //현재 정점 now에 처음 방문인지 확인하고 print한 뒤 방문처리 true 해놓기.
			System.out.print(now + " "); 
			visited[now] = true;
		}
		for (int i = 1; i <= N; i++) {
			if(link[now][i] && !visited[i]) { //now에서 이동 가능한 i중에 방문한적 없는 i 찾았으면
				dfs(i);
			}
		}
	}
}
