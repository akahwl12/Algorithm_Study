package ws;

import java.util.ArrayList;

public class ws04_stack1 {
	private ArrayList<Integer> list = new ArrayList<>();
	
	public void push(int d) {
		list.add(d);
	}
	
	public int pop() {
		return list.remove(list.size()-1);
	}
	
	public int peek() {
		return list.get(list.size()-1);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.size()==0;
	}
	
}
