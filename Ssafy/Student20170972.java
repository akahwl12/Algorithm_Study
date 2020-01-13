package Ssafy;

import java.util.Scanner;
import java.util.Arrays;

public class Student20170972 {
	static int error, rst, len, k, ans = Integer.MAX_VALUE;
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		len = sc.nextInt(); // 총길이
		k = sc.nextInt(); // 그룹 수

		int[] items = new int[len];
		int[] bucket = new int[k];
		for (int i = 0; i < len; i++) {
			items[i] = i + 1; // 1~len까지의 배열생성
		}

		nums = new int[len];

		for (int i = 0; i < len; i++) { // 입력할 수들 입력
			nums[i] = sc.nextInt(); // 임의의 수들
		}

		Arrays.sort(nums); // 배열 정렬됨
		solution(items, bucket, k);

		System.out.println(ans);

	}

	private static void solution(int[] items, int[] bucket, int k) {
		if(k==0) {
			int cnt = 0;
			for (int i = 0; i < bucket.length; i++) {
				cnt += bucket[i];
			}
			if(cnt==len) {
				error = 0;
				int startIdx = 0;
				for (int i = 0; i < bucket.length; i++) {
					rst = Integer.MAX_VALUE;
					
					for (int j = nums[startIdx]; j <= nums[startIdx+bucket[i]-1]; j++) {
						int diff = 0;
						for (int a = 0; a < bucket[i]; a++) {
							diff += ((j - nums[startIdx + a])*(j - nums[startIdx + a]));
							if(diff>=rst)
								break;
						}
						rst = Math.min(diff, rst);
					}
					
					startIdx += bucket[i];
					error += rst;
				}
				ans = Math.min(error, ans);
			}
			return;
		}
		
		int lastIndex = bucket.length - k-1;	// 가장 최근에 뽑힌 수가 저장된 위치
		
		for (int i = 0; i < items.length; i++) {
			bucket[lastIndex+1] = items[i];
			solution(items, bucket, k-1);
		}
	}
}
