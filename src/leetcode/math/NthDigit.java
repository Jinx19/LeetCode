package leetcode.math;

public class NthDigit {
    public int findNthDigit(int n) {
        long copyN = n;
        long i = 9;
        int j = 1;
        if(n <= 9){
            return n;
        }
        while(copyN > i * j){
            copyN = copyN - i*j;
            i *= 10;
            j++;
        }
        int ans = -1;
        long countOfNum = copyN / j;
        int remindOfNum = (int)copyN % j;
        long num = i/9 + countOfNum - 1;
        if(remindOfNum == 0){
            String str = "" + num;
            ans = str.charAt(j - 1) - '0';
        }else{
            num++;
            String str = "" + num;
            ans = str.charAt(remindOfNum - 1) - '0';
        }
        return ans;
    }

    public static void main(String[] args) {
        NthDigit nthDigit = new NthDigit();
        System.out.println(nthDigit.findNthDigit(2147483647));
    }
}
