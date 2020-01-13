package day0723;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_p10815 {
	public static void main(String[] args) {
		int N, M;
		int[] user = new int[500001];
		int[] cards = new int[500001];
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			user[i] = sc.nextInt();
		}
		
		
		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			cards[i] = sc.nextInt();
		}
		
		Arrays.sort(user, 0, N);
		
		
		for (int i = 0; i < M; i++) {
			System.out.print(binary_sort(user, 0, N-1, cards[i]) + " ");
		}
	}
	
	public static int binary_sort(int[] arr, int low, int high, int key) {
		int mid;
		
		while(low <= high) {
			mid = (low + high)/2;
			
			if(arr[mid]==key)	return 1;
			else if(arr[mid] < key)	low = mid+1;
			else	high = mid-1;
		}
		return 0;
	}
}
