package tree;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
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

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left.toString() + ", right=" + right.toString() + "]";
	}

}
