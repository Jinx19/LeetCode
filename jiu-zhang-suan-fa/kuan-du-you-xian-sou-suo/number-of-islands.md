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

# 写出四个方向

```java
class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


int[] directionX = {0, 1, -1, 0};
int[] directionY = {1, 0, 0, -1};

for(int i = 0 ; i < 4 ; i++){
    x + directionX[i]
    y + directionY[i]
}

private boolean inBound(Coordinate coor, boolean[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
}
```



