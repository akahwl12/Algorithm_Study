package day0729;

public class MyStack {
	private int[] data;
	private int top;
	
	public MyStack() {
		data = new int[100];
		top = 0;
	}
	
	public boolean push(int d) {
		if(top<data.length-1) { // stack에 남은 칸이 있으면
			data[top] = d; //top이 가리키는 곳에 데이터를 넣고
			top++; //top변수 값 1 증가
			return true; //push연산이 정상적으로 이루어졌음.
		}
		return false;	//push연산 정상작동 X
	}
	public int pop() {
		top--;
		return data[top];
	}
	public boolean isEmpty() {
		return top==0;
	}
	public int size() {
		return top;
	}
	boolean isFull() {
		return top == data.length;
	}
}
