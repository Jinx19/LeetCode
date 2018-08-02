package tree;

import java.util.Arrays;

public class MaximumBinaryTree {
	public void print(TreeNode node) {
		if (node == null) {
			return;
		} else {
			System.out.println(node.val);
			print(node.left);
			print(node.right);
		}
	}

	public int findMaxIndex(int[] nums) {
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				index = i;
			}
		}
		return index;
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int maxIndex = findMaxIndex(nums);
		TreeNode root = new TreeNode(nums[maxIndex]);
		int[] numsLeft = Arrays.copyOfRange(nums, 0, maxIndex);
		int[] numsRight = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);

		root.left = constructMaximumBinaryTree(numsLeft);
		root.right = constructMaximumBinaryTree(numsRight);

		return root;
	}

	public static void main(String[] args) {
		MaximumBinaryTree mbt = new MaximumBinaryTree();
		int[] nums = { 3, 2, 1, 6, 0, 5 };
		TreeNode root = mbt.constructMaximumBinaryTree(nums);
		mbt.print(root);
	}
}
