package offer;

public class MaxGift {
    public int getMax(int[][] map){
        if(map == null || map[0] == null || map.length == 0||map[0].length == 0){
            return 0;
        }
        int row = map.length;
        int col = map[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = map[0][0];
        for(int i = 1 ; i < col ;i++){
            dp[0][i] = map[0][i] + dp[0][i-1];
        }
        for(int j = 1 ; j < row; j++){
            dp[j][0] = map[j][0] + dp[j - 1][0];
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }
        return dp[row - 1][col -1];
    }

    public static void main(String[] args) {
        int[][] maps = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        MaxGift maxGift = new MaxGift();
        System.out.println(maxGift.getMax(maps));
    }
}
