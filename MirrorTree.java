/**
 * 
 */
package com.sampleTest.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author skulkarni
 *
 */

class Node {
	
	char key;
	Node left = null;
	Node right = null;

	Node(char key) {
		this.key = key;
	}
}

public class MirrorTree {

	Node root;

	public MirrorTree() {
		// TODO Auto-generated constructor stub
	}

	public void mirror(boolean Recursive) {
		if ( !Recursive )
			mirrorI(root);
		else
			mirrorR(root);
	}

	private void mirrorR(Node node) {
		if (node != null) {
			// sub-trees
			mirrorR(node.left);
			mirrorR(node.right);
			
			// swap
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

	void mirrorI(Node root) 
	{ 
	    if (root == null ) 
	        return; 
	  
	     Queue<Node> q = new LinkedList<Node>(); 
	     q.add(root); 
	  
	    // Do BFS. 
	     Node temp; 
	     
	    while (!q.isEmpty())
	    { 
	        // pop top node from queue 
	        temp = q.remove(); 
	        
	        // swap left child with right child 
	        Node t = temp.left;
	        temp.left = temp.right;
	        temp.right = t;
	        
	        // Add to Q
	        if ( temp.left != null ) q.add(temp.left);
	        if ( temp.right != null ) q.add(temp.right);
	        
	    } 
	} 
	public void inOrder() {
		this.inOrder(root);
	}

	/*
	 * Helper function to test mirror(). Given a binary search tree, print out its
	 * data elements in increasing sorted order.
	 */
	void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.key + " ");

		inOrder(root.right);
	}

	/*
	 * Helper function to add Nodes in Tree!
	 */
	void addNode(Node root, char key) {
		if (root == null)
			root = new Node(key);

		inOrder(root.left);
		System.out.print(root.key + " ");

		inOrder(root.right);
	}
	/**
	 * @param args
	 */
	/* testing for example, can use JUNIT test case */
	public static void main(String args[]) {
		/*
		 * creating a tree and entering the nodes Better to right API for Insert
		 */
		MirrorTree tree = new MirrorTree();
		tree.root = new Node('A');
		tree.root.left = new Node('B');
		tree.root.right = new Node('E');
		tree.root.left.left = new Node('C');
		tree.root.left.right = new Node('D');
		tree.root.right.right = new Node('F');

		/* print traversal of the input tree */
		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder();
		System.out.println("");

		/* convert tree to its mirror - R way*/
		tree.mirror(true);
		/* print inorder traversal of the mirrored trees */
		System.out.println("Inorder traversal of Mirror (R) tree is : ");
		tree.inOrder();
		System.out.println("");
		
		// I-way
		tree.mirror(false);
		System.out.println("Inorder traversal of Mirror (I) tree is : ");
		tree.inOrder();

	}

}
