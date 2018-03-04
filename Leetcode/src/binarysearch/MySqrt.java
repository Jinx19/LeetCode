package binarysearch;

public class MySqrt {
	public static int mySqrt(int x) {
		if (x == 0)
			return 0;
		int start = 1, end = x;
		while (start + 1 < end) {
			int mid =  (start + (end - start) / 2);
			Long mid2 = (long)mid * mid;
			if (mid2 == x ) {
				return mid;
			} else if (mid2 > x) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(2147395599));
	}

}
