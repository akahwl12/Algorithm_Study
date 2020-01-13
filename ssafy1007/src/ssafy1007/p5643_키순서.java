package ssafy1007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p5643_키순서 {
	// 큰값 찾는 탐색, 작은값 찾는 탐색 2번 돌려서 찾는다.
	
	static int T, N, M, ans;
	static ArrayList<Integer>[] lists;
	static boolean[] visited;
	static int[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			lists = new ArrayList[N+1];
			check = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				lists[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				lists[a].add(b);
			}
			
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N+1];
				dfs(i, i);
				System.out.println();
			}
			
			for (int i = 1; i <= N; i++) {
				if(check[i]==(N-1))
					ans++;
			}
			
			System.out.println("#" + tc + " " + ans);
			
			for (int i = 1; i < lists.length; i++) {
				for (int j = 0; j < lists[i].size(); j++) {
					System.out.print(i + " : " + lists[i].get(j) + " / ");
				}
				System.out.println();
			}
			
			System.out.println(Arrays.toString(check));
		}
	}
	
	static void dfs(int now, int start) {
		if(visited[start])
			return;
		
		System.out.println("start : " + start);
		
		visited[start] = true;
		check[now]++;
		
		for (int i = 0; i < lists[start].size(); i++) {
			dfs(now, lists[start].get(i));
		}
	}
}
