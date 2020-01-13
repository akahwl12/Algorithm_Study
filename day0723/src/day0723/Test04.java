package day0723;

import java.util.Arrays;

public class Test04 {
	public static void main(String[] args) {
		int[] nums = {1,45,87,51,1,84,21,54,4,2,12,12};
		
		selection_sort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void selection_sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
}
