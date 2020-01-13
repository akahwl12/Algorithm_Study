package test;

import java.util.Arrays;

public class Test03 {
	public static void main(String[] args) {
		int[] arr = new int[]{15,48,78,84,1,153,51,135,21};
		
		mergeSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSort(int[] arr, int left, int right) {
		
		if(left>=right)	// 더이상 나눌수 없다고 판단하면 그만나눠..재귀 그만....
			return;
		
		int mid = (left + right)/2;
		
		mergeSort(arr, left, mid);		// 일단 왼쪽부분 만들어와
		mergeSort(arr, mid+1, right);	// 오른쪽 부분도 만들어와
		
		// 두 부분 배열이 각각 정렬된 상태로 오겠지. 병합하자!
		
//		int leftSize = mid - left + 1;	// left~right까지 홀수개이면 왼쪽배열을 하나 크게해서 나누쟈~
//		int rightSize = right - mid;
		
		int[] leftArr = Arrays.copyOfRange(arr, left, mid+1);
		int[] rightArr = Arrays.copyOfRange(arr, mid+1, right+1);
		
		int idx_l=0, idx_r=0;
		int idx = left;	// 현재 정렬해야 되는 영역은 left부터 right까지임. 해당 영역을 정렬된 상태로 채울 것임.
		
		// 양쪽 부분배열에 원소가 둘다 남아있으면
		while(idx_l < leftArr.length && idx_r < rightArr.length) {
			if(leftArr[idx_l] < rightArr[idx_r]) {	// 왼쪽 부분배열이랑 오른쪽 부분배열에 있는 애중에
				arr[idx] = leftArr[idx_l];		
				idx_l++;// 더 작은 원소 가져다 사용하기.
			}
			else {
				arr[idx] = rightArr[idx_r];;
					idx_r++;
			}
			idx++;
		}
		// 두 부분배열중 하나를 다 썼으면 위의 while이 끝나겠죠?
		// 그러면 왼쪽이든 오른쪽이든 나머지를 싹 가져다 놓으면 되겠네요.
		while(idx_l < leftArr.length) {	// 왼쪽 부분배열에 값이 남았어?
			arr[idx++] = leftArr[idx_l++];
		}
		while (idx_r < rightArr.length) {	// 오른쪽 부분배열에 값이 남았어?
			arr[idx++] = rightArr[idx_r++];
		}
	}
}
