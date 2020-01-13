package ws;

import java.util.Scanner;

public class baekjoon_p14888 {
	static int N, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
	static int[] nums;
	static int[] operations = new int[4];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			operations[i] = sc.nextInt();
		}
		for (int i = 0; i < operations.length; i++) {
			if(operations[i]!=0)
				dfs(1, i, nums[0]);
		}
		System.out.println(max + "\n" + min);
	}
	static void dfs(int idx, int op, int sum) {
		if(operations[op]<=0)
			return;
		
		if(op==0)
			sum += nums[idx];
		else if(op==1)
			sum -= nums[idx];
		else if(op==2)
			sum*=nums[idx];
		else if(op==3)
			sum/=nums[idx];

		if(idx==nums.length-1) {
			if(sum>max)	max = sum;
			if(sum<min)	min = sum;
			return;
		}
		
		operations[op]--;
		for (int i = 0; i < operations.length; i++) {
			if(operations[i]!=0)
				dfs(idx+1, i, sum);
		}
		operations[op]++;
	}
}
