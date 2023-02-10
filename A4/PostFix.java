import java.util.StringTokenizer;

/**
 * PostFix class: This class helps convert infix expression to postfix form.
 * 
 */
public class PostFix {

	/**
	 * parse method: This method takes a string containing an infix or postfix
	 * expression and parses it into a set of tokens.
	 * 
	 * @param arg: Input by the user.
	 * @return queue: Tokens are returned in a queue.
	 */
	public Queue parse(String arg) {

		Queue queue = new Queue();
		StringTokenizer st = new StringTokenizer(arg, "+-*/()", true);
		while (st.hasMoreTokens()) {
			// If there are more tokens, get next token.
			String token = st.nextToken();
			queue.enqueue(token);// Send each token enqueue.
		}
		return queue;
	}

	/**
	 * In2Post method: This method helps convert infix expression to postfix form.
	 * 
	 * @param Qin: A queue containing a tokenized infix expression.
	 * @return resultQueue: the postfix form of the infix expression.
	 */
	public Queue In2Post(Queue Qin) {

		Queue resultQueue = new Queue();// Create a queue.
		Stack operatorStack = new Stack();// Create a stack.
		String currentStr = Qin.dequeue();// Read a token.

		while (currentStr != null && !"".equals(currentStr)) {
			if ("(".equals(currentStr)) {
				// If is '(', push in stack.
				operatorStack.push(currentStr);
				currentStr = Qin.dequeue();// Read next token.
			} else if (isOperator(currentStr)) {
				// Check if is an operator
				if (operatorStack.top == null) {
					// If the operator stack is empty, send this operator to top.
					operatorStack.push(currentStr);
					currentStr = Qin.dequeue();// Read next token.
				} else if (getPriority(currentStr) > getPriority(operatorStack.top.data)) {
					// If the current operator has a greater precedence than the operator at the
					// top, push it to stack.
					operatorStack.push(currentStr);
					currentStr = Qin.dequeue();// Read next token.
				} else {
					while (true) {
						// Popping operators with greater or the same precedence as current operators.
						String operator = operatorStack.pop();
						resultQueue.enqueue(operator);// Enqueue.
						if (operatorStack.top == null) {
							// If all those operators are popped, push current operator into stack.
							operatorStack.push(currentStr);
							break;
						} else if (getPriority(currentStr) > getPriority(operatorStack.top.data)) {
							// If the stack is not empty and operator at the top has a higher precedence
							// than current operator, push current operator into stack.
							operatorStack.push(currentStr);
							break;
						} else {

						}
					}
					currentStr = Qin.dequeue();
				}
			} else if (")".equals(currentStr)) {
				while (true) {
					// If is ')', pop it from the stack.
					String operator = operatorStack.pop();
					if ("(".equals(operator)) {
						// If there's a '(', break.
						break;
					} else {
						resultQueue.enqueue(operator);
					}
				}
				currentStr = Qin.dequeue();
			} else {
				// If is number, enqueue.
				resultQueue.enqueue(currentStr);
				currentStr = Qin.dequeue();
			}
		}
		// Enqueue other operators in the stack.
		while (operatorStack.top != null) {
			String operator = operatorStack.pop();
			resultQueue.enqueue(operator);
		}
		return resultQueue;
	}

	/**
	 * isOperator method: This method helps check whether the token is an operator
	 * or not.
	 * 
	 * @param character: tokens.
	 * @return
	 */
	boolean isOperator(String character) {

		if ("+".equals(character) || "-".equals(character) || "*".equals(character) || "/".equals(character)) {
			return true;
		}
		return false;
	}

	/**
	 * getPriority method: This method helps set priority to operators.
	 * 
	 * @param character: tokens
	 * @return: precedence
	 */
	int getPriority(String character) {

		switch (character) {
		case "(":
			return 0;
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		default:
			return -1;
		}
	}

	/**
	 * PostEval method: This method helps evaluating the input expression.
	 * 
	 * @param PostFix: Postfix version of input expression.
	 * @return result: Calculation result.
	 */

	public double PostEval(Queue PostFix) {
		Double result = null;// Initialize.
		Stack data = new Stack();// Create data stack to store operands
		String myToken = PostFix.dequeue();// Take token.
		while (true) {
			if (!isOperator(myToken)) {
				data.push(myToken);// Push operand into stack.
			} else {
				String OP_A = data.pop();// Pop one operand out of stack.
				String OP_B = data.pop();// Pop another operand out of stack.
				Double A = Double.parseDouble(OP_A);// Parse the first operand to double.
				Double B = Double.parseDouble(OP_B);// Parse the second operand to double.
				switch (myToken) {
				// Evaluating an expression.
				case "+":
					result = B + A;
					break;
				case "-":
					result = B - A;
					break;
				case "*":
					result = B * A;
					break;
				case "/":
					result = B / A;
					break;
				default:
					result = null;
					break;
				}
				data.push(result.toString());// Push result into stack.
			}
			if (PostFix.front == null) {
				// If queue is empty, break.
				break;
			} else {
				// If queue is not empty, take next token.
				myToken = PostFix.dequeue();
			}
		}
		return result;
	}
}
