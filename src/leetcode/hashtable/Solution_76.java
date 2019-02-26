package leetcode.hashtable;

/**
 * Created by mac on 2018/6/23.
 */
public class Solution_76 {

    public String minWindow(String s, String t) {
        int[] map = new int[256];
        char[] sChars = s.toCharArray();
        int counter = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
            ++counter;
        }
        int head = 0, tail = 0, front = 0, len = Integer.MAX_VALUE;
        while (tail < sChars.length) {
            if (map[sChars[tail++]]-- > 0) {
                --counter;
            }
            while (counter == 0) {
                if (tail - head < len) {
                    len = tail - (front = head);
                }
                if (map[sChars[head++]]++ >= 0) {
                    ++counter;
                }
            }
        }


        return len == Integer.MAX_VALUE ? "" : s.substring(front, front + len);

    }


    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE/10);
    }
}
