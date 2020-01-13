package test;
//부분집합 만들기
public class Test03_subset {
	static char[] arr = {'a', 'b', 'c', 'd', 'e'};
	static boolean[] used = new boolean[arr.length];
	
	public static void main(String[] args) {
		
		comb(2, 0, 0);	// 뽑아야하는 갯수, 뽑은 갯수, 재귀가 사용한다 만다 기록해서 전달하면 마지막에 사용원소 확인용도의 배열
	}
	
	static void comb(int r, int target, int cnt) {
		if(cnt == r) {	// 뽑은 갯수 cnt가 목표하던 r개가 되었으면! 출력해보자!
			print();
			return;	// 더이상의 재귀는 보내지 않는다.
		}
		else if(target == arr.length) {
			return;
		}
		
		used[target] = true;
		comb(r, target+1, cnt+1);
		used[target] = false;
		comb(r, target+1, cnt);
	}
	
	static void print() {
		for (int i = 0; i < arr.length; i++) {
			if(used[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
}
