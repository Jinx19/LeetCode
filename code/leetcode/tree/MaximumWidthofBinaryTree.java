package code.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaximumWidthofBinaryTree {
	Map<Integer, Integer> left;
	int ans;

	public void dfs(TreeNode root, int depth, int pos) {
		if (root == null)
			return;
		left.computeIfAbsent(depth, x -> pos);
		ans = Math.max(ans, pos - left.get(depth) + 1);
		dfs(root.left, depth + 1, 2 * pos);
		dfs(root.right, depth + 1, 2 * pos + 1);
	}

	public int widthOfBinaryTree(TreeNode root) {
		ans = 0;
		left = new HashMap<>();
		dfs(root, 0, 0);
		return ans;
	}

	public static void main(String[] args) {
		MaximumWidthofBinaryTree mwbt = new MaximumWidthofBinaryTree();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);
		System.out.println(mwbt.widthOfBinaryTree(root));

	}
}
