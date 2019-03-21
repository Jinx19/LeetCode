package leetcode.binarysearch;
public class WoodCut {
	private boolean C(int[] L, int k, int x) {
		int sum = 0;
		for (int l : L) {
			sum += l / x;
		}
		return sum >= k;
	}
	public int woodCut(int[] L, int K) {
		// write your code here
		if (L == null || L.length == 0)
			return 0;
		int lb = 0, ub = Integer.MAX_VALUE;
		while (lb + 1 < ub) {
			int mid = lb + (ub - lb) / 2;
			if (C(L, K, mid)) {
				lb = mid;
			} else {
				ub = mid;
			}
		}
		return lb;
	}
}
