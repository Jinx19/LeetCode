package code.leetcode.bit;

public class AplusB {
	public static int aplusb(int a, int b) {
		//部分和
		int result = a ^ b;
		//进位
		int carry = a & b;
		//进位左移1位
		carry <<= 1;
		if (carry != 0) {
			result = aplusb(result, carry);
		}
		return result;
	}
	public static void main(String[] args) {
		aplusb(3	, 5);
	}
}
