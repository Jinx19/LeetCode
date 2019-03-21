package leetcode.string;

public class CountAndSay {
    public String countAndSay(int n) {
        String ans = "1";
        n--;

        while (n > 0) {
            int m = ans.length(), count = 1;
            char pre = ans.charAt(0);
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < m; i++) {
                while (i + 1 < m && pre == ans.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append("" + count);
                sb.append("" + pre);
                if(i + 1 < m){
                    pre = ans.charAt(i + 1);
                    count = 1;
                }
            }

            ans = sb.toString();
            sb.setLength(0);
            n--;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(5));
    }
}
