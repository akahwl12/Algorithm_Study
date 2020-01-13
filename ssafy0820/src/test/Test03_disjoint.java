package test;

public class Test03_disjoint {
	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		
		System.out.println("1의 대표 : " + find(arr, 1)); // 1의 대표는 1
		System.out.println("2의 대표 : " + find(arr, 2)); // 2의 대표는 2
		System.out.println("3의 대표 : " + find(arr, 3)); // 3의 대표는 3
		System.out.println("4의 대표 : " + find(arr, 4)); // 4의 대표는 4
		System.out.println("5의 대표 : " + find(arr, 5)); // 5의 대표는 5
		
		union(arr, 1, 2);
		union(arr, 2, 3);
		union(arr, 4, 5);

		System.out.println("1의 대표 : " + find(arr, 1)); // 1의 대표는 1
		System.out.println("2의 대표 : " + find(arr, 2)); // 2의 대표는 2
		System.out.println("3의 대표 : " + find(arr, 3)); // 3의 대표는 3
		System.out.println("4의 대표 : " + find(arr, 4)); // 4의 대표는 4
		System.out.println("5의 대표 : " + find(arr, 5)); // 5의 대표는 5
	}
	
	static int find(int[] arr, int x) {
		if(arr[x] == x) {
			return x;
		}
		else {
			int parent = find(arr, arr[x]);
			return parent;
		}
	}
	
	static void union(int[] arr, int a, int b) {
		int p1 = find(arr,a);
		int p2 = find(arr, b);
		
		if(p1 != p2) {
			arr[p2] = p1;
		}
	}
}
