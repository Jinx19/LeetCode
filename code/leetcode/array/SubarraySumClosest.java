package leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

//http://www.lintcode.com/en/problem/subarray-sum-closest/#
/**
 * 问：为什么需要一个 (0,0) 的初始 Pair? 答： 我们首先需要回顾一下，在 subarray 这节课里，我们讲过一个重要的知识点，叫做
 * Prefix Sum 比如对于数组 [1,2,3,4]，他的 Prefix Sum 是 [1,3,6,10] 分别表示
 * 前1个数之和，前2个数之和，前3个数之和，前4个数之和 这个时候如果你想要知道 子数组 从下标 1 到下标 2 的这一段的和(2+3)，就用前 3个数之和
 * 减去 前1个数之和 = PrefixSum[2] - PrefixSum[0] = 6 - 1 = 5 你可以看到这里的 前 x
 * 个数，和具体对应的下标之间，存在 +-1 的问题 第 x 个数的下标是 x - 1，反之 下标 x 是第 x + 1 个数 那么问题来了，如果要计算
 * 下标从 0~2 这一段呢？也就是第1个数到第3个数，因为那样会访问到 PrefixSum[-1] 所以我们把 PrefixSum
 * 整体往后面移动一位，把第0位空出来表示前0个数之和，也就是0. => [0,1,3,6,10] 那么此时就用 PrefixSum[3] -
 * PrefixSum[0] ，这样计算就更方便了。 此时，PrefixSum[i] 代表 前i个数之和，也就是 下标区间在 0 ~ i-1 这一段的和
 * 
 * 那么回过头来看看，为什么我们需要一个 (0,0) 的 pair 呢？ 因为 这个 0,0 代表的就是前0个数之和为0 一个 n 个数的数组， 变成了
 * prefix Sum 数组之后，会多一个数出来
 */
public class SubarraySumClosest {
	class Pair implements Comparable<Pair> {
		public int first;
		public int second;

		public Pair() {
			// TODO Auto-generated constructor stub
			first = 0;
			second = 0;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if (first == o.first) {
				return second - o.second;
			} else {
				return first - o.first;
			}
		}
	}

	public int[] subarraySumClosest(int[] nums) {
		// write your code here
		int[] result = new int[2];
		if (nums == null)
			return nums;
		final int LENGTH = nums.length;
		Pair[] sumIndex = new Pair[LENGTH + 1];
		sumIndex[0] = new Pair();
		for (int i = 0; i < LENGTH; i++) {
			sumIndex[i + 1] = new Pair();
			sumIndex[i + 1].first = sumIndex[i].first + nums[i];
			sumIndex[i + 1].second = i + 1;
		}
		Arrays.sort(sumIndex);

		int minDiff = Integer.MAX_VALUE;
		int closestIndex = 1;
		
		//两个子数组和差值绝对值越小，说明两个子数组之间的差集数组的值越接近0
		for (int i = 1; i < LENGTH + 1; i++) {
			int sumDiff = Math.abs(sumIndex[i].first - sumIndex[i - 1].first);
			if (minDiff > sumDiff) {
				minDiff = sumDiff;
				closestIndex = i;
			}
		}
		//前半部分数组的最后一个数不包括，而后半部分数组的最后一个数包括进去了，故下标要减去1
		int leftIndex = Math.min(sumIndex[closestIndex - 1].second, sumIndex[closestIndex].second);
		int rightIndex = -1 + Math.max(sumIndex[closestIndex - 1].second, sumIndex[closestIndex].second);

		result[0] = leftIndex;
		result[1] = rightIndex;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -3, 1, 1, -3, 5 };
		SubarraySumClosest ssc = new SubarraySumClosest();
		int[] result = ssc.subarraySumClosest(nums);
		System.out.println(result[0] + " " + result[1]);

	}

}
