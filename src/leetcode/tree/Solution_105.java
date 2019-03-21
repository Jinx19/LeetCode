package leetcode.tree;

class ResultType {
    public TreeNode root;
    public int start;
    public int end;

    public ResultType(TreeNode root, int start, int end) {
        this.root = root;
        this.start = start;
        this.end = end;
    }
}

public class Solution_105 {
    public int index;

    public void helper(ResultType resultType, int[] preorder, int[] inorder) {

        if (resultType.start == resultType.end) {
            return;
        }

        TreeNode root = resultType.root;
        int rootVal = root.val;
        int divide = -1;
        int start = resultType.start;
        int end = resultType.end;

        for (int i = start; i <= end; i++) {
            if (inorder[i] == rootVal) {
                divide = i;
                break;
            }
        }
        if(divide ==  start){
            TreeNode node = new TreeNode(preorder[++index]);
            ResultType resultRight = new ResultType(node,divide + 1,end);
            root.right = resultRight.root;
            helper(resultRight, preorder, inorder);
        }else if(divide == end){
            TreeNode node = new TreeNode(preorder[++index]);
            ResultType resultLeft = new ResultType(node,start,divide - 1);
            root.left = resultLeft.root;
            helper(resultLeft, preorder, inorder);
        }else{
            TreeNode node = new TreeNode(preorder[++index]);
            ResultType resultLeft = new ResultType(node, start, divide - 1);
            root.left = resultLeft.root;
            helper(resultLeft, preorder, inorder);

            node = new TreeNode(preorder[++index]);
            ResultType resultRight = new ResultType(node, divide + 1, end);
            root.right = resultRight.root;
            helper(resultRight, preorder, inorder);
        }

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        index = 0;
        TreeNode root = new TreeNode(preorder[0]);
        int start = 0;
        int end = inorder.length - 1;
        ResultType result = new ResultType(root, start, end);
        helper(result, preorder, inorder);

        return result.root;
    }
}
