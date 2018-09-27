### 将二叉查找树转换成双链表

将一个二叉查找树按照中序遍历转换成双向链表。

### 样例

给定一个二叉查找树：

```
    4
   / \
  2   5
 / \
1   3
```

返回`1<->2<->3<->4<->5`。

```java
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    private DoublyListNode head = null;
    private DoublyListNode prev = null;
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        if(prev == null){
            prev = new DoublyListNode(root.val);
            head = prev;
        }else{
            DoublyListNode node = new DoublyListNode(root.val);
            prev.next = node;
            node.prev = prev;
            prev = prev.next;
        }
        helper(root.right);
    }
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        helper(root);
        return head;
    }
}
```

[https://www.jiuzhang.com/solutions/flatten-binary-tree-to-linked-list/](https://www.jiuzhang.com/solutions/flatten-binary-tree-to-linked-list/)

```java
// Version 1: Traverse
public class Solution {
    private TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}

// version 2: Divide & Conquer
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        helper(root);
    }

    // flatten root and return the last node
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);

        // connect leftLast to root.right
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightLast != null) {
            return rightLast;
        }

        if (leftLast != null) {
            return leftLast;
        }

        return root;
    }
}

// version 3: Non-Recursion
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            // connect 
            node.left = null;
            if (stack.empty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }
}
```



