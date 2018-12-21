package code.leetcode.string;

public class RotateString {
	public boolean rotateString(String A, String B) {
		if(A.equals(B)) return true;
		StringBuilder sb = new StringBuilder();
		sb.append(A.substring(1));
		sb.append(A.charAt(0));
		System.out.println(sb.toString());
		return sb.toString().equals(B);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateString rs = new RotateString();
		System.out.println(rs.rotateString("abcde", "cdeab"));
		
	}

}
