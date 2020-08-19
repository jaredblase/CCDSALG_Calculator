public class Queue {
	// Attribute
	private final int CAP;
	private int head;
	private int tail;
	private final String[] myQueue;

	
	// Constructors
	public Queue() {
		this(178);
	}

	public Queue(int max) {
		CAP = max;
		myQueue = new String[max];
		head = tail = 0;
	}

	// Methods
	public void enqueue(String token) {
		if(!isFull()) {
			myQueue[tail++ % CAP] = token;
		} else {
			System.out.println("Queue is full!");
		}
	}

	public String dequeue() {
		if(!isEmpty()) {
			return myQueue[head++ % CAP];
		}
		System.out.println("Queue is empty!");
		return null;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public boolean isFull() {
		return (tail + 1) % CAP == head;
	}
}
