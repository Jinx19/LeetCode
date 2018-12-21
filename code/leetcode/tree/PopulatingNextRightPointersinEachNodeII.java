package leetcode.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {
	private int height(TreeLinkNode root) {
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

	private void getGivenLevel(TreeLinkNode root, int level, Queue<TreeLinkNode> queue) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			queue.add(root);
		} else if (level > 1) {
			getGivenLevel(root.left, level - 1, queue);
			getGivenLevel(root.right, level - 1, queue);
		}
	}

	public void print(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode start = root;
		TreeLinkNode cur = root;
		System.out.print(cur.val);
		while (cur.next != null) {
			cur = cur.next;
			System.out.print(cur.val);
		}
		System.out.println();
		print(start.left);
	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		int height = height(root);
		root.next = null;
		for (int i = 2; i <= height; i++) {
			Queue<TreeLinkNode> levelINodes = new LinkedList<TreeLinkNode>();
			getGivenLevel(root, i, levelINodes);
			if (!levelINodes.isEmpty()) {
				Iterator<TreeLinkNode> iterator = levelINodes.iterator();
				TreeLinkNode start = iterator.next();
				while (iterator.hasNext()) {
					TreeLinkNode cur = iterator.next();
					start.next = cur;
					start = cur;
				}
				start.next = null;
			}
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.right = new TreeLinkNode(7);
		PopulatingNextRightPointersinEachNodeII solution = new PopulatingNextRightPointersinEachNodeII();
		solution.connect(root);
		solution.print(root);
	}
}
