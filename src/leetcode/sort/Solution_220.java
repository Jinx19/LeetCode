package leetcode.sort;

import java.util.HashMap;

public class Solution_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
           int index = nums[i]/(t+1);
           if(nums[i] < 0){
               nums[i] -= 1;
           }
           if(hs.containsKey(index)) {
               return true;
           }

           if(hs.containsKey(index - 1)&& Math.abs(hs.get(index - 1) - nums[i]) < t + 1){
               return true;
           }

           if(hs.containsKey(index + 1) && Math.abs(hs.get(index+1)-nums[i]) < t + 1){
               return true;
           }

           hs.put(index,nums[i]);
           if(i > k){
               hs.remove(nums[i-k]/(t+1));
           }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(-3/5);
    }
}
