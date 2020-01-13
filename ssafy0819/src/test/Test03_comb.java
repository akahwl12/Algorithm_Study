package test;

public class Test03_comb {

	static int[] arr = {10,20,30,40,50,60};
	static boolean[] use = new boolean[arr.length];
	
	public static void main(String[] args) {
		comb(0, 3, 0);
	}
	
	// cnt:뽑은 원소의 갯수, r:뽑아야 하는 목표치, target:현재 결정할 원소 번호
	static void comb(int cnt, int r, int target) {
		if(cnt == r) {	// 사용하기로 뽑은 원소의 갯수가 r개가 되었다.
			System.out.print("{");
			for (int i = 0; i < arr.length; i++) {
				if(use[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println("}");
			return;
		}
		else if(target == arr.length) {	// 위의 if에 안걸렸으면 cnt가 r개가 안됬다는건데 target 인덱스가 끝까지??
			return;
		}
		else if(cnt+(arr.length-target)<r) { 
			return;
		}
		
		use[target] = true;
		comb(cnt+1, r, target+1);
		use[target] = false;
		comb(cnt, r, target+1);
	}
}
