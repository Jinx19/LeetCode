package leetcode.tree;




public class CountCompleteTreeNodes {
	public int getLeftHeight(TreeNode n) {
		if (n == null)
			return 0;

		int height = 0;
		while (n.left != null) {
			height++;
			n = n.left;
		}
		return height;
	}

	public int getRightHeight(TreeNode n) {
		if (n == null) {
			return 0;
		}
		int height = 0;
		while (n.right != null) {
			height++;
			n = n.right;
		}

		return height;
	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getLeftHeight(root) + 1;
		int right = getRightHeight(root) + 1;
		if (left == right) {
			return (2 << (left - 1)) - 1;
		} else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}

		// Queue<TreeNode> queue = new LinkedList<>();
		// queue.add(root);
		// int count = 0;
		// while (!queue.isEmpty()) {
		// TreeNode node = queue.poll();
		// count++;
		// if (node.left != null) {
		// queue.add(node.left);
		// }
		// if (node.right != null) {
		// queue.add(node.right);
		// }
		// }
		// return count;
	}

	public static void main(String[] args) {
		CountCompleteTreeNodes solution = new CountCompleteTreeNodes();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		System.out.println(solution.countNodes(root));
	}
}
