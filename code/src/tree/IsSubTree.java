package tree;

/**
 * Created by mac on 2018/7/16.
 */
public class IsSubTree {
    boolean ret = false;
    private boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return DoesTree1HasTree2(root1.left, root2.left) && DoesTree1HasTree2(root1.right, root2.right);
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                ret = DoesTree1HasTree2(root1, root2);
            }

            if(ret == false){
                HasSubtree(root1.left, root2);
                HasSubtree(root1.right, root2);
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(8);
        tree1.left = new TreeNode(8);
        tree1.right = new TreeNode(7);
        tree1.left.left = new TreeNode(9);
        tree1.left.right = new TreeNode(2);
        tree1.left.right.left = new TreeNode(4);
        tree1.left.right.right = new TreeNode(7);

        TreeNode tree2 = new TreeNode(8);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(2);

        IsSubTree isSubTree = new IsSubTree();
        System.out.println(isSubTree.HasSubtree(tree1,tree2));
    }
}
