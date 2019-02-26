package code.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreetoLinkedList {
	public void preOrder(TreeNode root, Queue<Integer> queue) {
		if (root == null) {
			return;
		} else {
			queue.add(root.val);
			preOrder(root.left, queue);
			preOrder(root.right, queue);
		}
	}

	public void print(TreeNode root) {
		if (root == null) {
			return;
		} else {
			System.out.println(root.val);
			print(root.left);
			print(root.right);
		}
	}

	public void flatten(TreeNode root) {
		Queue<Integer> queue = new LinkedList<>();
		preOrder(root, queue);
		root.val = queue.poll();
		root.left = null;
		root.right = null;
		TreeNode temp = root;
		while (!queue.isEmpty()) {
			temp.right = new TreeNode(queue.poll());
			temp.left = null;
			temp = temp.right;
		}
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		FlattenBinaryTreetoLinkedList f = new FlattenBinaryTreetoLinkedList();
		f.flatten(root);
	}
}
