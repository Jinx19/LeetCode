package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	private int height(TreeNode root) {
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

	private void addGivenLevelFromLeftToRight(TreeNode root, List<Integer> levelNodes, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			levelNodes.add(root.val);
		} else if (level > 1) {
			addGivenLevelFromLeftToRight(root.left, levelNodes, level - 1);
			addGivenLevelFromLeftToRight(root.right, levelNodes, level - 1);

		}
	}

	private void addGivenLevelFromRightToLeft(TreeNode root, List<Integer> levelNodes, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			levelNodes.add(root.val);
		} else if (level > 1) {
			addGivenLevelFromLeftToRight(root.right, levelNodes, level - 1);
			addGivenLevelFromLeftToRight(root.left, levelNodes, level - 1);
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			List<Integer> levelNodes = new ArrayList<>();
			if (i % 2 != 0) {
				addGivenLevelFromLeftToRight(root, levelNodes, i);
			} else {
				addGivenLevelFromRightToLeft(root, levelNodes, i);
			}
			result.add(levelNodes);
		}
		return result;
	}
	/***
	 *  3
	   / \
	  9  20
	    /  \
	   15   7
	 * @param args
	 */
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> result = solution.zigzagLevelOrder(root);
		for(List<Integer> level : result ) {
			for(int i : level) {
				System.out.print(i);
			}
			System.out.println("..");
		}
	}
}
