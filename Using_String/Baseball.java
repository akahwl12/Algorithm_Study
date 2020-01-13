package Using_String;

import java.util.*;

public class Baseball {
	public static void main(String[] args) {
	
		String s = "100130";
		int rst = 0;
		int[] arr = new int[s.length()];
		boolean odd = false, even = false;
		
		int[] num = new int[10];
		
		for(int i=0; i<s.length(); i++) {
			arr[i] = Integer.parseInt(s.split("")[i]);
			num[arr[i]]++;
		}
		
		for(int i=1; i<10; i++) {
			if(num[i]!=0) {
				if(num[i]%2 != 0) {
					odd = true;
					rst+= num[i] - num[i]%2;
				}
				else {
					even = true;
					rst+=num[i];
				}
				if(num[i] >= 2) {
					even = true;
				}
			}
		}
		
		if(num[0]%2==0 && even) {
			rst+=num[0];
		}
		else if(num[0]%2!=0 && even){
			rst+=num[0];
		}
		
		if(odd) {
			rst++;
		}
		
		System.out.println(rst);
	}
}