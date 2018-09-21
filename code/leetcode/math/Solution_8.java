package math;

/**
 * Created by mac on 2018/6/23.
 * String to Integer (atoi)
 */
public class Solution_8 {
    private static final int max = Integer.MAX_VALUE / 10;

    public int myAtoi(String str) {
        int length = str.length();
        int i = 0;
        int sign = 1;
        int sum = 0;
        while (i < length && str.charAt(i) == ' ') i++;

        if (i < length && str.charAt(i) == '+') {
            sign = 1;
            i++;
        }else if (i < length && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        while (i < length && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if (sum > Integer.MAX_VALUE || sum == max && digit > 7) {
                if (sign == 1) return Integer.MAX_VALUE;
                if (sign == -1) return Integer.MIN_VALUE;
            }
            sum = sum * 10 + digit;
            i++;
        }

        return sign * sum;
    }

    public static void main(String[] args) {
        Solution_8 solution_8 = new Solution_8();
        solution_8.myAtoi("-91283472332");

    }
}
