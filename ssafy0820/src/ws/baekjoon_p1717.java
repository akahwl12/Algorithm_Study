	package ws;
	
	import java.util.Scanner;
	
	public class baekjoon_p1717 {
		static int TC, N, M, command, a, b;
		static int[] arr;
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			TC = sc.nextInt();
			for (int tc = 1; tc <= TC; tc++) {
				N = sc.nextInt();
				M = sc.nextInt();
				arr = new int[N+1];
				for (int i = 1; i < arr.length; i++) {
					arr[i] = i;
				}
				
				System.out.print("#" + tc + " ");
				for (int i = 0; i < M; i++) {
					command = sc.nextInt();
					a = sc.nextInt();
					b = sc.nextInt();
					if(command==0)
						union(a, b);
					else {
						if(find(a)==find(b))
							System.out.print("1");
						else
							System.out.print("0");
					}
				}
				System.out.println();
			}
		}
		
		static int find(int x) {
			if(arr[x] == x)
				return x;
			else {
				int parent = find(arr[x]);
				arr[x] = parent;
				return parent;
			}
		}
		
		static void union(int a, int b) {
			int p1 = find(a);
			int p2 = find(b);
			
			if(p1!=p2) {
				arr[p2] = p1;
			}
		}
	}
