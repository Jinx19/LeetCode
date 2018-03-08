package tree;

public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		return validateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public boolean validateBST(TreeNode root,int minVal,int maxVal) {
		if(root == null) return true;
		if(root.val <= minVal || root.val >= maxVal) return false;
		return validateBST(root.left, minVal, root.val)&&validateBST(root.right, root.val, maxVal);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(7);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);
		IsValidBST iv = new IsValidBST();
		System.out.println(iv.isValidBST(root));
	}
}
