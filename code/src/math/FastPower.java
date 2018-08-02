package math;

public class FastPower {
	public static int fastPower(int a, int b, int n) {
		if (n == 1) {
			return a % b;
		} else if (n == 0) {
			return 1 % b;
		} else if (n < 0) {
			return -1;
		}

		long product = fastPower(a, b, n / 2);
		//(a*b)%p = ((a%p) * (b%p))%p
		product = (product * product) % b;

		if (n % 2 == 1) {
			product = (product * a) % b;
		}

		return (int) product;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fastPower(3, 7, 5));
	}

}
