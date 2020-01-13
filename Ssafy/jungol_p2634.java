package Ssafy;
// 사냥꾼
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class jungol_p2634 {
	static int M, N, L, ans;
	static LinkedList<Animal> animals = new LinkedList<>();
	static int[] gun;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		L = sc.nextInt();
		
		gun = new int[M];
		for (int i = 0; i < M; i++) {
			gun[i] = sc.nextInt();
		}
		Arrays.sort(gun);
		
		for (int i = 0; i < N; i++) { // 총 동물 수 - 리스트 수
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(y>L)	continue;
			animals.add(new Animal(x, y));
		}
		
		animals.sort(new Comparator<Animal>() {
			@Override
			public int compare(Animal o1, Animal o2) {
				return o1.x - o2.x;
			}
		});
		
		for (int i = 0; i < animals.size(); i++) {
			for (int j = 0; j < M; j++) {
				if(Math.abs(gun[j]-animals) + y <=L) {
					ans++;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static class Animal {
		int x, y;
		
		Animal(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
