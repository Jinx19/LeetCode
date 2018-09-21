package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LowestCommonAncestorofaBinaryTree {
	public void pre(TreeNode root, HashMap<Integer, Integer> nodes) {
		if (root == null) {
			return;
		} else {
			if (nodes.containsKey(root.val)) {
				nodes.put(root.val, nodes.get(root.val) + 1);
			} else {
				nodes.put(root.val, 1);
			}
			pre(root.left, nodes);
			pre(root.right, nodes);
		}
	}

	public boolean contains(TreeNode root, TreeNode p, TreeNode q) {
		HashMap<Integer, Integer> map = new HashMap<>();
		boolean containsp = false;
		boolean containsq = false;
		pre(root, map);
		if (map.containsKey(p.val)) {
			map.put(p.val, map.get(p.val) - 1);
			if (map.get(p.val) == 0) {
				map.remove(p.val);
			}
			containsp = true;
		}

		if (map.containsKey(q.val)) {
			map.put(q.val, map.get(q.val) - 1);
			if (map.get(q.val) == 0) {
				map.remove(q.val);
			}
			containsq = true;
		}
		return containsp && containsq;

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Queue<TreeNode> nodes = new LinkedList<>();
		// TreeNode res = null;
		// nodes.add(root);
		// while (!nodes.isEmpty()) {
		// TreeNode temp = nodes.poll();
		// if (contains(temp, p, q)) {
		// res = temp;
		// }
		// if (temp.left != null) {
		// nodes.add(temp.left);
		// }
		// if (temp.right != null) {
		// nodes.add(temp.right);
		// }
		// }
		// return res;
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(37);
		root.left = new TreeNode(-34);
		root.right = new TreeNode(-48);
		root.left.left = new TreeNode(-100);
		root.right.left = new TreeNode(-100);
		LowestCommonAncestorofaBinaryTree so = new LowestCommonAncestorofaBinaryTree();
		TreeNode p = new TreeNode(-100);
		TreeNode q = new TreeNode(-100);
		TreeNode node = so.lowestCommonAncestor(root, p, q);
		System.out.println(node.val);
	}
}
