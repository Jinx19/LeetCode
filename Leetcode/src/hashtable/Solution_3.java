package hashtable;

/**
 * Created by mac on 2018/7/8.
 * Longest Substring Without Repeating Characters
 */
public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        String str = "pwwkew";

        solution.lengthOfLongestSubstring(str);

    }
}
