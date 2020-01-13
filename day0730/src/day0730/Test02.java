package day0730;

public class Test02 {
	public static void main(String[] args) {
		System.out.println(pow(2,30));
		System.out.println("pow가 호출된 횟수 : " + cnt);
		for (int i = 1; i <= 300; i++) {
			System.out.println(i);
		}
	}
	static int cnt=0;
//	static long pow(long a, long b) {
//		cnt++;
//		if(b==1)
//			return a;
//		
//		return a * pow(a, b-1);
//	}
	static long pow(long a, long b) {
		cnt++;
		if(b==1)
			return a;
		if(b%2==0) {
			long tmp = pow(a, b/2);
			return tmp*tmp;
		}
		else {
			long tmp = pow(a, b/2);
			return tmp*tmp*a;
		}
	}
}