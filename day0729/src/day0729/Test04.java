package day0729;

public class Test04 {
	static int idx, num;
	public static void main(String[] args) {
//		1. 1부터 9까지 출력하기
		pr(1);
//		2. 1부터 10까지의 합을 출력하는 재귀함수를 만드시오.
		doSum(0, 10);
//		3. 팩토리얼 4! ==> 4 * 3 * 2 * 1
		int result = fact(4);
		System.out.println("factorial : " + result);
//		4. 자연수를 넣어 그 각자리의 수의 합을 반환하는 재귀함수를 만들어라
		int sum = digitSum(123456, 0);
		System.out.println("sum : " + sum);
//		5. 문자열을 전달받아 그 문자 사이에 ','를 결합하여 반환하는 재귀함수를 만들어라
		String s = doStringComma("Korea", "");
		System.out.println(s);
//		6. 피보나치 수열 10개를 출력하라
		for (int i = 1; i <= 10; i++) {
			System.out.println(fibo(i));
		}
//		7. 2진수 3자리를 구성할 수 있는 재귀함수를 만들어라
		doMakeBinary(3, "");	
	}

	public static void pr(int i) {
		if(i>9)	return;
		System.out.println(i);
		pr(i+1);
	}
	
	public static void doSum(int sum, int num) {
		if(num==0) {
			System.out.println("합계 : " + sum);
			return;
		}
		sum+=num;
		doSum(sum, num-1);
	}
	
	public static int fact(int i) {
		if(i==1)	return 1;
		return i * fact(i-1);
	}
	
	public static int digitSum(int i, int j) {
		if(i==0)	return 0;
		return i%10 + digitSum(i/10, j);
	}
	
	public static String doStringComma(String str1, String result) {
//		if(idx==str1.length()-1)	return str1.charAt(idx++)+"";
//		result = str1.charAt(idx++)+",";
//		return result+doStringComma(str1, result);
		if(str1.length()==0)
			return result.substring(0, result.length()-1);
		String temp = str1.substring(1);
		result += str1.charAt(0)+",";
		return doStringComma(temp,result);
	}
	
	public static int fibo(int i) {
		if(i==0) return 0;
		if(i==1) return 1;
		return fibo(i-1) + fibo(i-2);
	}
	
	private static void doMakeBinary(int depth, String string) {
		if(depth==0) {
			System.out.println(string);
			return;
		}
		doMakeBinary(depth-1, string+"0");
		doMakeBinary(depth-1, string+"1");
	}
}
