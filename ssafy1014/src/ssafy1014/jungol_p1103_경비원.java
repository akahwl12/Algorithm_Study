package ssafy1014;

import java.util.ArrayList;
import java.util.Scanner;

public class jungol_p1103_경비원 {
	static int N, M, E, ans;
	static Point now;
	static ArrayList<Point> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt(); // width
		N = sc.nextInt(); // height
		E = sc.nextInt(); // count
		
		for (int i = 0; i < E; i++) {
			list.add(makePoint(sc.nextInt(), sc.nextInt()));
		}

		now = makePoint(sc.nextInt(), sc.nextInt());
		
		for (int i = 0; i < list.size(); i++) {
			ans += calDist(now, list.get(i));
		}
		
		System.out.println(ans);
	}
	
	static Point makePoint(int i, int l) {
		Point np = null;
		if(i==1)
			np = new Point(0, l);
		else if(i==2)
			np = new Point(N, l);
		else if(i==3)
			np = new Point(l, 0);
		else if(i==4)
			np = new Point(l, M);
		
		return np;
	}
	
	static int calDist(Point p1, Point p2) {
		int rst = 0;
		
		if(p1.x==p2.x && (p1.x==0 || p1.x==M))
			rst = Math.abs(p1.y - p2.y);
		else if(p1.y==p2.y && (p1.y==0 || p1.y==N))
			rst = Math.abs(p1.x - p2.x);
		else if(Math.abs(p1.x-p2.x)==N) {
			int diff = Math.min(2*M - (p1.y + p2.y), p1.y + p2.y);
			rst = diff + N;
		}
		else if(Math.abs(p1.y-p2.y)==M) {
			int diff = Math.min(2*N - (p1.x + p2.x), p1.x + p2.x);
			rst = diff + M;
		}
		else
			rst = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
		
		return rst;
	}
	
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
