package tree;

/**
 * Created by mac on 2018/7/18.
 */
public class IsBalancedTree {
    private class MyDepth{
        public int depth;
        public MyDepth(int depth){
            this.depth = depth;
        }

    }
    private boolean IsBalanced(TreeNode root,MyDepth depth){
        if(root == null){
            depth.depth = 0;
            return true;
        }
        MyDepth left = new MyDepth(0);
        MyDepth right = new MyDepth(0);

        if(IsBalanced(root.left,left) && IsBalanced(root.right,right)){
            int diff = Math.abs(left.depth - right.depth);
            if(diff <= 1){
                depth.depth = 1 + Math.max(left.depth,right.depth);
                return true;
            }
        }
        return false;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        MyDepth depth = new MyDepth(0);
        return IsBalanced(root,depth);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.right.left = new TreeNode(6);
        IsBalancedTree isBalancedTree = new IsBalancedTree();
        System.out.println(isBalancedTree.IsBalanced_Solution(treeNode));
    }
}
