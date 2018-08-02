package backtracking;

public class Solution_526 {
	static boolean isFollowed(int i, int position, int nums[]) {
		return (nums[i] == -1 && (i % position == 0 || position % i == 0));
	}

	static int solveUtil(int position, int nums[]) {
		if (position == nums.length) {
			return 1;
		}
		int sum = 0;
		for (int j = 1; j < nums.length; j++) {
			if (isFollowed(j, position, nums)) {
				nums[j] = j;
				sum += solveUtil(position + 1,nums);
				nums[j] = -1;
			}
		}
		return sum;
	}

	public static int countArrangement(int N) {
		int[] nums = new int[N + 1];
		for (int i = 1; i < nums.length; i++) {
			nums[i] = -1;
		}
		
		return solveUtil(1,nums);
	}

	public static void main(String[] args) {
		System.out.println(Solution_526.countArrangement(7));
	}
}
