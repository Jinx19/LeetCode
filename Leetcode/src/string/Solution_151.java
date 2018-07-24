package string;


/**
 * 151. Reverse Words in a String
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 *
 * @author mac
 */
public class Solution_151 {
    public void reverse(char[] s, int start, int end) {
        int mid = (end - start + 1) / 2;
        for (int i = 0; i < mid; i++) {
            char temp = s[start + i];
            s[start + i] = s[end - i];
            s[end - i] = temp;
        }
    }

    public String reverseWords(String s) {
        int start = 0,end = s.length() - 1;
        while (start <= end){
            if(s.charAt(start) != ' ' && s.charAt(end) != ' '){
                break;
            }else{
                if(s.charAt(start) == ' '){
                    start++;
                }

                if(s.charAt(end) == ' '){
                    end--;
                }
            }
        }
        if(start > end){
            return "";
        }
        char[] words = s.substring(start,end + 1).toCharArray();

        reverse(words, 0, words.length - 1);

        start = 0;
        end = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == ' ') {
                reverse(words, start, end - 1);
                start = i + 1;
            }

            if (i == words.length - 1) {
                reverse(words, start, i);
                break;
            }
            end++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < words.length; i++){
            if(words[i] != ' '){
                sb.append(words[i]);
            }else if(words[i+1] != ' '){
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }

    public String reverseWords2(String s){
        if(s == null || s.equals("")){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        String[] arrays = s.split(" ");

        for(int i = arrays.length - 1; i >= 0; i--){
            if(!arrays[i].equals("")){
                if(sb.length() > 0){
                    sb.append(" ");
                }

                sb.append(arrays[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_151 solution = new Solution_151();

        String str = solution.reverseWords2("   a      b  ");

        System.out.println(str);
    }
}
