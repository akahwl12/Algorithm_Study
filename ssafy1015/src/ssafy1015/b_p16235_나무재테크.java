package ssafy1015;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b_p16235_나무재테크 {
	static int N, M, K, ans;
	static int map[][], energy[][];
	static PriorityQueue<Trees>[][] pq;
	static ArrayList<Trees> list = new ArrayList<>();
	static ArrayList<Trees> dead = new ArrayList<>();
	static int[] di = {1, 0, -1, 0, -1, -1, 1, 1};
	static int[] dj = {0, 1, 0, -1, -1, 1, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N+1][N+1];
		energy = new int[N+1][N+1];
		pq = new PriorityQueue[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				pq[i][j] = new PriorityQueue<Trees>();
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = 5;
				energy[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < M; i++) {
			pq[sc.nextInt()][sc.nextInt()].add(new Trees(sc.nextInt()));
		}
		
		grow();

		System.out.println(ans);
	}
	
	static void grow() {
		int cnt = 0, year = 0;
		
		while(year!=K) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					int qsize = pq[i][j].size();
					for (int t = 0; t < qsize; t++) {
						Trees now = pq[i][j].poll();
						
						int age = now.age;
						
						if(cnt==0) { //봄 여름
							if(age<=map[i][j]) {
								map[i][j] -= age;
								list.add(new Trees(age+1));
							}
							else {
								dead.add(new Trees(age));
							}
						}
						
						if(cnt==1) { //가을
							if(age%5 == 0) {
								list.add(now);
								for (int d = 0; d < di.length; d++) {
									int ni = i + di[d];
									int nj = j + dj[d];
									if(1<= ni && ni<=N && 1<=nj && nj<=N) {
										pq[ni][nj].add(new Trees(1));
									}
								}
							}
							else
								list.add(now);
						}
					}
					pq[i][j].addAll(list);
					list.clear();
					
					for (int k = 0; k < dead.size(); k++) {
						map[i][j] += (dead.get(k).age/2);
					}
					dead.clear();
				}
			}
			cnt++;
			if(cnt==2) { // 겨울
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						map[i][j] += energy[i][j];
					}
				}
				cnt = 0;
				year++;
			}
		}
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				ans += pq[i][j].size();
			}
		}
	}
	
	static class Trees implements Comparable<Trees>{
		int age;
		
		Trees(int a) {
			this.age = a;
		}

		@Override
		public int compareTo(Trees o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return "Trees [age=" + age + "]";
		}
		
	}
}
