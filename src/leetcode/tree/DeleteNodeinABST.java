package code.leetcode.tree;

public class DeleteNodeinABST {
	public static TreeNode root;

	public void printBST(TreeNode root) {
		if (root == null) {
			return;
		} else {
			System.out.println(root.val);
			printBST(root.left);
			printBST(root.right);
		}
	}

	public TreeNode searchKey(TreeNode root, int key) {
		if (root == null || key == root.val) {
			return root;
		}

		if (key < root.val) {
			return searchKey(root.left, key);
		} else {
			return searchKey(root.right, key);
		}
	}

	public TreeNode minMum(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public TreeNode deleteMin(TreeNode x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		return x;
	}

	// public TreeNode findParent(TreeNode root, TreeNode key) {
	// if (root == null || root.left == key || root.right == key) {
	// return root;
	// } else if (key.val < root.val) {
	// return findParent(root.left, key);
	// } else {
	// return findParent(root.right, key);
	// }
	// }
	//
	// public void transplant(TreeNode root, TreeNode u, TreeNode v) {
	// if (findParent(root, u) == null) {
	// root = v;
	// } else if (u == findParent(root, u).left) {
	// findParent(root, u).left = v;
	// } else {
	// findParent(root, u).right = v;
	// }
	//
	// if (v != null) {
	// TreeNode parentofv = findParent(root, v);
	// parentofv = findParent(root, u);
	// }
	// }

	public TreeNode deleteNode(TreeNode root, int key) {
		// if (root == null || searchKey(root, key) == null) {
		// return root;
		// }
		//
		// TreeNode node = searchKey(root, key);
		// if (node.left == null) {
		// transplant(root, node, node.right);
		// } else if (node.right == null) {
		// transplant(root, node, node.left);
		// } else {
		// TreeNode y = minMum(node.right);
		// if (findParent(root, y) != node) {
		// transplant(root, y, y.right);
		// y.right = node.right;
		// TreeNode yrightp = findParent(root, y.right);
		// yrightp = y;
		// }
		// transplant(root, node, y);
		// y.left = node.left;
		// TreeNode yrightp = findParent(root, y.right);
		// yrightp = y;
		// }
		// return root;
		if (root == null)
			return null;
		if (key < root.val)
			root.left = deleteNode(root.left, key);
		else if (key > root.val)
			root.right = deleteNode(root.right,key);
		else {
			if (root.right == null)
				return root.left;
			if (root.left == null)
				return root.right;
			TreeNode t = root;
			root = minMum(t.right);
			root.right = deleteMin(t.right);
			root.left = t.left;
		}
		return root;
	}

	public static void main(String[] args) {
		DeleteNodeinABST delete = new DeleteNodeinABST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		delete.printBST(root);
		delete.deleteNode(root, 3);
		delete.printBST(root);
	}
}
