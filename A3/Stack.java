/**
 * Stack class: Creates a stack to store operators. This class is used by
 * PostFix.
 * 
 *
 */
public class Stack {

	ListNode top = null;

	/**
	 * Push method: This method helps push operators onto stack.
	 * 
	 * @param arg: Current string, which is the operator we pushed in.
	 */

	public void push(String arg) {

		ListNode node = new ListNode();// Create new entry.
		node.data = arg;// Load data.
		node.next = top;// Link to rest of stack.
		top = node;// Make top point to new entry.
	}

	/**
	 * Pop method: This method helps pop operators from the stack.
	 * 
	 * @return: The operators we popped out.
	 */
	public String pop() {
		// Check if the stack is empty.
		if (top == null) {
			return null;
		}
		String data = top.data;// If not empty, pop out top data.
		top = top.next;// Pop out the next data.
		return data;
	}
}
