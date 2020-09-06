import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public class Queue implements Iterable<String> {
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

	public String head() {
		if(!isEmpty()) {
			return myQueue[head % CAP];
		} else {
			System.out.println("Queue is empty!");
			return null;
		}
	}

	public String tail() {
		if(!isEmpty()) {
			return myQueue[(tail - 1) % CAP];
		} else {
			System.out.println("Queue is empty!");
			return null;
		}
	}

	@Override
	public Iterator<String> iterator() {
		Predicate<String> filter = Objects::nonNull;
		return Arrays.stream(myQueue).filter(filter).iterator();
	}
}
