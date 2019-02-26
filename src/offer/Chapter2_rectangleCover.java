package offer;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by mac on 2018/9/15.
 */
public class Chapter2_rectangleCover {
    public int target;
    public int count;

    public boolean isValid(int row, int col) {
        if (row < 0 || row >= 2) {
            return false;
        }

        if (col < 0 || col >= target) {
            return false;
        }

        return true;
    }

    public boolean check(boolean[][] visited, int row, int col, int N) {
        boolean hasBlock = false;
        if (isValid(row, col + 1) && !visited[row][col + 1]) {
            hasBlock = true;
        }
        if (isValid(row, col - 1) && !visited[row][col - 1]) {
            hasBlock = true;
        }
        if (isValid(row + 1, col) && !visited[row + 1][col]) {
            hasBlock = true;
        }
        if (isValid(row - 1, col) && !visited[row - 1][col]) {
            hasBlock = true;
        }
        return hasBlock;
    }

    public boolean helper(boolean[][] visited, int N) {
        if (N == 0) {
            count++;
            return true;
        }
        if (N < 0) {
            return false;
        }
        int row = -1, col = -1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < target; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    row = i;
                    col = j;
                    boolean exist = false;
                    if (check(visited, i, j, N)) {
                        if (isValid(row, col + 1) && !visited[row][col + 1]) {
                            visited[row][col + 1] = true;
                            if (!helper(visited, N - 1)) {
                                visited[row][col + 1] = false;
                            } else {
                                exist = true;
                            }
                        }
                        if (isValid(row, col - 1) && !visited[row][col - 1]) {
                            visited[row][col - 1] = true;
                            if (!helper(visited, N - 1)) {
                                visited[row][col - 1] = false;
                            } else {
                                exist = true;
                            }
                        }
                        if (isValid(row + 1, col) && !visited[row + 1][col]) {
                            visited[row + 1][col] = true;
                            if (!helper(visited, N - 1)) {
                                visited[row + 1][col] = false;
                            } else {
                                exist = true;
                            }
                        }
                        if (isValid(row - 1, col) && !visited[row - 1][col]) {
                            visited[row - 1][col] = true;
                            if (!helper(visited, N - 1)) {
                                visited[row - 1][col] = false;
                            } else {
                                exist = true;
                            }
                        }

                    }
                    if (!exist) {
                        visited[i][j] = false;
                    }
                }
            }
        }

        return false;
    }

    public int RectCover(int target) {
//        boolean[][] visited = new boolean[2][target];
//        count = 0;
//        this.target = target;
//        helper(visited, target);
//        return count;
        if(target == 0){
            return 0;
        }else if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    public static void main(String[] args) {
        Chapter2_rectangleCover rectangleCover = new Chapter2_rectangleCover();
        System.out.println(rectangleCover.RectCover(8));
    }
}
