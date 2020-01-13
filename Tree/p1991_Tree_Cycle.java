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
		
		//add 메소드. 들어온 값이 '.'이 아닌 경우에만 삽입한다.
		public void add(char d, char l, char r) {
			if(root==null) { //root노드가 비어있다면 == 아직 아무 값도 들어가지 않은 최초 상태
				if(d != '.')	root = new Node(d); //d가 '.'이  아니라면 root노드 생성 후 데이터 삽입
				if(l != '.')	root.left = new Node(l); //l이 '.'이  아니라면 root의 좌측 노드 생성 후 데이터 삽입
				if(r != '.')	root.right = new Node(r); //r이 '.'이  아니라면 root의 우측 노드 생성 후 데이터 삽입
			}
		}
	}
	
	public static void main(String[] args) {
		
		
	}

}
