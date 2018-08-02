package tree;

public class ConstructStringFromBinaryTree {
	public String tree2str(TreeNode t) {
		if(t == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(t.val);
		String sl = "";
		String sr = "";
		
		if(t.left != null) {
			sl = tree2str(t.left);
			sb.append("(" + sl + ")");
		}else if(t.right != null){
			sb.append("()");
		}
		
		if(t.right != null) {
			sr = tree2str(t.right);
			sb.append("(" + sr + ")");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		
		ConstructStringFromBinaryTree  csfb = new ConstructStringFromBinaryTree();
		System.out.println(csfb.tree2str(root));
	}
}
