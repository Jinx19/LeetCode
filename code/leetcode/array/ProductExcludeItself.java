package leetcode.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductExcludeItself {
	public static List<Long> productExcludeItself(List<Integer> nums) {
		// write your code here
		final int numsSize = nums.size();
		long[] result = new long[numsSize];
		for (int i = 0; i < numsSize; i++) {
			result[i] = 1l;
		}
		for (int i = 1; i < numsSize; ++i) {
			result[i] = result[i - 1] * nums.get(i - 1);
		}

		long temp = 1;
		for (int i = numsSize - 1; i >= 0; --i) {
			result[i] = result[i] * temp;
			temp *= nums.get(i);
		}
		List<Long> array = new ArrayList<>();
		for (long i : result) {
			array.add(i);
		}
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		List<Long> result = productExcludeItself(nums);
		Iterator<Long> it = result.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
