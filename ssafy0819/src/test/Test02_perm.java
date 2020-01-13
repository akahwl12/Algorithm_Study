package test;

import java.util.ArrayList;
import java.util.List;

public class Test02_perm {
	static String[] arr = {"1","2","3","4","5"};
	static boolean[] used = new boolean[arr.length];
	static List<String> result;
	
	public static void main(String[] args) {
		result = new ArrayList<String>();
		perm(0);
	}
	
	static void perm(int d) {
		if(d==arr.length) {
			System.out.println(result);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!used[i]) {
				used[i] = true;
				result.add(arr[i]);
				perm(d+1);
				used[i] = false;
				result.remove(arr[i]);
			}
		}
	}
}
