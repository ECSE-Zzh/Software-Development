#include <stdlib.h>
#include <stdio.h>
#include "bTree.h"
#include <string.h>
/**
 *  SortBuffer is the main class which is responsible for all user interaction.
 *
 */
int main() {
	/**
	 * Main method makes the program start to run.
	 *
	 */
	// Main method:
	// Print greeting and instructions.
	printf("Text Sorting Program: (ECSE202 - Assignment5)\n");
	printf("Enter text to be sorted, line by line. A blank line terminates.\n");
	printf("You can cut and paste text into this window: \n");

	initTree();

	while (true) {
		int BUF = 100;
		char *buffer = malloc(BUF); // Creates a pointer to buffer.
		fgets(buffer, BUF, stdin);	// Read the input.
		// Check if buffer is null.
		if (buffer == NULL) {
			printf("Can't allocate buffer.\n");
			return -1;
		}
		// Check for break.
		if (strlen(buffer) <= 1) {
			break;
		} else {
			buffer[strlen(buffer) - 1] = '\0';
			addNode(buffer); // Adds node.
		}
	}
	//Sort in order
	char **arrc = makeSortIndex('c');
	printf("\nText in sort order: \n");
	printf("\n");
	for (int i = 0; i < getNumNodes(); i++) {
		printf("%s\n", arrc[i]);
	}
	// Sort in reverse order.
	char **arrd = makeSortIndex('d');
	printf("\nText in reverse sort order: \n");
	printf("\n");
	for (int i = 0; i < getNumNodes(); i++) {
		printf("%s\n", arrd[i]);
	}

	printf("\n");
	printf("Program terminates.\n"); // Termination of program.
	deleteTree(); // Deallocates.
	return 0;
}
