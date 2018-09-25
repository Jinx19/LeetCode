Given a binary tree ,find the subtree with minimum sum.return the root of the subtree;

分治+递归

```java
public class Solution{
    private TreeNode subtree = null;
    private int subtreeSum = Integer.MAX_VALUE;
    
    public TreeNode findSubtree(TreeNode root){
        helper(root);
        return subtree;
    }
    
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int sum = helper(root.left) + helper(root.right) + root.val;
        
        if(sum < subtreeSum){
            subtreeSum = sum;
            subtree = root;
        }
        
        return sum;
    }
}
```



