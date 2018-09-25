# 前序遍历

## 递归

```java
public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    private List<Integer> list = new ArrayList<>();
    public void helper(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        helper(root,list);
        return list;
    }
}
```

## 非递归

```java
public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
   
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            list.add(node.val);
            if(node.right != null){
                s.push(node.right);
            }
            
            if(node.left != null){
                s.push(node.left);
            }
        }
        return list;
    }
}
```

# 中序遍历

## 递归

```java
public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public void helper(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }
}
```

## 非递归

```java
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
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
        return list;
    }
}
```

# 后序遍历

## 递归

```java
public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public void helper(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        helper(root.left,list);
        helper(root.right,list);
        list.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }
}
```

## 非递归

```java
public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> q = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            q.push(node.val);
            if(node.left != null){
                s.push(node.left);
            }
            if(node.right != null){
            s.push(node.right);
            }
        }
        while(!q.isEmpty()){
            list.add(q.pop());
        }
        return list;
    }
}
```

```java
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null; // previously traversed node
    TreeNode curr = root;

    if (root == null) {
        return result;
    }

    stack.push(root);
    while (!stack.empty()) {
        curr = stack.peek();
        if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
            if (curr.left != null) {
                stack.push(curr.left);
            } else if (curr.right != null) {
                stack.push(curr.right);
            }
        } else if (curr.left == prev) { // traverse up the tree from the left
            if (curr.right != null) {
                stack.push(curr.right);
            }
        } else { // traverse up the tree from the right
            result.add(curr.val);
            stack.pop();
        }
        prev = curr;
    }

    return result;
}
```



