package code.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllDuplicaetSubtrees {
	public static void print(TreeNode node) {
		if (node == null) {
			return;
		} else {
			System.out.println(node.val);
			print(node.left);
			print(node.right);
		}
	}

	static HashMap<String, Integer> m;

	static String inorder(TreeNode node, List<TreeNode> result) {
		if (node == null) {
			return "";
		}

		String str = "(";
		str += inorder(node.left, result);
		str += Integer.toString(node.val);
		str += inorder(node.right, result);
		str += ")";

		if (m.get(str) != null && m.get(str) == 1) {
			result.add(node);
		}

		if (m.containsKey(str)) {
			m.put(str, m.get(str) + 1);
		} else {
			m.put(str, 1);
		}

		return str;
	}

	static void printAllDups(TreeNode root, List<TreeNode> result) {
		m = new HashMap<>();
		inorder(root, result);
	}

	public static void main(String[] args) {
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(4);
		root.right.right = new TreeNode(4);
		List<TreeNode> result = new ArrayList<TreeNode>();
		printAllDups(root, result);
		for (TreeNode node : result) {
			print(node);
		}
	}
}
