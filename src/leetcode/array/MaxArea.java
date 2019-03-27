package leetcode.array;

public class MaxArea {
    public int maxArea(int[] nums){
        if(nums == null){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0],nums[1]) * 2;
        }
        int start = 0, end = nums.length - 1;
        int max = Integer.MIN_VALUE;
        while(start <= end){
            int temp = (end - start + 1) * Math.min(nums[start],nums[end]);
            max = Math.max(temp,max);
            if(nums[start] < nums[end]){
                start++;
            }else{
                end--;
            }
        }
        return max;
    }
}
