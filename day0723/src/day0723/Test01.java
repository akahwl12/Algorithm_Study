package day0723;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		int[] nums = {1,45,87,51,1,84,21,54,4,2,12,12};
		
		Arrays.sort(nums);
		
		System.out.println(Arrays.toString(nums));
		
		System.out.println(binarySearch(nums, 99));		// 출력 -1
		System.out.println(binarySearch(nums, 4));		// 출력 3
		System.out.println(binarySearch(nums, 12));		// 출력 4
		
		// Null Pointer Exception
		String s = null;
//		s = "123";
		
//		if(s.length() > 4) {
		if(s!=null  && s.length() > 4) {
			System.out.println("유효한 비밀번호입니다.");
		}
		else {
			System.out.println("비밀번호가 너무 짧습니다.");
		}
		
	}
	
	public static int binarySearch(int[] array, int key) {
		int idx = -1;
		
		//이곳을 구현하시오.
		int left=0, right=array.length-1, mid;
		
		while(left<=right) {
			mid = (left + right)/2;
			
			if(array[mid] == key) {
				idx = mid;
				while(mid-1>=0 && array[mid-1]==key) {
					idx = --mid;
				}
				break;
			}
			else if(array [mid] < key) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		return idx;
	}
}
