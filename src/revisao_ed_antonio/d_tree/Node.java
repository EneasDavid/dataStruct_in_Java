package revisao_ed_antonio.d_tree;

public class Node {
	  
	  int data;
	  Node left;
	  Node right;
	  Node parent;

	  public Node(int data) {
	    this.data = data;
	    this.left = null;
	    this.right = null;
	    this.parent = null;
	  }
	}