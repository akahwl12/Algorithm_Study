package test01_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test03_BFS {
	static int N, M, dist;
	static boolean[][] map;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 정점의 갯수
		M = sc.nextInt();	// 연결선의 갯수
		visited = new boolean[N+1];
		map = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {	// 연결정보 입력받기
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			map[a][b] = true;
			map[b][a] = true;
		}
		
		queue.add(1);	// 출발 정점 번호를 일단 큐에 넣고 시작
		while(!queue.isEmpty()) {
			int now = queue.poll();
			visited[now] = true; // 현재 방문정점에 방문 기록하기
			System.out.println("현재 방문 정점 : " + now + ", 시작 정점 1과의 거리 : " + dist);
			for (int i = 1; i <= N; i++) {	// now와 이웃한 정점중 방문한적 없는 정점은 큐에 방문 예정으로 넣기
				if (map[now][i] && !visited[i]) {	// 여러 정점과 연결된 정점들은 큐에 중복되서 들어갈 가능성이 있으므로
					queue.add(i);
					visited[i] = true;	// 큐에 들어간 순간 방문처리 (큐에 다시 enQueue되는 일을 방지)
				}
			}
			dist++;
		}
		
		
	}
}
