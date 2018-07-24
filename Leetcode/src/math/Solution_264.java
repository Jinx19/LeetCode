package math;

/**
 * Created by mac on 2018/7/17.
 * Ugly Number II
 */
public class Solution_264 {
    public int nthUglyNumber(int n) {
        if(n <= 0){
            return 0;
        }
        int i2= 0, i3 = 0,i5 = 0;
        int[] pUglyNumbers = new int[n];
        pUglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        int[] pMultiply2 = pUglyNumbers;
        int[] pMultiply3 = pUglyNumbers;
        int[] pMultiply5 = pUglyNumbers;

        while(nextUglyIndex < n){
            int min = Math.min(Math.min(pMultiply2[i2] * 2,pMultiply3[i3] * 3),pMultiply5[i5] * 5);
            pUglyNumbers[nextUglyIndex] = min;
            while (pMultiply2[i2]* 2 <= pUglyNumbers[nextUglyIndex]){
                i2++;
            }
            while (pMultiply3[i3]* 3 <= pUglyNumbers[nextUglyIndex]){
                i3++;
            }
            while (pMultiply5[i5]* 5 <= pUglyNumbers[nextUglyIndex]){
                i5++;
            }
            nextUglyIndex++;
        }
        return pUglyNumbers[nextUglyIndex - 1];
    }

    public static void main(String[] args) {
        Solution_264 solution_264 = new Solution_264();
        System.out.println(solution_264.nthUglyNumber(5));
    }
}
