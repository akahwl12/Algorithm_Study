package test;

public class MyLinkedList<T> {
	private Node head;	// 리스트의 제일 앞에 위치하는 0번 노드객체의 주소를 저장할 변수
	private int size;
	
	
	public void add(T d) {	// 데이터만 넣으면서 추가
		if(isEmpty()) {
			head = new Node(d, null);
		}
		else {	// 기존 Node 객체들이 있고, 그 마지막 Node객체를 찾아서 그 뒤에 새로운 노드를 추가해야한다.
			Node tmp = head;	// 일단 0번 노드객체 주소를 받은 다음에
			while(tmp.next != null) {	// 마지막 Node는 next객체에 null을 담고있다.
				tmp = tmp.next;
			}
			tmp.next = new Node(d, null);
		}
		size++;
	}
	
	public void add(int idx, T d) {	// 데이터와 해당 인덱스까지 같이 지정해서 추가
		if(idx>size) {
			throw new RuntimeException("인덱스 너무 커!;;");
		}
		else if(idx == 0) {
			Node newNode = new Node(d, head);
			head = newNode;
		}
		else {	// 유효한 인덱스로 추가한다면
			Node tmp = head;
			for (int i = 0; i < idx-1; i++) {	// 일단 삽입할 인덱스 바로 앞 노드까지 찾아가기
				tmp = tmp.next;
			}
			Node newNode = new Node(d, tmp.next);
			tmp.next = newNode;
		}
		size++;
	}
	
	public T get(int idx) {
		if(idx>=size) {
			throw new RuntimeException("인덱스 너무 커!;;");
		}
		else {	// 유효 인덱스인 경우
			Node tmp = head;
			for (int i = 0; i < idx; i++) {	// 일단 삽입할 인덱스 바로 앞 노드까지 찾아가기
				tmp = tmp.next;
			}
			return tmp.data;
		}
	}
	
	public void remove(int idx) {
		if(idx>=size) {
			throw new RuntimeException("인덱스 너무 커!;;");
		}
		else if(idx==0) {
			head = head.next;
		}
		else {	// 유효 인덱스인 경우
			Node prev = head;
			for (int i = 0; i < idx-1; i++) {	// 일단 삽입할 인덱스 바로 앞 노드까지 찾아가기
				prev = prev.next;
			}
			prev.next = prev.next.next;
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
		for (int i = 0; i < size; i++) {
			str += get(i) + " ";
		}
		return str + "]";
	}



	private class Node {
		T data;
		Node next;
		
		Node(T d, Node n) {
			data = d;
			next = n;
		}
	}
}
