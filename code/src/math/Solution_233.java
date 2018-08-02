package math;

/**
 * Created by mac on 2018/7/17.
 * Number of Digit One
 */
public class Solution_233 {
    private int NumberOf1(String str, int index) {
        if (str == null || str.charAt(index) < '0' || str.charAt(index) > '9' || index == str.length()) {
            return 0;
        }

        int first = str.charAt(index) - '0';
        int length = str.length() - index;
        if (length == 1 && first == 0) {
            return 0;
        }

        if (length == 1 && first > 0) {
            return 1;
        }

        double numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = Math.pow(10, length - 1);
        } else if (first == 1) {
            numFirstDigit = Integer.valueOf(str.substring(index + 1)) + 1;
        }
        double numOtherDigits = first * (length - 1) * Math.pow(10, length - 2);

        int numRecursive = NumberOf1(str, index + 1);

        return (int) (numFirstDigit + numOtherDigits + numRecursive);
    }

    public int countDigitOne(int n) {
        String str = String.valueOf(n);
        System.out.println(str);
        return NumberOf1(str, 0);
    }

    public static void main(String[] args) {
        Solution_233 solution_233 = new Solution_233();
        System.out.println(solution_233.countDigitOne(233332));
    }
}
