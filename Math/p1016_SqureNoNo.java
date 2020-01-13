package Math;

import java.util.*;

public class p1016_SqureNoNo {

	public static void main(String[] args) {
		int minn, maxx, numm=2, cnt=0;
		ArrayList<Integer> section = new ArrayList();
		
		Scanner sc = new Scanner(System.in);
		
		minn = sc.nextInt();
		maxx = sc.nextInt();
		
		int rM = (int)Math.ceil(Math.sqrt(minn));
		if(rM==1) rM = 2;
		int rN = (int)Math.sqrt(maxx);
		
		for(int i=minn; i<=maxx; i++) {
			section.add(i);
		}
		
		for(int i=rM; i<=rN; i++) {
			if(i*i<=maxx)	cnt++;
		}
		System.out.println(section.size());
	}
}
