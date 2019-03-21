package leetcode.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by mac on 2018/7/26.
 * Consecutive Numbers Sum
 */
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        for (int L = 0; L * (L + 1) < 2 * N; L++)
        {
            float a = (float) ((1.0 * N-(L * (L + 1)) / 2) / (L + 1));
            int b = (int)a;
            if(a - b == 0)
                count++;
        }
        return count;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int N = sum;
        for (int L = 1; L * (L + 1) < 2 * N; L++)
        {
            ArrayList item = new ArrayList<>();
            float a = (float) ((1.0 * N-(L * (L + 1)) / 2) / (L + 1));
            int b = (int)a;
            if(a - b == 0){
                for(int i = 0; i <= L; i++){
                    item.add(b + i);
                }
                ret.add(item);
            }
        }
        Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        };
        Collections.sort(ret,comparator);
        return ret;
    }

    public static void main(String[] args) {
        ConsecutiveNumbersSum solution_829 = new ConsecutiveNumbersSum();
        solution_829.FindContinuousSequence(9);
    }
}
