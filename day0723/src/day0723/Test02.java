package day0723;

public class Test02 {
	
	static int sum;
	
	public static void main(String[] args) {
		myFunc(1);
		
		System.out.println(sum);
	}
	
	static void myFunc(int i) {
		System.out.println(i + " : myFunc() called");
		sum += i;
		if(i==10) {
			System.out.println(i + " : myFunc() returned");
			return;
		}
		else {
			myFunc(i+1);
		}
		System.out.println(i + " : myFunc() closed");
	}
}
