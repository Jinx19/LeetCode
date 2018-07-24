package string;

/**
 * Created by mac on 2018/6/21.
 * Reverse Words in a String III
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class Solution_557 {
    public void reverse(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        char[] words = s.toCharArray();
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == ' ') {
                reverse(words, start, i - 1);
                start = i + 1;
            }
        }
        reverse(words, start, words.length - 1);
        return String.valueOf(words);

    }


    public static void main(String[] args) {
        Solution_557 solution_557 = new Solution_557();
        System.out.println(solution_557.reverseWords("Let's take LeetCode contest"));
    }
}
