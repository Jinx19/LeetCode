package leetcode.array;

public class Solution_152 {
	public int maxProduct(int[] nums) {
		int maxLocal = nums[0];
		int minLocal = nums[0];
		int global = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = maxLocal;
			maxLocal = Math.max(Math.max(nums[i] * maxLocal, nums[i]), nums[i] * minLocal);
			minLocal = Math.min(Math.min(nums[i] * temp, nums[i]), nums[i] * minLocal);
			global = Math.max(global, maxLocal);
		}
		return global;
	}

	public static void main(String[] args) {
		int[] nums = {-1,0,-2};
		Solution_152 solution = new Solution_152();
		solution.maxProduct(nums);
	}
}
