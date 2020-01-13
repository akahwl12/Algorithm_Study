package day0730;
//임의의 집합 원소들로 만들 수 있는 모든 부분집합 생성을 재귀로 작성해보기.

public class Test01 {
	static char[] array = {'a', 'b', 'c'};
	static boolean[] used = new boolean[array.length];
	
	public static void main(String[] args) {
		subSet(0);
	}
	
	static void subSet(int cnt) {
		if(cnt==array.length) {
			printSub();
			return;
		}
		used[cnt] = true;
		subSet(cnt+1);
		used[cnt] = false;
		subSet(cnt+1);
	}
	
	static void printSub() {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			if(used[i]) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println("}");
	}
}
