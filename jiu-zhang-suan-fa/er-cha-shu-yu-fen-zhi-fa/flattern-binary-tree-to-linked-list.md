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



