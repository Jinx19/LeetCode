package tree;

public class Codec2 {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		helper(sb, root);
		System.out.println(sb.toString());
		return sb.toString();
	}

	public void helper(StringBuilder sb, TreeNode node) {
		if (node == null) {
			return;
		}
//		char c = (char)(node.val);
		sb.append(node.val).append(",");
		helper(sb, node.left);
		helper(sb, node.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] input = data.split(",");
//		char[] input = data.toCharArray();
		return helper2(input, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	int index = 0;

	public TreeNode helper2(String[] input, int min, int max) {
		if (index >= input.length || Integer.valueOf(input[index]) > max || Integer.valueOf(input[index]) < min) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.valueOf(input[index++]));
		root.left = helper2(input, min, root.val);
		root.right = helper2(input, root.val, max);
		return root;
	}
	
	public static void main(String[] args) {
		Codec2 code = new Codec2();
		TreeNode root = new TreeNode(11);
		root.left = new TreeNode(3);
		root.right = new TreeNode(14);
				
//		code.serialize(root);
		TreeNode newtree = code.deserialize(code.serialize(root));
	}
}
