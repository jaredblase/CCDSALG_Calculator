public class Queue {

	// Attribute
	private int cap;
	private int head = 0;
	private int tail = 0;
	private int[] myQueue;

	
	// Constructors
	public Queue() {
		cap = 178;
		myQueue = new int[cap];
	}

	public Queue(int max) {
		cap = max;
		myQueue = new int[max];
	}


	// Methods
	public void enqueue(int num) {
		return myQueue[head++ % cap];
	}

	public int dequeue() {
		return myQueue[head++ % cap];
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public boolean isFull() {
		return (tail + 1) % cap == head;
	}

}
