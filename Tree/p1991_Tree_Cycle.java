package Tree;

import java.util.*;

public class p1991_Tree_Cycle {

	class Node {
		char data;
		Node left, right;
		public Node(char data) {this.data = data;}
	}
	
	class Tree {
		Node root;
		
		//add �޼ҵ�. ���� ���� '.'�� �ƴ� ��쿡�� �����Ѵ�.
		public void add(char d, char l, char r) {
			if(root==null) { //root��尡 ����ִٸ� == ���� �ƹ� ���� ���� ���� ���� ����
				if(d != '.')	root = new Node(d); //d�� '.'��  �ƴ϶�� root��� ���� �� ������ ����
				if(l != '.')	root.left = new Node(l); //l�� '.'��  �ƴ϶�� root�� ���� ��� ���� �� ������ ����
				if(r != '.')	root.right = new Node(r); //r�� '.'��  �ƴ϶�� root�� ���� ��� ���� �� ������ ����
			}
		}
	}
	
	public static void main(String[] args) {
		
		
	}

}
