package leetcode.string;

/**
 * Created by mac on 2018/6/21.
 * Reverse String II
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 */
public class Solution_541 {
    public void reverseK(int start, int end, char[] s, int k) {
        int mid = k / 2;
        for (int i = 0; i < mid; i++) {
            char temp = s[start + i];
            s[start + i] = s[end - i];
            s[end - i] = temp;
        }
    }

    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int i = 0;
        for (; i + 2 * k < s.length(); ) {
            reverseK(i, i + k - 1, str, k);
            i = i + 2 * k ;
        }
        if(str.length - i >= k){
            reverseK(i, i + k - 1, str, k);
        }else{
            reverseK(i, str.length - 1, str, str.length - i);
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        Solution_541 solution_541 =  new Solution_541();
        String str = solution_541.reverseStr("abcdefg",2);
        System.out.println(str);
    }
}
