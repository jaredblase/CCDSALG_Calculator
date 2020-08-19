public class Stack {
	// Attributes
	private final int CAP;
	private int top;
	private final String[] myStack;


	// Constructors
	public Stack() {
		this(178);
	}

	public Stack(int max) {
		CAP = max;
		myStack = new String[max];
		top = 0;
	}

	// Methods
	public void push(String op) {
		if(!isFull()) {
			myStack[top++] = op;
		} else {
			System.out.println("Stack is already full!");
		}
	}

	public String pop() {
		if(!isEmpty()) {
			return myStack[--top];
		}
		System.out.println("Stack is empty!");
		return null;
	}

	public String topElem() {
		return myStack[top - 1];
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public boolean isFull() {
		return top == CAP;
	}

}