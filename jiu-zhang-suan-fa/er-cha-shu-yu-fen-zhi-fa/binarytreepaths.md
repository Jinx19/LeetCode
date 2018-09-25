# Binary Tree Paths

## 分治

```java
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */

    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        //注意对叶子结点的处理
        if(root.left == null && root.right == null){
            list.add("" + root.val);
            return list;
        }
        List<String> leftPath = binaryTreePaths(root.left);
        List<String> rightPath = binaryTreePaths(root.right);

        for(String path : leftPath){
            list.add(root.val + "->" + path);
        }

        for(String path : rightPath){
            list.add(root.val + "->" + path);
        }

        return list;

    }
}
```

## 递归

```java
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public void helper(TreeNode root,String path,List<String> result){
        if(root.left == null && root.right == null){
            result.add(path);
            return;
        }
        
        if(root.left != null){
            helper(root.left,path + "->" + (root.left).val,result);
        }
        
        if(root.right != null){
            helper(root.right,path + "->" + (root.right).val,result);
        }
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        helper(root,"" + root.val,list);
        return list;
    }
}
```



