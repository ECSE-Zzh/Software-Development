import acm.program.*;

/**
 * bTree is the class that allows all strings to be rendered in both ascending
 * and descending sort order.
 * 
 * @author Zhiheng Zhou
 *
 */
public class bTree {
	ConsoleProgram link; // Provides a link to the ConsoleProgram instance, SortBuffer.

	/**
	 * bNode is a nested class. bNode class defines nodes with left and right
	 * successors. This nested class helps create a bTree structure.
	 * 
	 */
	class bNode {
		String dataList;
		bNode left;
		bNode right;

		/**
		 * This is a constructor which creates a structure to start out.
		 * 
		 * @param Data is the data we sent in, and we assign its value to this dataList.
		 */

		public bNode(String Data) {
			dataList = Data;
		}

	}

	bNode root;// Adds this root element.

	/**
	 * addNodes method adds new nodes to leaf node by using while loop.
	 * 
	 * @param myNewData assigns its value to Data by calling constructor.
	 */

	public void addNodes(String myNewData) {
		bNode newNode = new bNode(myNewData);
		bNode currentNode = root;
		if (currentNode != null) {// If the tree is not empty, set root equals to current node.
			currentNode = root;
		} else {
			root = newNode;// If the tree is empty, set root equals to our input data.
			return;
		}
		while (true) {
			// If new data < current node, branch left.
			if (myNewData.compareTo(currentNode.dataList) < 0) {
				if (currentNode.left != null) {
					currentNode = currentNode.left;
				} else {
					currentNode.left = newNode;
					break;
				}
			} else {
				// If new data > current node, branch right.
				if (currentNode.right != null) {
					currentNode = currentNode.right;
				} else {
					currentNode.right = newNode;
					break;
				}
			}
		}

	}

	/**
	 * In order traversal via call to recursive method.
	 */
	public void inOrder() {
		displayInOrder(root);
	}

	/**
	 * Sort in order: left-root-right.
	 * 
	 * @param root is where we start this traversal.
	 */
	public void displayInOrder(bNode root) {
		if (root.left != (null))
			displayInOrder(root.left);// Uses recursion to call itself until left == null.
		link.println(root.dataList);// Prints each node.
		if (root.right != (null))
			displayInOrder(root.right);// Uses recursion to call itself until right == null.
	}

	/**
	 * In reverse order traversal via call to recursive method.
	 */
	public void reverseOrder() {
		displayInReverseOrder(root);
	}

	/**
	 * Sort in reverse order: right-root-left.
	 * 
	 * @param root is where we start this traversal.
	 */
	public void displayInReverseOrder(bNode root) {
		if (root.right != (null))
			displayInReverseOrder(root.right);// Uses recursion to call itself until right == null.
		link.println(root.dataList);// Prints each node.
		if (root.left != (null))
			displayInReverseOrder(root.left);// Uses recursion to call itself until left == null.

	}

	/**
	 * This setDisplay method provides a link to the ConsoleProgram instance,
	 * SortBuffer.
	 * 
	 * @param link provides reference that allows this bTree class to use the
	 *             println() method included in CosoleProgram.
	 */

	public void setDisplay(ConsoleProgram link) {
		this.link = link;
	}
}
