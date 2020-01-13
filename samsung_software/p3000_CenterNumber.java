package samsung_software;

import java.util.*;

public class p3000_CenterNumber {
	
	public static void main(String[] args) {
		int T, N, sum=0;
		ArrayList<Integer> arr = new ArrayList();
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		N = sc.nextInt();
		arr.add(sc.nextInt());
		
		for(int i=0; i<T; i++) {
			for(int j=0; j<N; j++) {
				arr.add(sc.nextInt());
				arr.add(sc.nextInt());
				Collections.sort(arr);
				sum+=arr.get(arr.size()/2);
			}
			System.out.println("#" + (i+1) + " " + (sum%20171109));
		}
	}
}