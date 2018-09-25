```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if(Math.abs(right - left) > 1 || left == -1 || right == -1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(maxDepth(root) == -1){
            return false;
        }else{
            return true;
        }
    }
}
```

https://leetcode.com/problems/balanced-binary-tree/description/

