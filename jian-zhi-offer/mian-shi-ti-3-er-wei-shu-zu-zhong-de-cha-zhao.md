# 二维数组中的查找

LeetCode原题:  [74.Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/description/)

Write an efficient algorithm that searches for a value in an_m_x_n_matrix. This matrix has the following properties:

* Integers in each row are sorted from left to right.
* The first integer of each row is greater than the last integer of the previous row.

首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束；如果该数字大于要查找的数字，剔除这个数字所在的列；如果该数字小于要查找的数字，剔除这个数字所在的行。也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空.

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length,cols = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[rows - 1][cols - 1]){
            return false;
        }
        int row = 0, col = cols - 1;
        boolean search = false;
        while(row < rows && col >= 0){
            if(matrix[row][col] == target){
                search = true;
                break;
            }else if(matrix[row][cols - 1] < target){
                row++;
                continue;
            }else{
                col--;
                continue;
            }
        }
        return search;                                                                                                                                                                                                                                                                                         
    }              
}
```

另外 因为The first integer of each row is greater than the last integer of the previous row. 因此也可以把整个二维矩阵看做一个有序数组,对于有序数组的搜索,可以使用二分搜索.

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null){
            return false;
        }
        int row = matrix.length,col = matrix[0].length;
        
        int lb = 0,ub = row * col;
        while(lb < ub){
            int mid = lb + (ub - lb)/2;
            if(matrix[mid/col][mid%col] < target){
                lb = mid + 1;
            }else{
                if(matrix[mid/col][mid%col] == target){
                    return true;
                }
                ub = mid;   
            }
        }
        return false;
    }
}
```



