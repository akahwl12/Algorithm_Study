package Simulation;

import java.util.*;

public class p1547_Cup_Ball {

	public static void main(String[] args) {
		int M, X, Y, idX, idY;
		ArrayList<Integer> cups = new ArrayList();
		
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		
		cups.add(1);
		cups.add(2);
		cups.add(3);
		
		for(int i=0; i<M; i++) {
			X = sc.nextInt();
			Y = sc.nextInt();
			
			idX = cups.indexOf(X);
			idY = cups.indexOf(Y);
			
			cups.remove(idX);
			cups.add(idX, Y);
			
			cups.remove(idY);
			cups.add(idY, X);
			
		}
		
		System.out.print(cups.get(0));
	}
}
