package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 包裹黑色像素点的最小矩形
 * 一个由二进制矩阵表示的图，0 表示白色像素点，1 表示黑色像素点。黑色像素点是联通的，即只有一块黑色区域。
 * 像素是水平和竖直连接的，给一个黑色像素点的坐标 (x, y) ，返回囊括所有黑色像素点的矩阵的最小面积。
 *
 * 样例
 * 举个例子，给一个图
 *
 * [
 *   "0010",
 *   "0110",
 *   "0100"
 * ]
 *
 * 并且给出x = 0, y = 2, 则返回 6。
 */
public class Solution_600 {
    public class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private int count = 1;
    private int[] xd = {1,-1,0,0};
    private int[] yd = {0,0,1,-1};
    private int[] area;
    private boolean[][] marked;
    private int m;
    private int n;
    private boolean valid(int row,int col,int x, int y){
        if(x < 0 || y < 0 || x >= row || y >= col){
            return false;
        }

        return !marked[x][y];
    }
    private void dfs(char[][] image,int x,int y){
        for(int i = 0 ; i < 4; i++){
            int nx = x + xd[i];
            int ny = y + yd[i];
            if(valid(m,n,nx,ny) && image[nx][ny] == '1'){
                marked[nx][ny] = true;
                if(area[0] < nx){
                    area[0] = nx;
                }

                if(area[1] > nx){
                    area[1] = nx;
                }

                if(area[2] < ny){
                    area[2] = ny;
                }

                if(area[3] > ny){
                    area[3] = ny;
                }
                dfs(image,nx,ny);
            }
        }
    }
    public int minArea(char[][] image, int x, int y) {
        // write your code here

        m = image.length;
        n = image[0].length;

        marked  = new boolean[m][n];
        marked[x][y] = true;
        area = new int[4];
        area[0] = x;
        area[1] = x;
        area[2] = y;
        area[3] = y;
        dfs(image,x,y);

        return (area[0] - area[1] + 1)*(area[2] - area[3] + 1);
    }

    public int minAreaBFS(char[][] image, int x, int y) {
        // write your code here

        m = image.length;
        n = image[0].length;

        marked  = new boolean[m][n];
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        Point source = new Point(x,y);

        Queue<Point> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            Point curr = q.poll();
            marked[curr.x][curr.y] = true;
            minX = Math.min(minX, curr.x);
            minY = Math.min(minY, curr.y);
            maxX = Math.max(maxX, curr.x);
            maxY = Math.max(maxY, curr.y);

            for(int i = 0 ; i < 4; i++){
                int nx = curr.x + xd[i];
                int ny = curr.y + yd[i];
                if(valid(m,n,nx,ny) && image[nx][ny] == '1'){
                    q.add(new Point(nx,ny));
                }
            }

        }
        int width = maxY - minY + 1;
        int height = maxX - minX + 1;
        return width * height;
    }

    public static void main(String[] args) {
        char[][] images = {{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
        Solution_600 solution_600 = new Solution_600();
        int area =  solution_600.minAreaBFS(images,0,2);
        System.out.println(area);
    }
}
