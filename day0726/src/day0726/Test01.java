package day0726;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		String s = "apple";
//		System.out.println(s.length());
//		System.out.println(s.toUpperCase());
//		System.out.println(s.charAt(2));
//		System.out.println(s.contains("ppl"));
		
		String s1 = "apple"; // �ڹٿ����� String�޸� ����(���ڿ� ����޸�)�� �����ִ�.
		String s2 = "apple"; // �� �� ���ڿ��� �쿬�� �� ������ �� ��ü�� �ּҰ� ���������̶� �񱳿���� true�� ���� ���̴�.
		
		System.out.println(s1==s2);
		
		String s3 = new String("apple");
		String s4 = new String("apple");
		
		System.out.println(s3==s1);
		StringBuffer sb = new StringBuffer("abcde");
		sb.reverse();
		System.out.println(sb);

		StringBuilder sbb = new StringBuilder();
		String sss ="";
		for (int i = 0; i < 10; i++) {
//			sss += i;	//String ��� �޸𸮿� ����ؼ� ���δ�. 0, 01, 012, 0123, 01234... �޸𸮻�뷮�� Ŀ����
			sbb.append(i);
		}
		System.out.println(sbb);
	}
}
