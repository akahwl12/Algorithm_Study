package day0722;

public class Test02 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int sum, cnt;
		
		for (int i = 0; i < (1<<arr.length); i++) {
			sum = 0;
			cnt=0;
			System.out.print("{ ");
			for (int j = 0; j < arr.length; j++) {
				if(((1<<j) & i)!= 0) {
					sum += arr[j];
					System.out.print(arr[j] + " ");
					cnt++;
				}
			}
			System.out.println("} = " + sum);
			if(cnt==3)	System.out.println("  sum : " +  sum);
		}
	}
}
