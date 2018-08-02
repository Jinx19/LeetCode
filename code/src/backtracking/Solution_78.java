package backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/6/26.
 */
public class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int step = 0;
        List<Integer> item = new ArrayList<>();
        helper(nums, res, item, step);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> item, int step) {
        if (step == nums.length) {
            res.add(new ArrayList<>(item));
            return;
        }
        item.add(nums[step]);
        helper(nums, res, item, step + 1);
        item.remove(item.size() - 1);
        helper(nums, res, item, step + 1);
    }

    public static void main(String[] args) {
        Solution_78 solution_78 = new Solution_78();
        int[] nums = {1,2,3};
        solution_78.subsets(nums);

        for(List<Integer> list : solution_78.subsets(nums)){
            for(int i : list){
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
