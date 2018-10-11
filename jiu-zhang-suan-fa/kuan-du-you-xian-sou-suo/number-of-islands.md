```java
class Solution {
    public int numIslands(char[][] grid) {
        //把1周围连接的土地都变成0
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    merge(grid,i,j);
                }
            }
        }
        return count;
    }
    
    public void merge(char[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1 || grid[i][j] == '0'){
            return;
        }
        
        grid[i][j] = '0';
        
        merge(grid,i-1,j);
        merge(grid,i+1,j);
        merge(grid,i,j-1);
        merge(grid,i,j+1);
    }
}
```



