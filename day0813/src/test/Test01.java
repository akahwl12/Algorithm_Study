package test;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
	static int ans, R, N;
	static int[] room;
	static boolean[] used;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();	// 총 사무실의 갯수
		N = sc.nextInt();
		
		room = new int[R];
		used = new boolean[R];
		
		for (int i = 1; i <= R; i++) {	// 1번부터 R번 방까지 방번호 기록해놓기.
			room[i-1] = i;
		}
		
		ans = 0;	// 총 경우의 수가 몇가지 나오는지 세기위한 변수
		int[] select = new int[N];
		pick(0, select);
		System.out.println(ans);
	}
	
	public static void pick(int cnt, int[] select) {
		if(cnt == N) {	// 직원의 수만큼 방이 선택됬다. 어떻게 선택됬는지 출력해볼까.
			System.out.println(Arrays.toString(select));
			ans++;
			return;
		}
		for (int i = 0; i < R; i++) {
			if(!used[i]) {
				used[i] = true;	// i번 방은 내가씀~
				select[cnt] = room[i];
				pick(cnt+1, select);
				used[i] = false;	// i번 방 써봤으니까 이제 다른 i번 방 써볼거야. 이건 미사용 상태로 돌려놓을게
			}
		}
	}
}
