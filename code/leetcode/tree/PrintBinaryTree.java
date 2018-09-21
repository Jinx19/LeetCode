package leetcode.tree;

import java.util.LinkedList;

import java.util.Queue;

public class PrintBinaryTree {

	public void getMinusOneNodes(TreeNode root, int level, Queue<TreeNode> nodes) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			nodes.add(root);
		} else {
			getMinusOneNodes(root.left, level - 1, nodes);
			getMinusOneNodes(root.right, level - 1, nodes);
		}
	}

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		} else {
			Queue<TreeNode> nodes = new LinkedList<>();
			getMinusOneNodes(root, d - 1, nodes);
			while (!nodes.isEmpty()) {
				TreeNode node = nodes.poll();
				if (node.left == null && node.right == null) {
					node.left = new TreeNode(v);
					node.right = new TreeNode(v);
				} else {
					if (node.left != null) {
						TreeNode temp = node.left;
						TreeNode addNode = new TreeNode(v);
						node.left = addNode;
						addNode.left = temp;
					}

					if (node.right != null) {
						TreeNode temp = node.right;
						TreeNode addNode = new TreeNode(v);
						node.right = addNode;
						addNode.right = temp;
					}
				}
			}
			return root;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(37);
		root.left = new TreeNode(-34);
		root.right = new TreeNode(-48);
		root.left.right = new TreeNode(-100);
		root.right.left = new TreeNode(-100);
		PrintBinaryTree pbt = new PrintBinaryTree();
		TreeNode res = pbt.addOneRow(root, 1, 2);
		res.printTree(res);
	}
}
