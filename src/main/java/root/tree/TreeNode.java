package root.tree;

import java.util.HashMap;

/**
 * Represents a Node in a Tree of Strings
 */
class TreeNode {

	private String value;

	private HashMap<String, TreeNode> children = new HashMap<String, TreeNode>();
	private boolean isLeaf;

	public TreeNode() {
	}

	public TreeNode(String value) {
		this.value = value;
	}

	public HashMap<String, TreeNode> getChildren() {
		return children;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}