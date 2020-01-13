package day0722;

import java.util.Arrays;

public class hw01_binary_search {
	public static void main(String[] args) {
		int[] nums = {1,45,87,51,1,84,21,54,4,2,12,12};
		
		Arrays.sort(nums);
		
		System.out.println(Arrays.toString(nums));
		
		System.out.println(binarySearch(nums, 99));		// 출력 -1
		System.out.println(binarySearch(nums, 4));		// 출력 3
		System.out.println(binarySearch(nums, 12));		// 출력 4
	}
	
	public static int binarySearch(int[] array, int key) {
		int idx = -1;
		
		//이곳을 구현하시오.
		int low, mid, high;
		low = 0;
		high = array.length - 1;
		mid = (high + low) / 2;
		
		while(low <= high) {
			mid = (high + low) / 2;
			if(key == array[mid]) {
				return mid;
			}
			else if(key < array[mid]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		
		return idx;
	}
}
