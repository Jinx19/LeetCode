package tree;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public void printTree(TreeNode root) {
		if (root != null) {
			printTree(root.left);
			System.err.println(root.val);
			printTree(root.right);
		} else {
			return;
		}
	}
}
