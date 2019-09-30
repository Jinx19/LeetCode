package src.leetcode.binarysearch;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums == null ? 0:nums.length;
        if(n == 0){
            return -1;
        }

        if(n == 1){
            return 0;
        }

        if(n == 2){
            return nums[0] > nums[1]?0:1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start +(end - start)/2;
            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]){
                return mid;
            }else if(nums[mid] <nums[mid + 1]){
                start = mid;
            }else{
                end = mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/jintan/Public/GitHub/LeetCode/src/leetcode/binarysearch/test.txt");
        Scanner scanner = new Scanner(file);
        FindPeakElement findPeakElement = new FindPeakElement();
        while (scanner.hasNext()){
            String[] strs = scanner.nextLine().split(" ");
            int[] nums = new int[strs.length];
            for(int i = 0 ; i < strs.length ;i++){
                nums[i] = Integer.valueOf(strs[i]);
            }
        }
    }

}
