#include <stdio.h>
#include <stdlib.h>
#include "bTree.h"
#include <string.h>
/**
 * bTree is the class that allows all strings to be rendered in both ascending
 * and descending sort order.
 *
 *
 */

// "Instance" Variables - global to all functions in the bTree.c file.
bNode *root = NULL; // bTree root node
int numNodes = 0; // Number of nodes in tree
int recCount = 0; // Count variable for use in recursions
char **indexArray; // index array for tree sort

/**
 * initTree function: sets root to null and numNodes to 0.
 */
void initTree() {
	numNodes = 0;
	root = NULL;
}

/**
 * addNodes function: adds a new node to bTree.
 *
 * @param: char *data: this is the value we sent in.
 */
void addNode(char *data) {

	// Increment numNodes each time a new node is added.
	numNodes = numNodes + 1;
	bNode *newNode = makeNode(data);

	// If root is null, set root equals to newNode.
	if (root == NULL) {
		root = newNode;
		return;
	}
	// Traverse nodes of bTree from root.
	bNode *currentNode = root;
	while (true) {
		// Compares strings.
		if (strcasecmp(data, currentNode->data) < 0) {
			if (currentNode->left != NULL) {
				currentNode = currentNode->left;
			} else {
				currentNode->left = newNode;
				break;
			}
		} else {
			if (currentNode->right != NULL) {
				currentNode = currentNode->right;
			} else {
				currentNode->right = newNode;
				break;
			}
		}
	}
}

/**
 * makeNodes function: allocates bNode.
 *
 * @param: char *data: this is the value we sent in.
 */
bNode* makeNode(char *data) {

	// Allocate memory for bNode.
	bNode *node = (bNode*) malloc(sizeof(bNode));
	node->data = data;
	node->left = NULL;
	node->right = NULL;
	return node;
}

/**
 * inOrder function: sorts in order (left-root-right).
 *
 * @param: bNode *root: root is where we start this traversal.
 */
void inOrder(bNode *root) {

	if (root->left != NULL) {
		inOrder(root->left);
	}
	indexArray[recCount++] = root->data;
	if (root->right != NULL) {
		inOrder(root->right);
	}
}

/**
 * inReverseOrder function: sorts in reverse order (right-root-left).
 *
 * @param: bNode *root: root is where we start this traversal.
 */
void inReverseOrder(bNode *root) {

	if (root->right != NULL) {
		inReverseOrder(root->right);
	}
	indexArray[recCount++] = root->data;
	if (root->left != NULL) {
		inReverseOrder(root->left);
	}
}

/**
 * makeSortIndex function: returns an array of pointers to strings in sort order.
 *
 * @param: char arg: Determines whether the sort is in ascending or descending order.
 * @return: An array of pointers to strings in sort order.
 */
char** makeSortIndex(char arg) {

	// Allocate memory
	indexArray = (char**) malloc(sizeof(char*) * numNodes);
	// Set recCount to 0.
	recCount = 0;
	// Determines whether the sort is in ascending or descending order
	if (arg == 'd' || arg == 'D') {
		inReverseOrder(root);
	} else {
		inOrder(root);
	}
	return indexArray;
}

/**
 * deleteTree function: deallocates each node in the B-Tree created with addNode().
 */
void deleteTree() {
	postOrder(root);
}

/**
 * postOrder function: deallocates each node.
 *
 * @param: bNode *root: root of the bTree.
 */
void postOrder(bNode *root) {
	free(root->data); // Deallocate buffer (explained later)
	free(root); // Deallocate bNode
}
/**
 * getNumNodes function: the getter returns the number of nodes in the tree.
 */
int getNumNodes() {
	return numNodes;
}
