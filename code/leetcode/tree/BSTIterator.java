package code.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {
	TreeNode root = null;
	Queue<Integer> nodes = new LinkedList<>();

	public void helper(TreeNode root, Queue<Integer> nodes2) {
		if (root == null) {
			return;
		} else {
			helper(root.left, nodes2);
			nodes2.add(root.val);
			helper(root.right, nodes2);
		}
	}

	public BSTIterator(TreeNode root) {
		this.root = root;
		helper(root, nodes);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !nodes.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		return nodes.poll();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		BSTIterator it = new BSTIterator(root);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
