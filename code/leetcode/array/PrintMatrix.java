package leetcode.array;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mac on 2018/7/16.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
//        if (matrix.length == 1) {
//            for (int i : matrix[0]) {
//                list.add(i);
//            }
//        } else if (matrix[0].length == 1) {
//            for (int i = 0; i < matrix.length; i++) {
//                list.add(matrix[i][0]);
//            }
//        }
        int[] rows = {0, matrix.length - 1};
        int[] cols = {0, matrix[0].length - 1};
        int i;
        while (rows[1] > rows[0] && cols[1] > cols[0]) {
            for (i = cols[0]; i < cols[1]; i++) {
                list.add(matrix[rows[0]][i]);
            }

            for (i = rows[0]; i < rows[1]; i++) {
                list.add(matrix[i][cols[1]]);
            }

            for (i = cols[1]; i > cols[0]; i--) {
                list.add(matrix[rows[1]][i]);
            }

            for (i = rows[1]; i > rows[0]; i--) {
                list.add(matrix[i][cols[0]]);
            }
            rows[0]++;
            rows[1]--;
            cols[0]++;
            cols[1]--;
        }
        if(rows[1] == rows[0] && cols[1] == cols[0]){
            list.add(matrix[rows[0]][cols[0]]);
        }else if(cols[1] == cols[0] && rows[1] > rows[0]){
            for(i = rows[0]; i <= rows[1] ; i++){
                list.add(matrix[i][cols[1]]);
            }
        }else if(rows[0] == rows[1] && cols[1] > cols[0]){
            for(i = cols[0]; i <= cols[1]; i++){
                list.add(matrix[rows[0]][i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        PrintMatrix pm = new PrintMatrix();
        int[][] matrix = {{1,2,3,4,5}};
        ArrayList<Integer> list = pm.printMatrix(matrix);
        for(int i : list){
            System.out.println(i);
        }
    }
}
