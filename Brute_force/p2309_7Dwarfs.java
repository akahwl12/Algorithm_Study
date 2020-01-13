package Brute_force;

import java.util.*;

public class p2309_7Dwarfs {

	public static void main(String[] args) {
		int[] dwarf = new int[9];
		ArrayList<Integer> res = new ArrayList();
		int summ = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<9; i++) {
			dwarf[i] = sc.nextInt();
		}
		
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				for(int k=0; k<9; k++) {
					if(k!=i && k!=j) {
						summ += dwarf[k];
						res.add(dwarf[k]);
					}
				}
				if(summ==100)	break;
				else summ=0;	res.clear();
			}
			if(summ==100)	break;
			else summ=0;	res.clear();
		}
		
		Collections.sort(res);
		
		for(int i=0; i<res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
