package Using_String;

import java.util.*;

public class p1786_String_Matching {

	public static void main(String[] args) {
		int idx;
		String str1, str2;
		String[] arr = new String[1000001];
		
		Scanner sc = new Scanner(System.in);
		
		str1 = sc.nextLine();
		str2 = sc.nextLine();
		
		idx = str1.indexOf(str2)+1;

		arr = str1.split(str2);
		
		System.out.println(arr.length-1);
		System.out.println(idx);
	}

}
