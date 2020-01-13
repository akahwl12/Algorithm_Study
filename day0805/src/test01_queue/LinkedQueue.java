package test01_queue;

public class LinkedQueue {
	private Node front, rear;
	private int size;
	
	public void enQueue(int d) {
		Node newNode = new Node(d, null); // 새로 들어오는 데이터를 비어있는 큐에 추가하기

		if(isEmpty()) { // 큐가 빈 경우에는 front, rear가 새로운 노드 주소를 저장
			front = rear = newNode;
		}
		else { // 비어있지 않을 때에는 rear가 담당하던 막내한테 신삥의 주소를 저장시키고
			rear.next = newNode;
			rear = newNode; // rear도 신삥을 쳐다봄
		}
		size++;
	}
	
	public int deQueue() {
		if(isEmpty()) { // 큐가 비었으면 에러
			return -1;
		}
		else { // 비어있지 않으면? front가 담당하는 애가 나갈 차례
			size--;
			int d = front.data; // 내보낼 데이터 임시 저장하고,
			front = front.next; // 나가는 애가 저장하는 자기 후임 주소를 front가 다시 쳐다보게 함
			return d;
		}
	}
	
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		return size;
	}
	
	private class Node {
		int data;
		Node next;
	
		Node(int data, Node n) {
			this.data = data;
			this.next = n;
		}
	}
}
