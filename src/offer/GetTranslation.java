package offer;

public class GetTranslation {
    public int translation(int number){
        if(number < 0){
            return 0;
        }
        String numberInString = "" + number;
        return helper(numberInString);
    }

    private int helper(String numberInString) {
        int lng = numberInString.length();
        int[] dp = new int[lng];
        int count = 0;

        for(int i = lng - 1; i >= 0; i--){
            count = 0;
            if(i < lng - 1){
                count = dp[i+1];
            }else{
                count = 1;
            }

            if(i <lng - 1){
                int digit1 = numberInString.charAt(i) - '0';
                int digit2 = numberInString.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if(converted >= 10 && converted <= 25){
                    if( i < lng - 2){
                        count += dp[i + 2];
                    }else{
                        count += 1;
                    }
                }
                dp[i] = count;
            }
        }
        return dp[0];
    }
}
