package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int currSum = 0;
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (currSum == k)
				count++;
			if (hash.containsKey(currSum - k)) {
				count += hash.get(currSum - k);
			}
			hash.put(currSum, hash.getOrDefault(currSum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1 };
		int k = 2;
		System.out.println(subarraySum(nums, k));
	}

}
