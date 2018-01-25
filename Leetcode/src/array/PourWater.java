package array;

import java.util.Arrays;

public class PourWater {
	public static int findLeft(int[] heights, int K) {
		int best = K;
		while (K >= 1 && heights[K - 1] <= heights[K]) {
			if (heights[K - 1] < heights[K]) {
				K--;
				best = K;
			} else {
				K--;
			}
		}
		return best;
	}

	public static int findRight(int[] heights, int K) {
		int best = K;
		while (K < heights.length - 1 && heights[K + 1] <= heights[K]) {
			if (heights[K + 1] < heights[K]) {
				K++;
				best = K;
			} else {
				K++;
			}
		}
		return best;
	}

	public static int[] pourWater(int[] heights, int V, int K) {
		while (V-- > 0) {
			if (K > 0 && K < heights.length - 1) {
				int left = findLeft(heights, K);
				int right = findRight(heights, K);
				if (left != K) {
					heights[left]++;
				} else if (right != K) {
					heights[right]++;
				} else {
					heights[K]++;
				}
			} else if (K == 0) {
				int right = findRight(heights, K);
				if (right != K) {
					heights[right]++;
				} else {
					heights[K]++;
				}

			} else if (K == heights.length - 1) {
				int left = findLeft(heights, K);
				if (left != K) {
					heights[left]++;
				} else {
					heights[K]++;
				}
			}
		}
		return heights;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = { 1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1 };
		int V = 5;
		int K = 5;
		// int[] heights = { 2, 1, 1, 2, 1, 2, 2 };
		// int V = 4;
		// int K = 3;
		// int[] heights = { 3, 1, 3 };
		// int V = 5;
		// int K = 1;
		// int[] heights = { 14, 10, 10, 3, 13, 1, 2, 1, 2, 5 };
		// int V = 1;
		// int K = 0;
		// int[] heights = { 1, 2, 3, 4 };
		// int V = 2;
		// int K = 2;
		int[] array = pourWater(heights, V, K);
		for (int i : array) {
			System.out.println(i);
		}
	}

}
