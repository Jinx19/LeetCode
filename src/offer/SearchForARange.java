package code.offer;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
            int[] ret = {-1,-1};

            if(nums == null || nums.length == 0){
                return ret;
            }
            int left = 0, right = nums.length;
            while(left < right){
                int mid = left + (right - left)/2;
                if(target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }

            if(nums[right] != target){
                return ret;
            }

            ret[0] = right;

            right = nums.length -1 ;

            while(left < right){
                int mid = left + (right - left)/2;
                if(target >= nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }

            ret[1] = right;
            return ret;
        }

    public static void main(String[] args) {
        SearchForARange  searchForARange = new SearchForARange();
        int[] nums = {5,7,7,8,8,10};
        int[] ret = searchForARange.searchRange(nums,8);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}
