package leetcode.bit;

public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0,zeors = 0,bitLength = 0;
        while(n != 0 && (n&1) == 0){
            n = n >> 1;
            bitLength++;
        }
        if(n == 0){
            return 0;
        }
        n = n >> 1;
        bitLength++;
        ans = 1;
        while(n != 0){
            while(n != 0 && (n&1) == 0){
                zeors++;
                n = n >>> 1;
                bitLength++;

            }
            while(zeors > 0){
                ans = ans << 1;
                zeors--;
            }
            if(n != 0){
                ans = ans << 1;
                ans = ans ^ 1;
                n = n >>> 1;
                bitLength++;
            }
        }
        while(bitLength < 32){
            ans = ans << 1;
            bitLength++;
        }
        return ans;
    }
}
