package lintcode;

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = {-1, -1};
        if (A == null || A.length == 0) {
            return result;
        }
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(A[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int index1 = A[left] == target ? left : -1;

        left = 0;
        right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(A[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int index2 = A[right] == target ? left : -1;

        if (index1 != -1 && index2 != -1) {
            result[0] = index1;
            result[1] = index2;
        } else if (index1 != -1) {
            result[0] = index1;
            result[1] = index1;
        } else if (index2 != -1) {
            result[0] = index2;
            result[1] = index2;
        }
        return result;
    }

    public static void main(String[] args) {
        SearchForARange searchForARange = new SearchForARange();
        int[] nums = {5,5,5,5,5,5,5};
        searchForARange.searchRange(nums,5);
    }
}


