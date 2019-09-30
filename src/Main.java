package src;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Main {
    public static int count_x(int[][] all,int x) {
        int max_h = Integer.MIN_VALUE;
        for(int i = 0; i < all.length; i++){
            if(all[i][0] == x){
                max_h = Math.max(all[i][1],max_h);
            }
        }
        return max_h;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int m = in.nextInt();
            int count = 0;
            int[][] all = new int[m][2];
            int max_x = 0;
            int max_y = 0;
            int x = in.nextInt();
            int y = in.nextInt();
            max_x = x;
            max_y = y;
            for(int j = 0; j < m; j++){
                x = in.nextInt();
                y = in.nextInt();
                if(x <= max_x && y <= max_y){
                    continue;
                }
                all[j][0] = x;
                all[j][1] = y;
                max_x = Math.max(x,max_x);
                max_y = Math.max(y,max_y);
            }
            for(int j = 1; j <= max_x; j++){
                count += Main.count_x(all,j);
            }
            System.out.println(count);
        }

    }
}