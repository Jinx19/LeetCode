package array;

/**
 * Created by mac on 2018/6/29.
 * Trapping Rain Water
 */
public class Solution_42 {
    public boolean iflowest(int[] height, int pos) {
        return height[pos + 1] >= height[pos] && height[pos - 1] >= height[pos];
    }

    public int getMax(int[] height, int start, int end) {
        int max = height[start];
        int res = start;
        for (int i = start; i < end; i++) {
            if (max < height[i]) {
                res = i;
                max = height[i];
            }
        }
        return res;
    }

    public int trap(int[] height) {
        int allWater = 0;
        int start = 0;
        int end = height.length;
        for (int i = 1; i < height.length - 1; i++) {
            if (!iflowest(height, i))
                continue;

            int left = getMax(height, start, i);
            int right = getMax(height, i + 1, end);
            int curDep = Math.min(height[left], height[right]);

            if(height[left] < height[right]){
                int pos = left;
                while (pos++ < right) {
                    if (height[pos] < curDep) {
                        allWater += curDep - height[pos];
                    } else {
                        curDep = height[pos];
                    }
                }
            }else{
                int pos = right - 1;
                while (pos > left){
                    if (height[pos] < curDep) {
                        allWater += curDep - height[pos];
                    } else {
                        curDep = height[pos];
                    }
                    pos--;
                }
            }
            start = right;
            i = right;
        }

        return allWater;
    }

    public static void main(String[] args) {
        Solution_42 trappingRainWater = new Solution_42();
        int[] nums = {4,3,3,9,3,0,9,2,8,3};
        System.out.println(trappingRainWater.trap(nums));
    }

}
