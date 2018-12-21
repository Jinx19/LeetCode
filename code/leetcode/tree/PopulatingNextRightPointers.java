package leetcode.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
	private int height(TreeLinkNode root) {
		if (root == null)
			return 0;
		else {
			int lheight = height(root.left);
			int rheight = height(root.right);

			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	private void addGivenLevel(TreeLinkNode root, int level, Queue<TreeLinkNode> queue) {
		if (root == null)
			return;
		if (level == 1)
			queue.add(root);
		else if (level > 1) {
			addGivenLevel(root.left, level - 1, queue);
			addGivenLevel(root.right, level - 1, queue);
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queuefather = new LinkedList<TreeLinkNode>();
		int height = height(root);
		root.next = null;
		queuefather.add(root);
		for (int i = 2; i <= height; i++) {
			Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
			addGivenLevel(root, i, queue);
			double count = Math.pow(2, i - 1);
			Iterator<TreeLinkNode> iterator = queue.iterator();
			TreeLinkNode father = queuefather.poll();
			while (iterator.hasNext()) {
				TreeLinkNode temp = iterator.next();
				if (father!=null&&count % 2 == 0) {
					temp.next = father.right;
				} else if (queuefather.isEmpty()) {
					temp.next = null;
				} else {
					father = queuefather.poll();
					temp.next = father.left;
				}
				count++;
			}
			queuefather.addAll(queue);
		}
	}
	
	public static void main(String[] args) {
		PopulatingNextRightPointers so = new PopulatingNextRightPointers();
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		so.connect(root);
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeLinkNode node = queue.poll();
			System.out.println(node.next);
			if(node.left!=null) {
				queue.add(node.left);
			}
			if(node.right!=null) {
				queue.add(node.right);
			}
		}
	}

}
