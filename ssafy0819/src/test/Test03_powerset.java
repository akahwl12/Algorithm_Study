package test;

public class Test03_powerset {

	static int[] arr = {10,20,30};
	static boolean[] use = new boolean[arr.length];
	
	public static void main(String[] args) {
		powerset(0);
	}
	
	static void powerset(int target) {
		if(target == arr.length) {
			System.out.print("{");
			for (int i = 0; i < arr.length; i++) {
				if(use[i])
					System.out.print(arr[i]+" ");
			}
			System.out.println("}");
			return;
		}
		
		use[target] = true;
		powerset(target+1);
		use[target] = false;
		powerset(target+1);
	}
}
