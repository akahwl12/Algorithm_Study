package Using_String;

import java.util.*;

public class UserInterface {

	public static void main(String[] args) {
		int N, tmp, sum=0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int [] arr = new int[2*N];
		
		for(int i=0; i<2*N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<2*N; i++) {
			for(int j=i+1; j<2*N; j++) {
				if(arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		for(int i=0; i<2*N; i+=2) {
			sum += Math.min(arr[i], arr[i+1]);
		}
		
		System.out.println(sum);
	}
}
