package code.leetcode.tree;

/**
 * Created by mac on 2018/7/16.
 */
public class ConvertBinarySearchTree {
    TreeNode plast = null;
    private void  ConvertNode(TreeNode pNode){
        if(pNode == null){
            return;
        }

        TreeNode p = pNode;
        if(p.left != null){
            ConvertNode(p.left);
        }

        p.left = plast;

        if(plast != null){
            plast.right = p;
        }

        plast = p;

        if(p.right != null){
            ConvertNode(p.right);
        }

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertNode(pRootOfTree);

        TreeNode head = plast;
        while(head != null && head.left != null){
            head = head.left;
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        ConvertBinarySearchTree convertBinarySearchTree = new ConvertBinarySearchTree();
        convertBinarySearchTree.Convert(root);
    }
}
