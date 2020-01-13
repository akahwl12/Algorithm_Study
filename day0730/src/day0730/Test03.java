package day0730;
//분할 정복 기법을 활용하는 퀵정렬 예제import java.lang.reflect.Array;

import java.util.Arrays;

public class Test03 {
	static int[] array = {1, 5, 96, 7, 2, 46, 15, 51, 33};
	
	public static void main(String[] args) {
		quickSort(0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	static void quickSort(int left, int right) {
		if(left<right) {
			int newPivot = partition(left, right);
			
			quickSort(left, newPivot-1);
			quickSort(newPivot+1, right);
		}
	}
	static int partition(int left, int right) {
		int pivot = array[(left + right)/2]; //배열의 left와 right 중간에 위치한 배열값
		
		while(left<right) {
			while(array[left]<pivot && left<right)	left++;
			while(pivot<array[right] && left<right)	right--;
			if(left<right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
			}
		}
		return left;
	}
}

