import acm.program.*;

/**
 * SortBuffer is the main class which is responsible for all user interaction.
 * 
 *
 */
public class SortBuffer extends ConsoleProgram {
	/**
	 * Run method makes the program start to run.
	 */
	// Run method:
	// Print greeting and instructions.
	public void run() {
		println("Text Sorting Program: (ECSE202 - Assignment2)");
		println("Enter text to be sorted, line by line. A blank line terminates.");
		println("You can cut and paste text into this window: ");
		bTree myTree = new bTree();
		myTree.setDisplay(this);// Calls setDisplay method.
		myTree.root = null;
		while (true) {// Reads input and checks for break.
			String text = readLine();
			if (text.equals(""))
				break;
			myTree.addNodes(text);// Calls addNodes method.
		}
		println("Text in sort order:");
		println(" ");
		myTree.displayInOrder(myTree.root);// Calls displayInOrder method.
		println(" ");
		println("Text in reverse sort order");
		println(" ");
		myTree.displayInReverseOrder(myTree.root);// Calls displayInReverseOrder method.
		println(" ");
		println("Program terminated");// Termination of program.
	}
}
