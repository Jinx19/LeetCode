package leetcode.tree;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindFrequentTreeSum {

	int max = 0;

	public int subTreeSum(TreeNode root) {
		if (root == null)
			return 0;
		int sum = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			sum += temp.val;
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
		return sum;
	}

	public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null)
			return new int[] {};
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			int val = temp.val + subTreeSum(temp.left) + subTreeSum(temp.right);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
			if (hash.containsKey(val)) {
				hash.put(val, hash.get(val) + 1);
			} else {
				hash.put(val, 1);
			}
			max = Math.max(hash.get(val), max);
		}
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
			if (entry.getValue() == max)
				array.add(entry.getKey());
		}
		int[] result = new int[array.size()];
		int i = 0;
		Iterator<Integer> it = array.iterator();
		while (it.hasNext()) {
			result[i++] = it.next();
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(14);
		root.left.left = new TreeNode(1);

		FindFrequentTreeSum ffts = new FindFrequentTreeSum();
		int[] result = ffts.findFrequentTreeSum(root);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
