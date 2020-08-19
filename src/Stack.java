public class Stack {
	// Attributes
	private final int CAP;
	private int top;
	private final int[] myStack;


	// Constructors
	public Stack() {
		this(178);
	}

	public Stack(int max) {
		CAP = max;
		myStack = new int[max];
		top = 0;
	}

	// Methods
	public void push(int num) {
		if(!isFull()) {
			myStack[top++] = num;
		} else {
			System.out.println("Stack is already full!");
		}
	}

	public int pop() {
		if(!isEmpty()) {
			return myStack[--top];
		}
		System.out.println("Stack is empty!");
		return 0;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public boolean isFull() {
		return top == CAP;
	}

}
