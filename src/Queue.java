import java.util.LinkedList;

public class Queue {

	// Attribute
	private int cap = 0;
	private LinkedList<Integer> queue = new LinkedList<Integer>();

	// Methods
	public void enqueue(int num) {
		queue.add(num);
		cap++;
	}

	public int dequeue() {
		int temp = queue.get(0);
		queue.remove(0);
		cap--;
		return temp;
	}

	public boolean isEmpty() {
		return cap == 0;
	}

}
