package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test05_kruskal {
		static int N, E;
		static boolean[] visit;
		static int[] disjoint;
		static ArrayList<Edge> mst;
		static PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());	// 최소비용간선 선택 용도
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			E = sc.nextInt();
			
			visit = new boolean[N+1];
			
			for (int e = 0; e < E; e++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				int value = sc.nextInt();
				
				pq.add(new Edge(v1, v2, value));
			} // 입력받기 완료.
			
			// kruskal 구현
			kruskal();
			
			System.out.println(mst);
		} // end main
		
		static void kruskal() {
			mst = new ArrayList<>();
			disjoint = new int[N+1];
			for (int i = 1; i <= N; i++) {
				disjoint[i] = i;
			}
			
			while(mst.size() < (N-1)) {
				Edge edge = pq.poll();
				
				if(find(edge.start) != find(edge.end)) {
					union(edge.start, edge.end);
					mst.add(edge);
				}
			}
		}
		
		static int find(int n) {
			if(disjoint[n] == n)
				return n;
			disjoint[n] = find(disjoint[n]);
			return disjoint[n];
		}
		
		static void union(int n1, int n2) {
			int p1 = find(n1);
			int p2 = find(n2);
			
			if(p1 != p2)
				disjoint[p1] = p2;
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
