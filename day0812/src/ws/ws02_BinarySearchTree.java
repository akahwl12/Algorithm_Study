package ws;

import java.util.Scanner;

// 1. 데이터 추가기능
// 2. 데이터 찾기 기능 : true or false 리턴하면됨.
// 3. 데이터 오름차순 정렬해서 출력하는 기능. (inorder)
public class ws02_BinarySearchTree {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(5);
		
		tree.add(2);
		tree.add(13);
		tree.add(8);
		tree.add(1);
		tree.add(5);
		tree.add(18);
		tree.add(4);
		
		tree.inorder();
		System.out.println();
		System.out.println(tree.search(13));
		System.out.println(tree.search(20));
	}
}

class BinaryTree {
	private Node root;
	
	public BinaryTree(int data) {
		root = new Node(data);
	}
	
	public void add(int num) {
		if(root == null) {
			root = new Node(num);
		}
		else {
			add(root, num);
		}
	}
	
	private void add(Node node, int num) {
		if(node.data < num) {
			if(node.right==null) {	// 오른쪽이네
				node.right = new Node(num);
			}
			else {	// 오른쪽에 이미 값이 있어! null이 아니야!
				add(node.right, num);
			}
		}
		else {	// 왼쪽이네
			if(node.left==null) {
				node.left = new Node(num);
			}
			else {	// 왼쪽에 이미 값이 있어! null이 아니야!
				add(node.left, num);
			}
		}
	}

	public boolean search(int num) {
		return search(root, num);
	}
	
	private boolean search(Node now, int num) {
		if(now.data==num) {	// 확실히 찾은 경우
			return true;
		}
		
		// 확실히 못찾은 경우
		if((now.data < num && now.right==null) || now.data > num && now.left==null) {
			return false;
		}
		
		// 더 진행해봐야 되는 경우
		if(now.data < num) {
			return search(now.right, num);
		}
		else {
			return search(now.left, num);
		}
	}
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(Node now) {
		if(now!=null) {
			inorder(now.left);
			System.out.print(now.data + " ");
			inorder(now.right);
		}
	}
	
	class Node {
		int data;
		Node right, left;
		
		Node(int data) {
			this.data = data;
			right = left = null;
		}
	}
}
