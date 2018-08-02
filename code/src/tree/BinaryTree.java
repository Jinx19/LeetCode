package tree;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {
	TreeNode root;

	public BinaryTree() {
		root = null;
	}

	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}

	private void printGivenLevel(TreeNode root, int level) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}

		if (level == 1) {
			System.out.println(root.val + " ");
		} else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	int height(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int lheight = height(root.left);
			int rheight = height(root.right);

			if (lheight > rheight) {
				return lheight + 1;
			} else {
				return rheight + 1;
			}
		}
	}

	private void printLevelOrder2() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			System.out.println(tempNode.val + " ");

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder2();
	}

}
