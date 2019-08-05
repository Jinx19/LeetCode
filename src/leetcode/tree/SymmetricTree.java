package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelArray = new ArrayList<>();
            for(int i = 0;i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                    levelArray.add(node.left.val);
                }else{
                    levelArray.add(null);
                }

                if(node.right != null){
                    queue.offer(node.right);
                    levelArray.add(node.right.val);
                }else{
                    levelArray.add(null);
                }
            }
            int start = 0,end = levelArray.size() - 1;
            while(start < end){
                if(levelArray.get(start) != levelArray.get(end)){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(SymmetricTree.isSymmetric(root));
    }
}
