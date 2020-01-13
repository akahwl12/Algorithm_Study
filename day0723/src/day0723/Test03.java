package day0723;
// Binary Search (Recursion)

import java.util.Arrays;

public class Test03 {

	static int[] nums = {1,45,87,51,1,84,21,54,4,2,12,12};
	public static void main(String[] args) {
		
		Arrays.sort(nums);
		
		System.out.println(Arrays.toString(nums));
		
		System.out.println(binarySearch(0, nums.length-1, 99));		// 출력 -1
		System.out.println(binarySearch(0, nums.length-1, 4));		// 출력 3
		System.out.println(binarySearch(0, nums.length-1, 12));		// 출력 4
	}
	
	public static int binarySearch(int low, int high, int key) {
		if(low>high)	return -1;		// 기저조건(반드시 중요하다)
		
		int mid = (low + high)/2;
		
		if(nums[mid]==key) {
			while(nums[mid-1]==key) {
				mid--;
			}
			return mid;
		}
		else if(nums[mid] < key)	return binarySearch(mid+1, high, key);
		else	return binarySearch(low, mid-1, key);
	}
}
