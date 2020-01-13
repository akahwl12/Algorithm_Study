package dfs_bfs;

import java.util.*;

public class p2667_apart_number {
	
	static int cnt=1, N;
	static int dx[] = {1, 0, -1, 0}; 
	static int dy[] = {0, 1, 0, -1};
	static int[][] arr = new int[26][26];
	static Queue<Integer>mapX = new LinkedList();
	static Queue<Integer>mapY = new LinkedList();
	static boolean[][] visited = new boolean[26][26];
	static ArrayList<Integer> total = new ArrayList();
	
	public static int bfs() {
		cnt=1;
		int x, y, nx, ny;
		
		while(!mapX.isEmpty() && !mapY.isEmpty()) {
			x = mapX.poll();
			y = mapY.poll();
			arr[x][y] = cnt;
			cnt++;
			visited[x][y] = true;
			
			for(int i=0; i<4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || nx > N-1 || ny < 0 || ny > N-1) continue;
				else {
					if(arr[nx][ny]==1 && !visited[nx][ny])  {
						mapX.offer(nx);
						mapY.offer(ny);
						visited[nx][ny] = true;
					}
				}
			}
		}
		return cnt-1;
	}
	
	public static void main(String[] args) {
		String numm;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {	//map을 입력받는다
			numm = sc.next();
			for(int j=0; j<N; j++) {
				arr[j][i] = Integer.parseInt(numm.split("")[j]);
			}
		}
		
		for(int i=0; i<N; i++) {	//입력받은 map중에서 1이 나오는 순간마다 bfs실행
			for(int j=0; j<N; j++) {
				if(arr[j][i]==1) {
					mapX.offer(j);
					mapY.offer(i);
					total.add(bfs()); //total ArrayList에  bfs 결과값(최대값) 추가
				}
			}
		}
		
		Collections.sort(total); //total ArrayList 정렬
		
		System.out.println(total.size());
		for(int i=0; i<total.size(); i++) {
			System.out.println(total.get(i));
		}

	}

}
