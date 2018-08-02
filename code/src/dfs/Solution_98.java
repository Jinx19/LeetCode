package dfs;

import tree.TreeNode;

/**
 * Created by mac on 2018/7/8.
 * Validate Binary Search Tree
 */
public class Solution_98 {
    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return isMonotonicIncreasing(root);
    }

    private boolean isMonotonicIncreasing(TreeNode p) {
        if (p == null) return true;
        if (isMonotonicIncreasing(p.left)) {
            if (prev != null && p.val <= prev.val) return false;
            prev = p;
            return isMonotonicIncreasing(p.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        Solution_98 solution_98 = new Solution_98();
        solution_98.isValidBST(root);

    }

}
