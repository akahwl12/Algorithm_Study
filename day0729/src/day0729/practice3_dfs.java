package day0729;

import java.util.Scanner;
import java.util.Stack;

public class practice3_dfs {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//정점의 갯수
		int E = sc.nextInt();	//연결선의 갯수
		boolean[][] link = new boolean[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		for (int i = 1; i <= E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			link[a][b] = true;
			link[b][a] = true;
		}
		
		int now = 1;
		while(true) {
			//정점에 대한 방문 처리
			if(!visited[now])
				System.out.print(now + " "); //stack을 pop할때 now에 이미 방문한 정점 번호가 들어갈 수 있음. 그때 print 또 하기 싫음.
			
			visited[now] = true;
			///////////////////////////////////////////////////////
			//현재 방문 정점과 연결된 인접 정보 탐색
			boolean isGo = false; //now에 인접하고 가본적은 없는 정점을 찾으면 true로 바꿔야지~
			for (int i = 1; i <= N; i++) {
				if(link[now][i] && !visited[i]) { //now -> i 가능하면서 방문한적 없는 i
					stack.push(now);
					isGo = true;
					now = i;
					break;
				}
			}
			
			//무한 반복문의 종료조건 확인 & 현재 앞으로가야하는지 or 뒤로 pop해서 뒷걸음 쳐야 하는지 검사
			if(stack.isEmpty() && !isGo) { //뒷걸음칠 pop도 없고 앞으로 더이상 진행도 못하는 경우
				break; //while 탈출
			}
			else if(!isGo) { //stack이 비어있지는 않아서 뒷걸음은 칠 수 있는 경우
				now = stack.pop();
			}
		}
	}
}
