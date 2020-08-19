public class Queue {
	// Attribute
	private final int CAP;
	private int head;
	private int tail;
	private int[] myQueue;

	
	// Constructors
	public Queue() {
		this(178);
	}

	public Queue(int max) {
		CAP = max;
		myQueue = new int[max];
		head = tail = 0;
	}

	// Methods
	public void enqueue(int num) {
		if(!isFull()) {
			myQueue[tail++ % CAP] = num;
		} else {
			System.out.println("Queue is full!");
		}
	}

	public int dequeue() {
		if(!isEmpty()) {
			return myQueue[head++ % CAP];
		}
		System.out.println("Queue is empty!");
		return 0;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public boolean isFull() {
		return (tail + 1) % CAP == head;
	}

}
