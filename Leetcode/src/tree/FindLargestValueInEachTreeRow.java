package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class FindLargestValueInEachTreeRow {
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int lheight = getHeight(root.left);
			int rheight = getHeight(root.right);
			if (lheight > rheight) {
				return (lheight + 1);
			} else {
				return (rheight + 1);
			}
		}
	}

	public void getLevelNodes(TreeNode root, TreeSet<Integer> map, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			map.add(root.val);
		} else {
			getLevelNodes(root.left, map, level - 1);
			getLevelNodes(root.right, map, level - 1);
		}
	}

	public List<Integer> largestValues(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		int height = getHeight(root);
		List<Integer> result = new ArrayList<>();
		TreeSet<Integer> map = new TreeSet<>();
		for (int i = 1; i <= height; i++) {
			getLevelNodes(root, map, i);
			result.add(map.last());
			map.clear();
		}
		return result;
	}

	public static void main(String[] args) {
		FindLargestValueInEachTreeRow fvit = new FindLargestValueInEachTreeRow();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);
		List<Integer> result = fvit.largestValues(root);
		for(int i : result) {
			System.out.println(i);
		}
	}
}
