package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    String ans = "";
    ArrayList<String> str = new ArrayList<>();
    public void helper(int[] nums,int k,int n,int start,int count){
        if(start == nums.length - 1){
            StringBuffer sb = new StringBuffer();
            for(int i : nums){
                sb.append(Integer.toString(i));
            }
            str.add(sb.toString());
            return;
        }
        for(int i = start; i < n; i++){
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            helper(nums,k,n,start + 1,count);
//            if(helper(nums,k,n,start + 1,count)){
//                return true;
//            }else{
                temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
            }
    }
//        return false;

    public List<String > getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i< n; i++){
            nums[i] = i+1;
        }
        for(int i = 0; i < n; i++){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            helper(nums,k,n,1,0);
//            if(helper(nums,k,n,0,0)){
//                return ans;
//            }else{
                temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;
            }
        return str;
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        List<String> str = permutationSequence.getPermutation(3,3);
        for(String string:str){
            System.out.println(str);
        }
    }
}
