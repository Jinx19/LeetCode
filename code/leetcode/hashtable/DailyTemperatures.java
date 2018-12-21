package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		Map<Integer, Integer> map = new HashMap<>();
 		Stack<Integer> stackforval = new Stack<>();
		Stack<Integer> stackforindex = new Stack<>();
		for (int i = 0; i < temperatures.length; i++) {
			while (!stackforval.isEmpty() && stackforval.peek() < temperatures[i]) {
				stackforval.pop();
				int index = stackforindex.pop();
				map.put(index, i - index);
			}
			stackforval.push(temperatures[i]);
			stackforindex.push(i);
		}

		for (int i = 0; i < temperatures.length - 1; i++) {
			temperatures[i] = map.getOrDefault(i, 0);
		}
		temperatures[temperatures.length - 1] = 0;
		return temperatures;
	}

	public static void main(String[] args) {
		DailyTemperatures dt = new DailyTemperatures();
		int[] temperatures = { 55, 38, 53, 81, 61, 93, 97, 32, 43, 78 };
		for (int i : dt.dailyTemperatures(temperatures)) {
			System.out.println(i);
		}
	}
}
