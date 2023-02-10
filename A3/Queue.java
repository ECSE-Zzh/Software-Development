/**
 * Queue class: Creates a queue to store numbers and operators. This is used by
 * PostFix.
 * 
 *
 */
public class Queue {

	public ListNode front;
	public ListNode rear;

	/**
	 * Enqueue method: Enqueues string on the queue.
	 * 
	 * @param arg: tokens.
	 */

	public void enqueue(String arg) {

		ListNode node = new ListNode();// Create new node at rear.
		node.data = arg;// Insert data.
		if (rear == null) {
			// If queue is empty, make front points to new node.
			front = node;
		} else {
			// If queue is not empty, attach new node to end of chain.
			rear.next = node;
		}
		rear = node;// Rear points to new node.
	}

	/**
	 * Dequeue method: This method helps dequeue string from the queue.
	 * 
	 * @return result: The postfix form.
	 */
	public String dequeue() {

		String result = null;
		if (front != null) {
			// If queue is not empty, unload data from front.
			result = front.data;
			if (front == rear) {
				// If this is the last node, set front and rear to null.
				front = null;
				rear = null;
			} else {
				// If this is not the last node, move front to next node in line.
				front = front.next;
			}
		}
		return result;
	}

	/**
	 * toString method: This method helps concatenate all tokens in the queue.
	 */

	public String toString() {

		String result = "";
		ListNode currentNode = this.front;// Get the first data.
		if (currentNode != null) {
			while (true) {
				// Concatenate tokens in the queue separated by one space.
				result += currentNode.data + " ";
				if (currentNode.next != null) {
					// If there are more tokens, get next token.
					currentNode = currentNode.next;
				} else {
					break;
				}
			}
		}
		return result;
	}
}
