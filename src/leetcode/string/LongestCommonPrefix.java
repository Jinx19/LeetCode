package leetcode.string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length,longest = 0;
        StringBuffer sb = new StringBuffer();
        while(true) {
            if(longest >= strs[0].length()){
                break;
            }
            char common = strs[0].charAt(longest);
            boolean isPrefix = true;
            for (int i = 1; i < n; i++) {
                if(longest >= strs[i].length() || strs[i].charAt(longest) != common){
                    isPrefix = false;
                    break;
                }
            }
            if(isPrefix){
                sb.append(common);
                longest++;
            }else{
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String prefix = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
