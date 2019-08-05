package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public void permutation(int start, int length, Set<List<Integer>> allPermute, int[] nums){
        if(start == length - 1){
            List<Integer> list = new ArrayList<Integer>();
            for (int i : nums)
            {
                list.add(i);
            }
            allPermute.add(list);
            return;
        }

        for(int i = start; i < length; i++){
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            permutation(start + 1,length,allPermute,nums);
            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> allPermute = new HashSet<>();
        permutation(0,nums.length,allPermute,nums);
        return new ArrayList<>(allPermute);
    }
}
