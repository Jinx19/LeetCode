# 二叉树最大深度

## 分治

```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        int maxdepth = 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left,right) + 1;
    }
}
```

## 递归

```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
     private int depth;
     public void helper(TreeNode root,int curDepth){
         if(root == null){
             return;
         }
         if(curDepth > depth){
             depth = curDepth;
         }
         
         helper(root.left,curDepth + 1);
         helper(root.right,curDepth + 1);
         
     }
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
       depth = 0;
       helper(root,1);
       return depth;
    }
}
```

## 非递归\(利用层次遍历\)

```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            for(int i = 0 ; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return depth;
    }
}
```



