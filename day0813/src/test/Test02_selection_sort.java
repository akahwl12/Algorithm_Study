package test;

import java.util.Arrays;

public class Test02_selection_sort {
	static int[] num = {1,9,8,7,6,5,4,3,2,1};
	public static void main(String[] args) {
		selction_sort(0);
		System.out.println(Arrays.toString(num));
	}
	
	static void selction_sort(int idx) {
		if(idx==num.length-1)	return;
		
		for (int i = idx+1; i < num.length; i++) {
			if(num[idx]>num[i]) {
				int tmp = num[idx];
				num[idx] = num[i];
				num[i] = tmp;
			}
		}
		selction_sort(idx+1);
	}
}
