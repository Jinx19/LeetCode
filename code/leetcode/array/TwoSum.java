package code.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	class Pair implements Comparable<Pair> {
		public int first;
		public int second;

		public Pair() {
			// TODO Auto-generated constructor stub
			first = -1;
			second = -1;
		}

		public Pair(int fisrt, int second) {
			this.first = fisrt;
			this.second = second;
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

	// O(n)
	public int[] towSumTwoPoint(int[] numbers, int target) {
		Pair[] data = new Pair[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			data[i] = new Pair(numbers[i], i + 1);
		}
		Arrays.sort(data);
		int left = 0, right = numbers.length - 1;
		if (data[left].first + data[right].first > target) {
			right--;
		} else if (data[left].first + data[right].first == target) {
			return new int[] { Math.min(data[left].second, data[right].second),
					Math.max(data[left].second, data[right].second) };
		} else {
			left++;
		}
		return new int[] { 0, 0 };
	}

	// O(n)
	public static int[] twoSumHashMap(int[] numbers, int target) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			hashMap.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			int complement = target - numbers[i];
			if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
				return new int[] { i + 1, hashMap.get(complement) + 1 };
			}
		}
		throw new IllegalArgumentException("No twoSum Solution!");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;
		TwoSum ts = new TwoSum();
		ts.towSumTwoPoint(numbers, target);
		int[] result = twoSumHashMap(numbers, target);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
