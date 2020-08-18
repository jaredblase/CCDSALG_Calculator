public class Stack {
	// Attributes
	private int cap = 178;
	private int top = 0;
	private int[] myStack = new int[cap];


	// Methods
	public void push(int num) {
		myStack[top++] = num;
	}

	public int pop() {
		return myStack[--top];
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public boolean isFull() {
		return top == cap;
	}

}
