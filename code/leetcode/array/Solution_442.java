package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_442 {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 2) {
				list.add(entry.getKey());
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Solution_442 solution_442 = new Solution_442();
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> list = solution_442.findDuplicates(nums);
		for(int i : list) {
			System.out.println(i);
		}
		
	}
}
