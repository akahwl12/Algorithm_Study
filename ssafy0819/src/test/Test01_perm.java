package test;

import java.util.Arrays;

// Johnson-trotter 알고리즘
public class Test01_perm {
	static int[] arr = {1,2,3,4};
	
	public static void main(String[] args) {
		perm(0);
	}
	
	static void perm(int k) {
		if(k==arr.length) {
			System.out.println(Arrays.toString(arr));
		}
		
		for (int i = k; i < arr.length; i++) {
			swap(i, k);
			perm(k+1);
			swap(i, k);
		}
	}
	
	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
