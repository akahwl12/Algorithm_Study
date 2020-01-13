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
		
		String s1 = "apple"; // 자바에서는 String메모리 영역(문자열 상수메모리)이 따로있다.
		String s2 = "apple"; // 이 두 문자열이 우연히 두 변수가 들어간 객체의 주소가 같았을뿐이라 비교연산시 true가 나온 것이다.
		
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
//			sss += i;	//String 상수 메모리에 계속해서 쌓인다. 0, 01, 012, 0123, 01234... 메모리사용량이 커진다
			sbb.append(i);
		}
		System.out.println(sbb);
	}
}
