package root.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * This class in a Tree of strings which implements the DataStructureInterface,
 * it allows inserting the phrases into the tree, currently at startup but it
 * can be changed to add or remove phrases during runtime, it allows searching
 * for the longest phrase starting from the start of the input
 */
public class Tree implements DataStructureInterface {

	private TreeNode root;

	private static final String SPACE_STRING = " ";

	public Tree() {
		root = new TreeNode();
	}

	/**
	 * Insert a dictionary phrase into the tree
	 */
	@Override
	public void insert(String phrase) {

		HashMap<String, TreeNode> children = root.getChildren();
		String words[] = phrase.split(SPACE_STRING);

		int i = 0;
		for (String word : words) {

			TreeNode treeNode;
			if (children.containsKey(word)) {
				treeNode = children.get(word);
			} else {
				treeNode = new TreeNode(word);
				children.put(word, treeNode);
			}

			children = treeNode.getChildren();

			// set leaf node
			if (i++ == words.length - 1) {
				treeNode.setIsLeaf(true);
			}
		}

	}

	/**
	 * Search for the longest phrase that starts at the first char of the input
	 */
	@Override
	public String search(String input) {
		Map<String, TreeNode> children = root.getChildren();
		String words[] = input.split(SPACE_STRING);
		StringBuffer bestSoFar = new StringBuffer();
		StringBuffer current = new StringBuffer();

		for (String word : words) {

			current.append(SPACE_STRING + word);

			if (!children.containsKey(word)) {
				return bestSoFar.toString();
			} else if (children.get(word).isLeaf()) {
				bestSoFar = new StringBuffer(current);
			}
			children = children.get(word).getChildren();
		}
		return bestSoFar.toString();
	}

}
