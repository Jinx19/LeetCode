### 验证二叉查找树

给定一个二叉树，判断它是否是合法的二叉查找树\(BST\)

一棵BST定义为：

* 节点的左子树中的值要**严格**小于该节点的值。
* 节点的右子树中的值要**严格**大于该节点的值。
* 左右子树也必须是二叉查找树。
* 一个节点的树也是二叉查找树。

```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private long max = Long.MAX_VALUE;
    private long min = Long.MIN_VALUE;
    private boolean isValidBST = true;
    public void helper(TreeNode root, long max,long min){
        if(root == null){
            return;
        }
        if(root.val >= max || root.val <= min){
            isValidBST = false;
            return;
        }
        helper(root.left,root.val,min);
        helper(root.right,max,root.val);
        return;
    }
    public boolean isValidBST(TreeNode root) {
        // write your code here
        helper(root,max,min);
        return isValidBST;
    }
}
```

更规范的写法:

```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean divConq(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        return divConq(root.left, min, Math.min(max, root.val)) && 
                divConq(root.right, Math.max(min, root.val), max);
    }
}
```

非递归, 利用中序遍历非降的特性

```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        boolean isValidBST = true;
        List<Integer> list = new ArrayList<>();
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while(p != null){
            stack.push(p);
            p = p.left;
        }
        while(!stack.isEmpty()){
            p = stack.pop();
            list.add(p.val);
            if(p.right != null){
                p = p.right;
                while(p != null){
                    stack.push(p);
                    p = p.left;
                }
            }
        }
        int pre = list.get(0);
        
        for(int i = 1 ; i < list.size(); i++){
            if(pre >= list.get(i)){
                isValidBST = false;
                break;
            }
            pre = list.get(i);
        }
        return isValidBST;
    }
}
```



