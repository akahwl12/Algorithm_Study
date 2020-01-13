package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * 1. 정점중 아무거나 일단 시작 정점 고르기
 * 2. 고른 정점에 연결된 간선(Edge)들 중에서 최소비용 간선 고르기 - 우선순위 큐(Heap) 사용해보자
 * 		-> 간선을 고르면 그 끝에 매달린 정점도 선택받은 애가 됨.
 * 3. 선택한 모든 정점들에 (새로 선택받은 애 포함) 연결된 모든 간선들(큐에 넣어서)중 최소비용 간선 찾아서 선택
 * 4. 모든 정점이 다 선택될 때까지 2,3 반복
 * 
 */
public class Test04_prim {
	static int N, E;
	static LinkedList<Edge>[] graph; // 인접 연결 리스트
	static boolean[] visit;
	static ArrayList<Edge> mst;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		
		graph = new LinkedList[N+1];
		visit = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for (int e = 0; e < E; e++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int value = sc.nextInt();
			
			graph[v1].add(new Edge(v1, v2, value));
			graph[v2].add(new Edge(v2, v1, value));
		} // 입력받기 완료.
		
		// Minimum Spanning Tree 만들기
		makeMST();
		System.out.println(mst);
	} // end main

	static void makeMST() {
		mst = new ArrayList<>();
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());	// 최소비용간선 선택 용도
		Queue<Integer> queue = new LinkedList<>();	// 정렬 방문 스케쥴링 용도
		
		queue.add(1);	// 시작점 임의로 선택
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			visit[now] = true;
			LinkedList<Edge> nowEdges = graph[now];
			
			for (Edge e : nowEdges) {	// now에 연결된 모든 간선을 pq에 넣긴 할건데
				if(!visit[e.end]) {	// 해당 간선을 따라 갔을 떄 가게되는 정점이 아직 미방문인 간선들만 관심있음
					pq.add(e);
				}
			}
			
			while(!pq.isEmpty()) {	// 모아둔 간선들을 하나씩 꺼내서 선택해야함!
				Edge edge = pq.poll();	// 간선중에 일단 제일 짧은 애가 나오겠네
				if(!visit[edge.end]) {	// 그거 선택했을 때 확실히 미방문 정점으로 가는지 확인하고
					visit[edge.end] = true;	// 이제 간선 선택한거니까 그 끝에 있는 정점 방문완료
					queue.add(edge.end);
					mst.add(edge);
					break;
				}
			}
		}
	}
	
	static class Edge {
		int start, end, value;
		
		Edge(int s, int e, int v) {
			start = s;
			end = e;
			value = v;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]\n";
		}
		
	}
	
	static class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value - o2.value;
		}
	}
}
