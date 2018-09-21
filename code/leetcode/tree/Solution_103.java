package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/9/12.
 */
public class Solution_103 {
    public void zigzagLevelOrderHelper(TreeNode root,List<List<Integer>> ans,int level){
        if(root == null){
            return ;
        }
        if(level > ans.size() - 1){
            ans.add(new ArrayList<>());
        }

        ArrayList<Integer> array = (ArrayList<Integer>) ans.get(level);
        if(level % 2 == 0){
            array.add(root.val);
        }else {
            array.add(0,root.val);
        }
        zigzagLevelOrderHelper(root.left,ans,level+1);
        zigzagLevelOrderHelper(root.right,ans,level+1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        zigzagLevelOrderHelper(root,ans,0);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution_103 solution = new Solution_103();
        solution.zigzagLevelOrder(root);
    }
}

