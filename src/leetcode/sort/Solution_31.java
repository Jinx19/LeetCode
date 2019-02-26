package leetcode.sort;

/**
 * Created by mac on 2018/6/21.
 * LintCode 31 数组划分
 * 描述
 * <p>
 * 给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
 * <p>
 * 所有小于k的元素移到左边
 * 所有大于等于k的元素移到右边
 * <p>
 * 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
 */
public class Solution_31 {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int m = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                m = i;
                break;
            }
        }
        if (m == -1) {
            return 0;
        }
        // write your code here
        swap(nums, 0, m);
        int n = 0;
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] < k) {
                n++;
                swap(nums, i, n);
            } // a[k] >= p 时不做任何事情
        }
        swap(nums, 0, n);
        //最后交换轴心和a[m]
        return n; // 返回轴心坐标
    }
}
