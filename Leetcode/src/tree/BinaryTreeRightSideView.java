package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int lheight = getHeight(root.left);
			int rheight = getHeight(root.right);
			if (lheight > rheight) {
				return lheight + 1;
			} else {
				return rheight + 1;
			}
		}
	}

	private void addGivenLevelFromLeftToRight(TreeNode root, Queue<TreeNode> fatherNodes, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			fatherNodes.add(root);
		} else if (level > 1) {
			addGivenLevelFromLeftToRight(root.left, fatherNodes, level - 1);
			addGivenLevelFromLeftToRight(root.right, fatherNodes, level - 1);

		}
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		if (root == null)
			return result;
		int height = getHeight(root);
		Queue<TreeNode> fatherNodes = new LinkedList<>();
		for (int i = 1; i <= height; i++) {
			addGivenLevelFromLeftToRight(root, fatherNodes, i);
			TreeNode lastNode = null;
			while(!fatherNodes.isEmpty()) {
				lastNode = fatherNodes.poll();
			}
			result.add(lastNode.val);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		BinaryTreeRightSideView btrs = new BinaryTreeRightSideView();
		List<Integer> result = btrs.rightSideView(root);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
