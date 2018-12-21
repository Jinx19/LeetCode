package leetcode.backtracking;

/**
 * Created by mac on 2018/9/15.
 * Word Search
 */
public class Solution_79 {
    private int row = 0,col = 0;
    private boolean isValid(int row,int col,int x, int y){
        if(x < 0 || x > row - 1){
            return false;
        }

        if(y < 0 || y > col - 1){
            return false;
        }
        return true;
    }
    private boolean isAdjacent(int row,int col,int x, int y,int[][] indicate,char[][] board,String word,int N){

        if(N == 0){
            return true;
        }

        char next = word.charAt(word.length() - N);
        int[] rowchange = {-1,1,0,0,};
        int[] colchange = {0,0,-1,1};

        for(int j = 0 ; j < 4; j++){
            if(isValid(row,col,x-1,y)&& board[x-1][y] == next){

                    indicate[x - 1][y] = 1;
                    if(isAdjacent(row,col,x - 1, y ,indicate,board,word,N - 1)){
                        return true;
                    }
                    indicate[x - 1][y] = 0;

            }
        }
        if(isValid(row,col,x-1,y)&& board[x-1][y] == next){
            if(indicate[x - 1][y] == 0){
                indicate[x - 1][y] = 1;
                if(isAdjacent(row,col,x - 1, y ,indicate,board,word,N - 1)){
                    return true;
                }
                indicate[x - 1][y] = 0;
            }
        }

        if(isValid(row,col,x+1,y)&& board[x+1][y] == next){
            if(indicate[x + 1][y] == 0){
                indicate[x + 1][y] = 1;
                if(isAdjacent(row,col,x + 1, y ,indicate, board,word,N - 1)){
                    return true;
                }
                indicate[x + 1][y] = 0;
            }

        }

        if(isValid(row,col,x,y-1)&& board[x][y - 1] == next){
            if(indicate[x][y - 1] == 0){
                indicate[x][y - 1] = 1;
                if(isAdjacent(row,col,x, y - 1,indicate, board,word,N - 1)){
                    return true;
                }
                indicate[x][y - 1] = 0;
            }

        }

        if(isValid(row,col,x,y+1) && board[x][y + 1] == next){
            if(indicate[x][y + 1] == 0){
                indicate[x][y + 1] = 1;
                if(isAdjacent(row,col,x, y + 1,indicate,board,word,N - 1)){
                    return true;
                }
                indicate[x][y + 1] = 0;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int[][] indicate = new int[row][col];

        int N = word.length();
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    indicate[i][j] = 1;
                    if(isAdjacent(row,col,i,j,indicate,board,word,N - 1)){
                        return true;
                    }else{
                        indicate[i][j] = 0;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Solution_79 solution = new Solution_79();
        if(solution.exist(board,word)){
            System.out.println("exist");
        }else {
            System.out.println("no exist");
        }
    }
}
