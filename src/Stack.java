import java.util.LinkedList;

public class Stack {
	// Attributes
	private int cap = 0;
	private int top = 0; 
	private LinkedList<Integer> stack = new LinkedList<Integer>();


	// Methods
	public void push(int num) {
		if(cap == top) {
			stack.add(num);
			cap++;
		} else {
			stack.set(top, num);
		}
		top++;
	}

	public int pop() {
		top--;
		return stack.get(top);
	}

	public boolean isEmpty() {
		return top == 0;
	}

}
