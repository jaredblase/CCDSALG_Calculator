import java.util.LinkedList;

public class Stack {

	// Attributes
	private int top = 0; 
	private LinkedList<Integer> stack = new LinkedList<Integer>();


	// Methods

	// Add Value to Stack
	public void push(int num) {
		stack.add(num);
		top++;
	}

	// Return Top Value of Stack
	public int pop() {
		return stack.get(--top);
	}

	// Check Stack If it is Empty
	public boolean isEmpty() {
		return top == 0;
	}

}
