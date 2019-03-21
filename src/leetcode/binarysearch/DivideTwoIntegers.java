package leetcode.binarysearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int signForDividend = dividend < 0 ? -1 : 1, signForDivisor = divisor < 0 ? -1 : 1;
        long positiveDividend = ((long) dividend) * signForDividend;
        long positiveDivisor = ((long) divisor) * signForDivisor;
        int signForAns = signForDividend * signForDivisor;
        if (positiveDivisor > positiveDividend) {
            return 0;
        }
        if (positiveDivisor == positiveDividend) {
            return signForAns;
        }
        if (positiveDivisor == 1) {
            long ans = positiveDividend * signForAns;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) ans;
            }
        }
        long start = 1, end = positiveDividend;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long temp = mid * positiveDivisor;
            if (positiveDividend - temp >= 0 && positiveDividend - temp < positiveDivisor) {
                return (int) (signForAns * mid);
            } else if (mid * positiveDivisor > positiveDividend) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
