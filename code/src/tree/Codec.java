package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Integer;

public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		ArrayList<Integer> arrs = new ArrayList<Integer>();
		if (root == null) {
			System.out.println(arrs.toString());
			return arrs.toString();
		}
		nodes.add(root);
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			if (node == null) {
				arrs.add(null);
				continue;
			}
			arrs.add(node.val);
			nodes.add(node.left);
			nodes.add(node.right);
		}
		int right = arrs.size() - 1;
		while (arrs.get(right) == null) {
			arrs.remove(right--);
		}
		return arrs.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<TreeNode> q = new LinkedList<>();
		if (data.equals("[]")) {
			return null;
		}
		String[] values = data.substring(1, data.length() - 1).split(",");
		ArrayList<Integer> arrays = new ArrayList<>();
		for (String val : values) {
			if (val.trim().equals("null")) {
				arrays.add(null);
			} else {
				arrays.add(Integer.valueOf(val.trim()));
			}
		}
		TreeNode root = new TreeNode(arrays.get(0));
		q.add(root);
		for (int i = 1; i < arrays.size(); i++) {
			TreeNode parent = q.poll();
			if (arrays.get(i) != null) {
				TreeNode left = new TreeNode(arrays.get(i));
				parent.left = left;
				q.add(left);
			}
			if (i + 1 < arrays.size()) {
				if (arrays.get(++i) != null) {
					TreeNode right = new TreeNode(arrays.get(i));
					parent.right = right;
					q.add(right);
				}
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Codec codec = new Codec();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);

		System.out.println(codec.serialize(root));
		TreeNode newroot = codec.deserialize(codec.serialize(root));
		if (newroot == null) {
			System.out.println("is null");
		}
		newroot.printTree(newroot);
	}

}
