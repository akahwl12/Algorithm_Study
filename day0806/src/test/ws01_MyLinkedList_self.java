package test;

public class ws01_MyLinkedList_self<T> {
	private Node head;
	private int size;
	
	public void add(T data) {
		Node newNode = new Node(data, null);
		if(isEmpty()) {
			head = newNode;
		}
		else {
			Node tmp = head;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
		size++;
	}
	
	public void add(int idx, T data) {
		if(size<idx) {
			throw new RuntimeException("인덱스가 너무 커요!!");
		}
		else if(idx==0) {
			Node newNode = new Node(data, head);
			head = newNode;
		}
		else {
			Node tmp = head;
			for (int i = 0; i < idx-1; i++) {
				tmp = tmp.next;
			}
			Node newNode = new Node(data, tmp.next);
			tmp.next = newNode;
		}
		size++;
	}
	
	public T get(int idx) {
		if(size<idx) {
			throw new RuntimeException("인덱스가 너무 커요!!");
		}
		else {
			Node tmp = head;
			for (int i = 0; i < idx; i++) {
				tmp = tmp.next;
			}
			return	tmp.data;
		}
	}
	
	public void remove(int idx) {
		if(size<idx) {
			throw new RuntimeException("인덱스가 너무 커요!!");
		}
		else if(idx==0) {
			head = head.next;
		}
		else {
			Node tmp = head;
			for (int i = 0; i < idx-1; i++) {
				tmp = tmp.next;
			}
			tmp.next = tmp.next.next;
		}
		size--;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		String str = "[";
		Node tmp = head;
		for (int i = 0; i < size; i++) {
			str += tmp.data + " ";
			tmp = tmp.next;
		}
		return str + "]";
	}

	private class Node {
		T data;
		Node next;
		
		Node(T d, Node n) {
			this.data = d;
			this.next = n;
		}
	}
}
