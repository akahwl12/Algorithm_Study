package Using_String;

import java.util.*;

public class p2902_KMP {

	public static void main(String[] args) {
		String str;
		String[] ch = new String[101];
		
		Scanner sc = new Scanner(System.in);
		
		str = sc.next();
		
		ch = str.split("-");
		
		for(int i=0; i<ch.length; i++) {
			System.out.print(ch[i].charAt(0));
		}
	}
}
