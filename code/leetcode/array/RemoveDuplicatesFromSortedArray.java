package leetcode.array;

public class RemoveDuplicatesFromSortedArray {
	//O(n)
	public int removeDuplicates(int[] nums) {
		if (nums == null)
			return -1;
		if (nums.length <= 1)
			return nums.length;

		int newindex = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[newindex]) {
				newindex++;
				nums[newindex] = nums[i];
			}
		}
		return newindex + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
