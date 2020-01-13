package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1244 {
	static int[] arr;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			String[] input = br.readLine().split(" ");	// 숫자 2개 공백으로 입력들어옴
			
			arr = new int[input[0].length()];	// 앞[0]에 들어온 숫자가 숫자판임
			for (int i = 0; i < arr.length; i++) {	// int 배열에 옮겨닮기
				arr[i] = input[0].charAt(i)-'0';
			}
			
			int cnt = Integer.parseInt(input[1]);	//뒤[1]에 들어온게 교환 횟수임.
			max = 0;
			for (int i = 0; i < arr.length; i++) {
				make(i, 0, cnt);
			}
			
			System.out.println("#" + tc + " " + max);
		
		}
	}
	
	static void make(int idx, int d, int cnt) {
		if(d==cnt) {
			int sum = 0;
			
			for (int i = 0; i < arr.length; i++) {
				sum+=(arr[i]*Math.pow(10, arr.length-i-1));
			}
			if(sum>max)
				max = sum;
			
			return;
		}
		for (int j = idx+1; j < arr.length; j++) {
			swap(idx, j);
			make(0, d+1, cnt);
			swap(idx, j);
		}
	}
	
	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
