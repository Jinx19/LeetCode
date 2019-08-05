package leetcode.tree;

public class MinimumSubtree {
	private TreeNode returnRoot;
	private int sum = Integer.MAX_VALUE;

	// traverse + divide conquer
	public TreeNode getMinimumSubtree(TreeNode root) {

		helper(root);
		return returnRoot;
	}

	public int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int currentSum = helper(node.left) + helper(node.right) + node.val;
		if (currentSum < sum) {
			returnRoot = node;
			sum = currentSum;
		}
		return currentSum;
	}
	
	//pure divide conquer
	public TreeNode getMinimumSubtreeVersion1(TreeNode root) {
		
		helper(root);
		return returnRoot;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-5);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(-4);
		root.right.right = new TreeNode(-5);

		MinimumSubtree ms = new MinimumSubtree();
		System.out.println(ms.getMinimumSubtree(root).val);

	}
}
