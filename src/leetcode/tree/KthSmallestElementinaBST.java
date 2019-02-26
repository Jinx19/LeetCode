package code.leetcode.tree;

import java.util.ArrayList;

public class KthSmallestElementinaBST {
	public void inOrder(TreeNode root, ArrayList<Integer> nodes) {
		if (root == null) {
			return;
		} else {
			inOrder(root.left, nodes);
			nodes.add(root.val);
			inOrder(root.right, nodes);
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> nodes = new ArrayList<>();
		inOrder(root, nodes);
		return nodes.get(k - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		KthSmallestElementinaBST bst = new KthSmallestElementinaBST();
		System.out.println(bst.kthSmallest(root, 2));
	}
}
