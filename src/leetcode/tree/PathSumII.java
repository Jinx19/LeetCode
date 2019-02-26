package code.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<>();
		ArrayList<Integer> Path = new ArrayList<>();
		pathSum(root, sum, Path, allPaths);

		return allPaths;
	}

	private void pathSum(TreeNode root, int sum, ArrayList<Integer> Path, List<List<Integer>> allPaths) {
		if (root == null)
			return;
		sum -= root.val;
		Path.add(root.val);

		if (root.left == null && root.right == null) {
			if (sum == 0) {
				allPaths.add(new ArrayList<>(Path));
			}
		} else {
			if (root.left != null) {
				pathSum(root.left, sum, Path, allPaths);
			}
			if (root.right != null) {
				pathSum(root.right, sum, Path, allPaths);
			}
		}
		Path.remove(Path.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.right = new TreeNode(4);
		root.right.left = new TreeNode(13);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		PathSumII ps = new PathSumII();
		List<List<Integer>> all = ps.pathSum(root, 22);
		for (List<Integer> list : all) {
			for (int i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
