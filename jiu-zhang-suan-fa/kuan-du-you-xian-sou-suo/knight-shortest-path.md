# Knight Shortest Path

```java
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    private boolean isvaild(int x, int y, int row,int col,boolean[][] grid){
        if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == true){
            return false;
        }
        
        return true;
    }
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        int[] x = {1,1,-1,-1,2,2,-2,-2};
        int[] y = {2,-2,2,-2,1,-1,1,-1};
        
        Map<Point,Boolean> visited = new HashMap<Point,Boolean>();

        Queue<Point> q = new LinkedList<>();
        q.add(source);
        int length = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int j = 0 ; j < size; j++){
                Point p = q.poll();
                if(p.x  == destination.x && p.y == destination.y){
                    return length;
                }
                if(visited.get(p) == null && !grid[p.x][p.y]){
                    grid[p.x][p.y] = true;
                    for(int i = 0 ; i < 8; i++){
                        if(isvaild(p.x + x[i],p.y + y[i],grid.length,grid[0].length,grid)){
                            Point newp = new Point(p.x + x[i],p.y + y[i]);
                            q.add(newp);
                        }
                    }
                }
            }
            length++;
        }
        return -1;
    }
}
```



