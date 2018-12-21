package leetcode.bitmainpulation;

/**
 * 762. Prime Number of Set Bits in Binary Representation
 * 
 * @author jinx19
 *
 */
public class Solution762 {
	public boolean isPrime(int i) {
		if(i == 1) return false;
		if(i == 2) return true;
		for (int j = 2; j <= Math.sqrt(i); j++) {
			if (i % j == 0) {
				System.out.println("isPrime" + i + ":" + false);
				return false;
			}
		}
		System.out.println("isPrime " + i + ":" + true);
		return true;
	}

	public int getSetSize(int num) {
		int temp = num;
		int count = 0;
		int j = num / 2;
		int i = num % 2;
		while (j != 0) {
			if(i == 1) {
				count++;
			}
			num = j;
			j = num / 2;
			i = num % 2;
		}
		if (num % 2 != 0) {
			count++;
		}
		System.out.println(temp + "getSetSize: "  + count);
		return count;
	}

	public int countPrimeSetBits(int L, int R) {
		int count = 0;
		for (int i = L; i <= R; i++) {
			if (isPrime(getSetSize(i))) {
				count++;
			}
		}
		System.out.println("count : "  + count);

		return count;
	}
	
	public static void main(String[] args) {
		Solution762 solution = new Solution762();
		int count = solution.countPrimeSetBits(842,888);
		
		
	}
}
