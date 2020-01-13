package practice;

import java.util.Arrays;
import java.util.Scanner;

public class p1983 {
	static int TC, N, K, ans;
	static double score, sum;
	static String[] grades = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	static double[] student;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			student = new double[N+1];
			
			for (int i = 1; i <= N; i++) {
				sum = 0;
				sum += sc.nextInt()*0.35;
				sum += sc.nextInt()*0.45;
				sum += sc.nextInt()*0.2;
				student[i] = sum;
				if(i==K) {
					score = sum;
				}
			}
			
			Arrays.sort(student);
			
			for (int i = 0; i < student.length; i++) {
				if(student[i]==score) {
					ans = (student.length-i-1)/(N/10);
					break;
				}
			}
			System.out.println("#" + tc + " " + grades[ans]);
		}
	}
}
