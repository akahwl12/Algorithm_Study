package ssafy1014;

import java.util.Scanner;

public class b_p1717_집합의표현 {

	static int N, M;
	static int[] disjoint;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		disjoint = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			disjoint[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			int op = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(op==0)
				union(a, b);
			else {
				if(find(a)==find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
	
	static void union(int a, int b) {
		if(find(a)==find(b))
			return;
		else {
			int aa = find(a);
			int bb = find(b);
			
			disjoint[aa] = bb;
		}
	}
	
	static int find(int a) {
		if(disjoint[a] == a)
			return a;
		else {
			int parent = find(disjoint[a]);
			disjoint[a] = parent;
			return parent;
		}
	}
}
