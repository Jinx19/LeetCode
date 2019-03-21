package leetcode.tree;
import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mac on 2018/7/10.
 */
public class Solution_866 {
    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxdepth = getMaxDepth(root);
        if (maxdepth == 1) {
            return root;
        }
        int reminder = maxdepth - 1;
        int depthleft = 0,depthright = 0,size = 0;
        TreeNode ret = null, node = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty() && reminder != 0) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                depthleft = getMaxDepth(node.left);
                depthright = getMaxDepth(node.right);
                if (depthleft == reminder && depthright == reminder) {
                    ret = node;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            reminder--;
        }
        if(ret == null && !queue.isEmpty()){
            ret = queue.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        Solution_866 solution = new Solution_866();
        solution.subtreeWithAllDeepest(root);
    }
}
