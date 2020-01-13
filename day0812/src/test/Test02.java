package test;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		LinkedTree myTree = new LinkedTree();
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 1; i < N; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			myTree.add(p, c);
		}
		
		myTree.preorder();
	}
}

class LinkedTree {
	private Node root;	// 가장 처음 생성되는 노드 객체의 주소를 저장할 참조변수.
	
	public LinkedTree() {
		root = new Node(1);	// 일단 트리가 생성되면 1이라는 노드가 기본으로 들어가있게 만들자.
	}
	
	public void add(int parent, int child) {
		Node parentNode = search(root, parent);
		if(parentNode!=null) {	// 부모 번호를 가지는 노드 객체를 확실히 찾았고,
			if(parentNode.left==null) {	// 찾은 부모노드의 왼쪽자식이 없다면 왼쪽자식으로 추가
				parentNode.left = new Node(child);
			}
			else if(parentNode.right==null) {	// 찾은 부모노드의 오른쪽자식이 없다면 오른쪽자식으로 추가
				parentNode.right = new Node(child);
			}
		}
	}
	
	public Node search(Node now, int data) {
		if(now!=null && now.data==data) {
			return now;
		}
		
		Node rst1=null, rst2=null;
		if(now.left != null) {	// 현재 노드 객체에 왼쪽 자식이 있다면 찾으러 가보자.
			rst1 = search(now.left, data);
		}
		
		if(now.right != null) {	// 현재 노드 객체에 오른쪽 자식노드가 있다면 역시 여기도 찾으러 가보자.
			rst2 = search(now.right, data);
		}
		
		if(rst1==null && rst2==null) {	// 양쪽 자식과 그 자식들까지 다 찾아봤지만 못찾았음..
			return null;
		}
		return rst1==null ? rst2 : rst1;
	}
	
	
	public void preorder() {
		preorder(root);
	}
	
	private void preorder(Node now) {
		if(now!=null) {
			System.out.print(now.data + " ");
			preorder(now.left);
			preorder(now.right);
		}
	}
	
	private class Node {
		int data;
		Node left, right;
		
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
