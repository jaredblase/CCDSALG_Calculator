public class Stack {
	// Attributes
	private int cap;
	private int top = 0;
	private int[] myStack;


	// Constructors
	public Stack() {
		cap = 178;
		myStack = new int[178];
	}

	public Stack(int max) {
		cap = max;
		myStack = new int[max];
	}


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