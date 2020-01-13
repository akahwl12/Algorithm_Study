package Ssafy;

import java.util.Scanner;
import java.util.Arrays;

public class Student20170972_2 {
	static int error, rep, len, k, ans = Integer.MAX_VALUE;
	static int[] nums;
	static int[] result;
	static boolean[] used;

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
		result = new int[k-1];
		used = new boolean[k-1];

		for (int i = 0; i < len; i++) { // 입력할 수들 입력
			nums[i] = sc.nextInt(); // 임의의 수들
		}

		Arrays.sort(nums); // 배열 정렬됨
//		solution(items, bucket, k);
		comb(0, 0);

//		System.out.println(ans);

	}

	private static void comb(int now, int select) {
		if(now == len)
			return;
		if(select == k-1) {
			System.out.println(Arrays.toString(result));
			
			int center = 0;
			int div = 0;
			int diff = 0;
			
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[i]; j++) {
					
				}
			}
			
			
			return;
		}
		
		result[select] = now;
		comb(now+1, select+1);
		comb(now+1, select);
	}

	private static void solution(int[] items, int[] bucket, int k) {
		if (k == 0) {
			int cnt = 0;
			for (int i = 0; i < bucket.length; i++) {
				cnt += bucket[i];
			}
			if (cnt == len) {
				error = 0;
				int startIdx = 0;
				for (int i = 0; i < bucket.length; i++) {
					System.out.print(bucket[i] + " ");
				}
				System.out.println();
				for (int i = 0; i < bucket.length; i++) {
					rep = Integer.MAX_VALUE;
					double center = 0;
					int diff = 0;

					for (int j = 0; j < bucket[i]; j++) {
						center += nums[startIdx + j];
					}
					center /= bucket[i];
					center = Math.round(center);

					for (int j = 0; j < bucket[i]; j++) {
						diff += ((center - nums[startIdx + j]) * (center - nums[startIdx + j]));
					}
					rep = Math.min(diff, rep);

					startIdx += bucket[i];
					error += rep;
					if (error >= ans)
						return;
				}
				ans = Math.min(error, ans);
			}
			return;
		}

		int lastIndex = bucket.length - k - 1; // 가장 최근에 뽑힌 수가 저장된 위치

		for (int i = 0; i < items.length; i++) {
			if (bucket.length == k) { // 아직 한 번도 뽑은 적이 없는 경우
				bucket[0] = items[i];
				solution(items, bucket, k - 1);
			} else if (bucket[lastIndex] < items[i]) {
				bucket[lastIndex + 1] = items[i];
				solution(items, bucket, k - 1);
			}
		}
	}
}