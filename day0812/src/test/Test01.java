package test;

import java.util.Scanner;

public class Test01 {
	static int N;
	static int[] tree = new int[32];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 13
		
		for (int i = 1; i <= N; i++) {	// 왼쪽 자식은 부모 *2
			tree[i] = 'A'+ (i-1);
			
		}
		System.out.println("[preorder] ");
		preorder(1);
		System.out.println("\n");
		
		System.out.println("[inorder] ");
		inorder(1);
		System.out.println("\n");
		
		System.out.println("[postorder] ");
		postorder(1);
	}
	
	public static void preorder(int now) {
		if(now > N)	return;
		System.out.print((char)tree[now] + " ");
		preorder(now*2);
		preorder((now*2)+1);
	}
	
	public static void inorder(int now) {
		if(now > N)	return;
		inorder(now*2);
		System.out.print((char)tree[now] + " ");
		inorder((now*2)+1);
	}
	
	public static void postorder(int now) {
		if(now > N)	return;
		postorder(now*2);
		postorder((now*2)+1);
		System.out.print((char)tree[now] + " ");
	}
}
