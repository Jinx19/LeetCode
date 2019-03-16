package leetcode.binarysearch;

public class SearchA2DMatrixII {
    private int binarysearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        for(int i = 0 ; i < matrix.length; i++){
            if (binarysearch(matrix[i], target) != -1) {
                return true;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean ans = searchA2DMatrixII.searchMatrix(matrix,20);
        System.out.println(ans);
    }
}
