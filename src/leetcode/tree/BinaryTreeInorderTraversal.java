package code.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public void inorder(TreeNode root, List<Integer> result) {
		if (root != null) {
			inorder(root.left, result);
			result.add(root.val);
			inorder(root.right, result);
		}
	}

	public static void main(String[] args) {
		List<Integer> result = new ArrayList<>();
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
		solution.inorder(root, result);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
