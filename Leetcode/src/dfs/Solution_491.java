package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author mac Given an integer array, your task is to find all the different
 *         possible increasing subsequences of the given array, and the length
 *         of an increasing subsequence should be at least 2 . Input: [4, 6, 7,
 *         7] Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7,
 *         7], [7,7], [4,7,7]]
 */
public class Solution_491 {
	public List<List<Integer>> findSubsequences(int[] nums) {
		HashSet<List<Integer>> mySet = new HashSet<>();
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		helper(mySet, new ArrayList<>(), nums, 0);
		return new ArrayList<>(mySet);
	}

	public void helper(Set<List<Integer>> set, List<Integer> list, int[] nums, int start) {
		if (list.size() >= 2) {
			set.add(new ArrayList(list));
		}

		for (int i = start; i < nums.length; i++) {
			if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
				list.add(nums[i]);
				helper(set, list, nums, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Solution_491 so = new Solution_491();
		List<List<Integer>> res = so.findSubsequences(new int[] { 4, 6, 7, 7 });
		for (List<Integer> list : res) {
			System.out.print("{");
			for (int i : list) {
				System.out.print(i);
			}
			System.out.println("}");
		}

	}
}
