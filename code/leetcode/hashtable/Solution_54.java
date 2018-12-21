package leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author mac Spiral Matrix
 * 
 *         Given a matrix of m x n elements (m rows, n columns), return all
 *         elements of the matrix in spiral order.
 *
 */
public class Solution_54 {
	class position {
		public int x;
		public int y;

	}

	public void helper(int[][] matrix, int x, int y, int row, int col, List<Integer> result, boolean flag) {
		if (row == 0 || col == 0) {
			return;
		}

		if (flag) {
			for (int i = y; i < y + col; i++) {
				result.add(matrix[x][i]);
			}

			for (int i = x + 1; i < x + row; i++) {
				result.add(matrix[i][y + col - 1]);
			}
			x = x + row - 1;
			y = y + col - 2;
			row--;
			col--;
			helper(matrix, x, y, row, col, result, false);
		} else {
			for (int i = y; i > y - col; i--) {
				result.add(matrix[x][i]);
			}

			for (int i = x - 1; i > x - row; i--) {
				result.add(matrix[i][y - col + 1]);
			}
			x = x - row + 1;
			y = y - col + 2;
			row--;
			col--;
			helper(matrix, x, y, row, col, result, true);
		}
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return result;
		}
		if (matrix.length == 1) {
			for (int i = 0; i < matrix[0].length; i++) {
				result.add(matrix[0][i]);
			}
			return result;
		}

		if (matrix[0].length == 1) {
			for (int i = 0; i < matrix.length; i++) {
				result.add(matrix[i][0]);
			}
			return result;
		}
		
		helper(matrix, 0, 0, matrix.length, matrix[0].length, result, true);
		return result;
	}

	public static void main(String[] args) {
		Solution_54 solution = new Solution_54();
		int[][] matrix = { { 2, 5, 8 }, { 4, 0, -1 } };
		List<Integer> result = solution.spiralOrder(matrix);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
